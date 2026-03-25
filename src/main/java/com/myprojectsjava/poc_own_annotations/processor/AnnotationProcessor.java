package com.myprojectsjava.poc_own_annotations.processor;


import com.myprojectsjava.poc_own_annotations.annotations.Advice;
import com.myprojectsjava.poc_own_annotations.annotations.Important;
import com.myprojectsjava.poc_own_annotations.annotations.Note;

import java.lang.reflect.Field;
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

    public static void processRunTask() {

    }

}