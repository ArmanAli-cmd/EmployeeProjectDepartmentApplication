package com.deloitte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.entity.Project;
import com.deloitte.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService{

	@Autowired
	ProjectRepository repository;
	
	@Override
	public Project addOrUpdate(Project project) {
		// TODO Auto-generated method stub
		return repository.save(project);
		//return null;
	}

	@Override
	public Project searchById(long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<Project> viewAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

}
