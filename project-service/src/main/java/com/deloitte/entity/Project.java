package com.deloitte.entity;


import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;

@Entity
@Table(name = "project")
public class Project {

	@Id
	@Column(name="project_id")
	@TableGenerator(name = "pr_seq",table = "pr_seq_tab", pkColumnName="pr_pk", valueColumnName = "pr_val", pkColumnValue = "pr",
	initialValue = 2000, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "pr_seq")
	private long id;
	private String name;
	private String technology;
	private LocalDate startDate;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	
	
}
