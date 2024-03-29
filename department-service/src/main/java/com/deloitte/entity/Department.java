package com.deloitte.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;

@Entity
@Table(name = "department")
public class Department {

	@Id
	@Column(name="department_id")
	@TableGenerator(name = "dr_seq",table = "dr_seq_tab", pkColumnName="dr_pk", valueColumnName = "dr_val", pkColumnValue = "dr",
	initialValue = 3000, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "dr_seq")
	private long id;
	private String name;
	private String location;
	
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
}
