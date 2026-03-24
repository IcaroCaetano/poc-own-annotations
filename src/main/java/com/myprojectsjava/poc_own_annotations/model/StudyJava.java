package com.myprojectsjava.poc_own_annotations.model;

import com.myprojectsjava.poc_own_annotations.annotations.Advice;
import com.myprojectsjava.poc_own_annotations.annotations.Important;

import java.sql.Timestamp;

@Advice(value = "2", priority = 1, author = "Icaro")
public class StudyJava {

    @Advice(value = "Estude breve", priority = 3, author = "Icaro")
    private String matter;

    @Advice(value = "Agende para amanha", priority = 2, author = "Icaro")
    public void start(Timestamp time) {}

    @Important(value = "Estude Amanha")
    public void schedule(Timestamp start, Timestamp end){}
}
