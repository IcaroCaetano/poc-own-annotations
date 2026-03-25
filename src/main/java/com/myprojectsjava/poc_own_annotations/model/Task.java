package com.myprojectsjava.poc_own_annotations.model;

import com.myprojectsjava.poc_own_annotations.annotations.Run;

public class Task {

    @Run
    public void execute(){
        System.out.println("Rodando tarfefa ..");
    }
}
