package com.example.sb4_component_service_repository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Sb4ComponentServiceRepositoryApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Sb4ComponentServiceRepositoryApplication.class, args);

		//Lấy ra bean GirlService
		GirlService girlService = context.getBean(GirlService.class);

		Girl girl = girlService.getGirl();

		System.out.println(girl);
	}

}
