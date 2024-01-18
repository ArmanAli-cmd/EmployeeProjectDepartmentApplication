package com.deloitte.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.deloitte.client.EmployeeFeign;
import com.deloitte.dto.Employee;
import com.deloitte.dto.EmployeeProjectDepartmentResponse;
import com.deloitte.dto.Project;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/")
public class EmployeeController {

	@Autowired
	EmployeeFeign employeeFeign;

	@GetMapping("")
	public ModelAndView requestMethodName() {
		System.out.println("default method triggered ");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		mv.addObject("msz", "Welcome to employee project department management application");
		return mv;
	}

	@RequestMapping(path = "employees/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = {
			MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ModelAndView postMethodName(Employee employee) {
		// TODO: process POST request
		ModelAndView mv = new ModelAndView();
		System.out.println("add method triggered");
		if (employee != null) {
			try {
				ResponseEntity<?> result = employeeFeign.register(employee);
				if (result.getBody() != null) {
					System.out.println("added");
					mv.addObject("msz", "Employee registered successfully!");
				} else {
					System.out.println("not added without exception");
					mv.addObject("msz", "Bad request");
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("not added, exception occurred");
				System.out.println(e.getMessage());
				mv.addObject("msz", "Bad request");
			}
		}
		mv.setViewName("index");

		return mv;
	}
	
	@RequestMapping("employees")
	public ModelAndView getAllEmployees() {
		ModelAndView mv = new ModelAndView();
		try {
			List<Employee> employees = employeeFeign.getAllEmployees();
			mv.addObject("employees", employees);
			mv.setViewName("employees");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("not fetched, exception occurred");
			System.out.println(e.getMessage());
			mv.addObject("msz", "Employee service does not running");
			mv.setViewName("index");
		}
		return mv;
	}

	@RequestMapping("employee-details/{id}")
	public ModelAndView getEmployeeDetails(@PathVariable long id) {
		ModelAndView mv = new ModelAndView();
		try {
			EmployeeProjectDepartmentResponse employeeDetails = employeeFeign.getEmployeeDetails(id);
			mv.addObject("employee-details", employeeDetails);
			
			List<Employee> employees = employeeFeign.GetAllEmployeesByProjectId(employeeDetails.getProject().getId());
			mv.addObject("project-team-size", employees.size());
			
			List<Employee> employees2= employeeFeign.GetAllEmployeesByDepartmentId(employeeDetails.getDepartment().getId());
			mv.addObject("total-employees", employees2.size());
			mv.setViewName("employee-details");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("not fetched, exception occurred");
			System.out.println(e.getMessage());
			mv.addObject("msz", "Employee service does not running");
			mv.setViewName("index");
		}
		return mv;
	}
	
	@RequestMapping("projects/{projectId}/employees")
	public ModelAndView getAllEmployeesByProjectId(@PathVariable long projectId) {
		ModelAndView mv = new ModelAndView();
		try {
			List<Employee> employees = employeeFeign.GetAllEmployeesByProjectId(projectId);
			mv.addObject("employees", employees);
			mv.setViewName("employees");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("not fetched, exception occurred");
			System.out.println(e.getMessage());
			mv.addObject("msz", "Employee service does not running");
			mv.setViewName("index");
		}
		return mv;
	}
	
	@RequestMapping("departments/{departmentId}/employees")
	public ModelAndView getAllEmployeesByDepartmentId(@PathVariable long departmentId) {
		ModelAndView mv = new ModelAndView();
		try {
			List<Employee> employees = employeeFeign.GetAllEmployeesByDepartmentId(departmentId);
			mv.addObject("employees", employees);
			mv.setViewName("employees");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("not fetched, exception occurred");
			System.out.println(e.getMessage());
			mv.addObject("msz", "Employee service does not running");
			mv.setViewName("index");
		}
		return mv;
	}
	
	@RequestMapping("employees/delete/{id}")
	public ModelAndView deleteEmployee(@PathVariable long id) {
		ModelAndView mv = new ModelAndView();
		try {
			ResponseEntity<String> result = employeeFeign.deleteEmployee(id);
			List<Employee> employees = employeeFeign.getAllEmployees();
			mv.addObject("employees", employees);
			mv.setViewName("employees");
			mv.addObject("msz", result.getBody());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			mv.addObject("msz", "Employee service does not running");
			mv.setViewName("index");
		}
		return mv;
	}
	
}
