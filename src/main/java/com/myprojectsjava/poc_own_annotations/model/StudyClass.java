package com.myprojectsjava.poc_own_annotations.model;

import com.myprojectsjava.poc_own_annotations.annotations.Important;
import com.myprojectsjava.poc_own_annotations.annotations.Note;

@Note("Essa classe esta sendo usanda como exemplo para estudar Reflactions...")
public class StudyClass {

    @Note("Usuario Name Field")
    private String name;

    @Important
    public void execute() {
        System.out.println("Executing...");
    }
}