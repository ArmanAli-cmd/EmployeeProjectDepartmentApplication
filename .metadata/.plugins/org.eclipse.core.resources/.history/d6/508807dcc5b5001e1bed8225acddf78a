package com.deloitte.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.deloitte.dto.Department;

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface DepartmentFeign {

	@GetMapping("/departments/{id}")
	public Department getById(@PathVariable long id);
}
