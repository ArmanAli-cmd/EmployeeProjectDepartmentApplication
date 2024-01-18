package com.deloitte.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.deloitte.dto.Employee;

@FeignClient(name = "EMPLOYEE-SERVICE")
public interface EmployeeFeign {

	@GetMapping("/employees/project/{projectId}/employees")
	public List<Employee> GetAllEmployeesByProjectId(@PathVariable long projectId);
}
