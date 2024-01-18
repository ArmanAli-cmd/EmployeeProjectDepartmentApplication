package com.deloitte.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.deloitte.dto.Project;

@FeignClient(name = "PROJECT-SERVICE")
public interface ProJectFeign {

	@GetMapping("/projects/{id}")
	public Project getProjectById(@PathVariable long id);
}
