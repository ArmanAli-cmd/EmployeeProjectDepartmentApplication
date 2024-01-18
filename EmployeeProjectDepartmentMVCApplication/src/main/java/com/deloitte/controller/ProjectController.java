package com.deloitte.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.deloitte.client.ProJectFeign;
import com.deloitte.dto.Project;

@Controller
@RequestMapping("/projects")
public class ProjectController {

	@Autowired
	ProJectFeign proJectFeign;

	@RequestMapping(path = "add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = {
			MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ModelAndView addProject(Project project) {
		ModelAndView mv = new ModelAndView();
		try {
			Project project2 = proJectFeign.addProject(project);
			if (project2 != null) {
				mv.addObject("msz", "Project added successfully!");
			} else {
				mv.addObject("msz", "Bad request");
			}
		} catch (Exception e) {
			mv.addObject("msz", e.getMessage());
		}
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping("")
	public ModelAndView getAllProjects() {
		ModelAndView mv = new ModelAndView();
		try {
			List<Project> projects =  proJectFeign.getAllProjects();
			mv.addObject("projects", projects);
			mv.setViewName("projects");
		}
		catch (Exception e) {
			// TODO: handle exception
			mv.addObject("msz", e.getMessage());
			mv.setViewName("index");
		}
		return mv;
	}
}
