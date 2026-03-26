package com.myprojectsjava.poc_own_annotations.model;

import com.myprojectsjava.poc_own_annotations.annotations.MaxLength;
import com.myprojectsjava.poc_own_annotations.annotations.NotNull;

public class StudySpring {

    @NotNull
    private String name;

    @MaxLength(10)
    private String nickname;
}
