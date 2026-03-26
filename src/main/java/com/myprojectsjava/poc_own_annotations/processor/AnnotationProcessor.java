package com.myprojectsjava.poc_own_annotations.processor;


import com.myprojectsjava.poc_own_annotations.annotations.*;
import com.myprojectsjava.poc_own_annotations.model.Task;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


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

    public static void processValidation(Class<?> clazz) {
        try {
            Object instance = clazz.getDeclaredConstructor().newInstance();

            for (Field field : instance.getClass().getDeclaredFields()){
                field.setAccessible(true);
                if (field.isAnnotationPresent(NotNull.class)){
                    Object value = field.get(instance);
                    if (value != null) {
                        System.out.println("Value is: " + value.getClass().getName());
                    } else {
                        throw new RuntimeException(field.getName() + "is null");
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao instanciar " + clazz.getName(), e);
        }
    }


}