package com.myprojectsjava.poc_own_annotations.model;

import com.myprojectsjava.poc_own_annotations.annotations.Param;

public class Activity {
    public void execute(@Param("userId") String id,
                        @Param("action") String action) {

        System.out.println("ID: " + id);
        System.out.println("Action: " + action);
    }
}
