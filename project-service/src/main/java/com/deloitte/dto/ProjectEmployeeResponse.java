package com.deloitte.dto;

import java.util.List;

import com.deloitte.entity.Project;

public class ProjectEmployeeResponse {

	private Project project;
	private List<Employee> employees;
	
	public ProjectEmployeeResponse(Project project, List<Employee> employees) {
		super();
		this.project = project;
		this.employees = employees;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	
}
