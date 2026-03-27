package com.myprojectsjava.poc_own_annotations;

import com.myprojectsjava.poc_own_annotations.model.*;
import com.myprojectsjava.poc_own_annotations.processor.AnnotationProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PocOwnAnnotationsApplication {

	public static void main(String[] args) {

		AnnotationProcessor.process(StudyClass.class);
		System.out.println();
		AnnotationProcessor.processStudyJava(StudyJava.class);
		System.out.println();
		AnnotationProcessor.processRunTask(Task.class);
		System.out.println();
		AnnotationProcessor.processValidation();
		System.out.println();
		AnnotationProcessor.processInherit(ExtendedInstruction.class);
	}

}
