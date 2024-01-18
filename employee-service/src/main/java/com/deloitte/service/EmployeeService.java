package com.deloitte.service;

import java.util.List;

import com.deloitte.entity.Employee;
import com.deloitte.exception.IdNotFoundException;

public interface EmployeeService {

	Employee addOrUpdate(Employee employee) throws IdNotFoundException;
	Employee searchById(long id);
	List<Employee> viewAll();
	Employee getEmployeeByEmail(String email);
	List<Employee> searchByDepartmentId(long departmentId);
	List<Employee> searchByProjectId(long projectId);
	void delete(long id);
}
