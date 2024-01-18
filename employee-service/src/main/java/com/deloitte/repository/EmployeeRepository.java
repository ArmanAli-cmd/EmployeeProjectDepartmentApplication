package com.deloitte.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deloitte.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	Employee findByEmail(String email);
	Employee findByEmailAndPassword(String email, String password);
	List<Employee> findByDepartmentId(long departmentId);
	List<Employee> findByProjectId(long projectId);
}
