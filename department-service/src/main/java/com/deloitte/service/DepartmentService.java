package com.deloitte.service;

import java.util.List;

import com.deloitte.entity.Department;

public interface DepartmentService {

	Department addOrUpdate(Department department);
	Department searchById(long id);
	List<Department> viewAll();
	Department getByDepartmentName(String name);
}
