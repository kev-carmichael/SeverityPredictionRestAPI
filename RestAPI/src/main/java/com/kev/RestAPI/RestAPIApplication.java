package com.kev.RestAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class RestAPIApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestAPIApplication.class, args);
	}

}
