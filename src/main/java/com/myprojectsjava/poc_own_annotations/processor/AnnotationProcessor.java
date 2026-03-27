package com.myprojectsjava.poc_own_annotations.processor;


import com.myprojectsjava.poc_own_annotations.annotations.*;
import com.myprojectsjava.poc_own_annotations.model.StudySpring;
import com.myprojectsjava.poc_own_annotations.model.Task;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


public class AnnotationProcessor {

    public static void process(Class<?> clazz) {
        System.out.println("Processing class: " + clazz.getName());

        // Class annotations
        if (clazz.isAnnotationPresent(Note.class)) {
            Note note = clazz.getAnnotation(Note.class);
            System.out.println("Class Note: " + note.value());
        }

        // Exemplo de metodos com Fields
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Note.class)) {
                Note note = field.getAnnotation(Note.class);
                System.out.println("Field: " + field.getName() + " -> " + note.value());
            }
        }

        // Exemplo de metods com Reflecions
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Important.class)) {
                Important important = method.getAnnotation(Important.class);
                System.out.println("Important method: " + method.getName() + " Method Annotation: " + important.value());
            }
        }
    }

    public static void processStudyJava(Class<?> clazz){
        System.out.println("Processing class: " + clazz.getName());

        if (clazz.isAnnotationPresent(Advice.class)){
            Advice advice = clazz.getAnnotation(Advice.class);
            System.out.println("Annotation with advice value: " + advice.value());
            System.out.println("Annotation with advice priority: " + advice.priority());
            System.out.println("Annotation with author: " + advice.author());
        }

        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Advice.class)) {
                Advice advice = field.getAnnotation(Advice.class);
                System.out.println("Field: " + field.getName() + " Value: " + advice.value());
                System.out.println("Field: " + field.getName() + " Priority: " + advice.priority());
                System.out.println("Field: " + field.getName() + " Author: " + advice.author());
            }
        }

        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Advice.class)) {
                Advice advice = method.getAnnotation(Advice.class);
                System.out.println("Method: " + method.getName() + " Value: " + advice.value());
                System.out.println("Method: " + method.getName() + " Priority: " + advice.priority());
                System.out.println("Method: " + method.getName() + " Author: " + advice.author());
            } else if (method.isAnnotationPresent(Important.class)) {
                Important important = method.getAnnotation(Important.class);
                System.out.println("Method: " + method.getName() + " Value: " + important.value());
            }
        }
    }

    public static void processRunTask(Class<?> clazz) {
        System.out.println("Processing Class: " + clazz.getName());

        try {
            Object instance = clazz.getDeclaredConstructor().newInstance();
            /**
             * Task.class - metadado da classe Task
             * getDeclaredConstructor - busca o contrutor da classe
             * newInstance() - Executa o construtor e cria o objeto
             */

            for (Method method : clazz.getDeclaredMethods()){
                if (method.isAnnotationPresent(Run.class)){
                    // Executa esse metodo usando reflection
                    method.invoke(instance);
                }
            }

            Constructor<Task> constructor = Task.class.getDeclaredConstructor();
            System.out.println("Cosntructor: " + constructor.getName());

        } catch (Exception e){
            throw new RuntimeException("Erro ao instanciar " + clazz.getName(), e);
        }
    }

    public static void processValidation(){
        StudySpring student1 = new StudySpring(null, "singleton");
        validator(student1);
        StudySpring student2 =  new StudySpring("Annotation", "singleton is a design partner");
        validator(student2);
        StudySpring student3 =  new StudySpring("Annotations can be defined", "test");
        validator(student3);
    }


    private static void validator(Object object) {
        Class<?> clazz = object.getClass();

        try {
            List<String> errors = new ArrayList<>();

            for (Field field : clazz.getDeclaredFields()){
                field.setAccessible(true);
                Object value = field.get(object);

                if (field.isAnnotationPresent(NotNull.class)) {
                    if (value == null) {
                        errors.add(field.getName() + " must not be null");
                    }
                }

                if (field.isAnnotationPresent(MaxLength.class)) {
                    MaxLength maxLength = field.getAnnotation(MaxLength.class);

                    if (maxLength != null && value instanceof String srt){
                        if (srt.length() > maxLength.value()){
                            errors.add(field.getName() + " exceeds max length of " + maxLength.value());
                        }
                    }
                }

                if (!errors.isEmpty()) {
                    System.out.println(object);
                    errors.forEach(System.out::println);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao instanciar " + clazz.getName(), e);
        }
    }


}