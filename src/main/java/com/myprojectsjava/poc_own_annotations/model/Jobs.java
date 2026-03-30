package com.myprojectsjava.poc_own_annotations.model;

import com.myprojectsjava.poc_own_annotations.annotations.Order;
import com.myprojectsjava.poc_own_annotations.annotations.Run;

class Jobs {

    @Run
    @Order(2)
    public void job2() {
        System.out.println("Job 2");
    }

    @Run
    @Order(1)
    public void job1() {
        System.out.println("Job 1");
    }

    @Run
    public void jobSemOrdem() {
        System.out.println("Job sem ordem");
    }
}