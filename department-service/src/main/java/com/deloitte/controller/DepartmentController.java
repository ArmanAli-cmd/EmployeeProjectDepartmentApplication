package com.deloitte.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.client.EmployeeFeign;
import com.deloitte.dto.Employee;
import com.deloitte.entity.Department;
import com.deloitte.service.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

	@Autowired
	private DepartmentService service;
	@Autowired
	private EmployeeFeign employeeFeign;
	
	@PostMapping("add")
	public Department addProject(@RequestBody Department department) {
		return service.addOrUpdate(department);
	}
	
	@GetMapping("{id}")
	public Department getById(@PathVariable long id) {
		return service.searchById(id);
	}
	
	@GetMapping("")
	public List<Department> getAllDepartments(){
		return service.viewAll();
	}
	
	//1. get employees list by department name
	@GetMapping("{name}/employees")
	public ResponseEntity<?> getAllEmployeesByDepartmentName(@PathVariable String name){
		Department department = service.getByDepartmentName(name);
		if(department==null)return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Department does not exist.");
		return ResponseEntity.status(HttpStatus.OK).body(employeeFeign.GetAllEmployeesByDepartmentId(department.getId()));
		
	}
}
