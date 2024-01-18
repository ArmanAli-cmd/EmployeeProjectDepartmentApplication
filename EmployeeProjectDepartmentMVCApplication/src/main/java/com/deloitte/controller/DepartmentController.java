package com.deloitte.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.deloitte.client.DepartmentFeign;
import com.deloitte.dto.Department;

@Controller
@RequestMapping("/departments")
public class DepartmentController {

	@Autowired
	DepartmentFeign departmentFeign;
	
	@RequestMapping(path = "add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = {
			MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ModelAndView addDepartment(Department department) {
		ModelAndView mv = new ModelAndView();
		try {
			Department department2 = departmentFeign.addDepartment(department);
			if(department2!=null) {
				mv.addObject("msz", "Department added successfully");
				
			}
			else {
				mv.addObject("msz", "Department not added");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			mv.addObject("msz","Exception occurred");
		}
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping("")
	public ModelAndView getAllDepartments() {
		ModelAndView mv= new ModelAndView();
		try {
			List<Department> departments = departmentFeign.getAllDepartments();
			mv.addObject("departments", departments);
			mv.setViewName("departments");
			
		} catch (Exception e) {
			// TODO: handle exception
			mv.addObject("msz", "Exception occurred");
			mv.setViewName("index");
		}
		return mv;
	}
	
}
