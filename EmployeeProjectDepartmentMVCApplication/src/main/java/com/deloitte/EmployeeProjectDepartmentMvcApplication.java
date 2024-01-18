package com.deloitte;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EmployeeProjectDepartmentMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeProjectDepartmentMvcApplication.class, args);
	}

}
