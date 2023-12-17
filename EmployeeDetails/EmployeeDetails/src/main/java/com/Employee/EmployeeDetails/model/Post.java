package com.Employee.EmployeeDetails.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Post {
	@Id
	private Integer id;
	private String  desc;
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	private Employee emp;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Employee getEmp() {
		return emp;
	}
	public void setEmp(Employee emp) {
		this.emp = emp;
	}
	@Override
	public String toString() 
	{
		//return "Post [id=" + id + ", desc=" + desc + ", emp=" + emp + "]";
		return String.format("Post [id=%s, desc=%s]", id, desc);
	}
	
}
