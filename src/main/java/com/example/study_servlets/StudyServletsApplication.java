package com.example.study_servlets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan    // 얘가 들어가야 webservlet으로 지정한 애들을 listup 함. 그리고 나서 외부에서 요청한 경우 이를 찾아 
@SpringBootApplication
public class StudyServletsApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudyServletsApplication.class, args);
	}

}
