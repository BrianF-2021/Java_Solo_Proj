package com.brianfair.interviewalgos;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.brianfair.interviewalgos.controllers.UploaderController;

@SpringBootApplication
public class InterviewalgosApplication {

	public static void main(String[] args) {
		
//		new File(UploaderController.uploadDirectory).mkdir();
		SpringApplication.run(InterviewalgosApplication.class, args);
	}

}
