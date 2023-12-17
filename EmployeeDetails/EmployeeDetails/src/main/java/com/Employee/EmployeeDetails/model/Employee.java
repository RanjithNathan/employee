package com.Employee.EmployeeDetails.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Employee 
{
	@Id
	private Integer id;
	private Long sal;
	private String name;
	
	@OneToMany(mappedBy="emp")
	private List<Post> post;
	
	public Employee() {
		super();
		
	}


	public Employee(Integer id, Long sal,String name) {
		super();
		this.id = id;
		this.sal = sal;
		this.name = name;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Long getSal() {
		return sal;
	}


	public void setSal(Long sal) {
		this.sal = sal;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<Post> getPost() {
		return post;
	}


	public void setPost(List<Post> post) {
		this.post = post;
	}


	@Override
	public String toString() {
		//return "Employee [id=" + id + ", sal=" + sal + ", name=" + name + "]";
		return String.format("User [id=%s, name=%s, sal=%s]", id, name, sal);
	}






	



}
