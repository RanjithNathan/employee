package com.Employee.EmployeeDetails.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Employee.EmployeeDetails.Exception.UserNotFoundException;
import com.Employee.EmployeeDetails.model.Employee;
import com.Employee.EmployeeDetails.model.Post;
import com.Employee.EmployeeDetails.repository.EmployeeRepository;
import com.Employee.EmployeeDetails.repository.PostRepository;

@Service
public class EmployeeService {
 
	
	@Autowired
	EmployeeRepository repo;
	@Autowired
	PostRepository postrepo;
	
	public Employee create( Employee emp)
	{
		   return repo.save(emp);		
	}
	
	public List<Employee>getAllEmp()
	{
		return repo.findAll();
		
	}
	
	public Employee getEmpById(int id)
	{
		
		Optional<Employee> emp =repo.findById(id);
		if(!emp.isPresent())
		{
			throw new UserNotFoundException("id-"+id); 
		}
		return emp.get();
		
		
	}
	
	public void deleteEmpById(int id)
	{
		repo.deleteById(id);
	}
	//using finder methods
	public List<Employee> getEmpByName(String name)
	{
		return repo.findByName(name);
	}
	public Employee getEmpBySal(Long sal)
	{
		return repo.findBySal(sal);
	}
	
	public List<Employee> getEmpGreaterThanSal(Long sal)
	{
		return repo.findBySalGreaterThan(sal);
	}
	
	public List<Employee> getEmpLessThanSal(Long sal)
	{
		return repo.findBySalLessThan(sal);
	}
	
	//Jpql Queries using with or without native query 
	
	public List<Employee> getEmpSalAscending()
	{
		return repo.findAllSortedBysal();
	}
	
	public List<Employee> getEmpNameAscending()
	{
		return repo.findAllSortedByName();
	}
	
	//post
	
	public List<Post> getAllData(int id)
	{
		
		Optional<Employee>post= repo.findById(id);
		if(!post.isPresent())
		{
			throw new UserNotFoundException("id-"+id);
		}
		return post.get().getPost();
	
	}
	
	//create post
	
	public Post CreatePost(int id,Post post)
	{
		Optional<Employee> empopt= repo.findById(id);
		
		if(!empopt.isPresent())
		{
			throw new UserNotFoundException("id-"+id);
			}
		
		
		Employee emp=empopt.get();
		post.setEmp(emp);
		return postrepo.save(post);
		
	}

}