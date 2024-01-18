package com.deloitte.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.client.DepartmentFeign;
import com.deloitte.client.ProJectFeign;
import com.deloitte.dto.Department;
import com.deloitte.dto.EmployeeProjectDepartmentResponse;
import com.deloitte.dto.Project;
import com.deloitte.entity.Employee;
import com.deloitte.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	@Autowired
	private ProJectFeign proJectFeign;
	@Autowired
	private DepartmentFeign departmentFeign;
	
	@PostMapping("add")
	public ResponseEntity<?> register(@RequestBody Employee employee) {
		try {
			
			Employee employee2 = service.addOrUpdate(employee);
			return ResponseEntity.status(HttpStatus.CREATED).body(employee2);
			
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		 
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable long id){
		try {
			service.delete(id);
			return ResponseEntity.status(HttpStatus.OK).body("Employee deleted successfully!");
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee does not exist.");
		}
	}
	
	@GetMapping("{id}")
	public Employee getById(@PathVariable long id) {
		return service.searchById(id);
	}
	
	@GetMapping("")
	public List<Employee> getAllEmployees(){
		return service.viewAll();
	}
	
	@GetMapping("email")
	public Employee getByEmail(String email) {
		return service.getEmployeeByEmail(email);
	}
	
	@GetMapping("employee-details/{id}")
	public EmployeeProjectDepartmentResponse getEmployeeDetails(@PathVariable long id) {
		Employee employee = service.searchById(id);
		Project project = proJectFeign.getProjectById(employee.getProjectId());
		Department department = departmentFeign.getById(employee.getDepartmentId());
		
		return new EmployeeProjectDepartmentResponse(employee, project, department);
	}
	
	@GetMapping("department/{departmentId}/employees")
	public List<Employee> GetAllEmployeesByDepartmentId(@PathVariable long departmentId) {
		return service.searchByDepartmentId(departmentId);
	}
	
	@GetMapping("project/{projectId}/employees")
	public List<Employee> GetAllEmployeesByProjectId(@PathVariable long projectId) {
		return service.searchByProjectId(projectId);
	}
}
