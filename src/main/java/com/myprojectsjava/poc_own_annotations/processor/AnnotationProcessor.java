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

        for (Field field : clazz.getFields()) {

        }
    }
}