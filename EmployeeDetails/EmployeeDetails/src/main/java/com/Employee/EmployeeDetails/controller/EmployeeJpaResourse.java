package com.Employee.EmployeeDetails.controller;

import java.util.List;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.Employee.EmployeeDetails.model.Employee;
import com.Employee.EmployeeDetails.model.Post;
import com.Employee.EmployeeDetails.repository.PostRepository;
import com.Employee.EmployeeDetails.service.EmployeeService;

@RestController
public class EmployeeJpaResourse 
{
		@Autowired
		EmployeeService service;
		
		
		
		@PostMapping("/register")
		public Employee createNew(@RequestBody Employee emp)
		{
			return service.create(emp);
			
		}
		
		
		@GetMapping("/getdata")
		public List<Employee>getAllEmp()
		{
				
				return service.getAllEmp();
		}
		
		@GetMapping("/getdata/{id}")
		public Employee getEmpById(@PathVariable int id)
		{
		
			return service.getEmpById(id);
		}
		
	
		@DeleteMapping("/delete/{id}")
		public void deleteEmp(@PathVariable int id)
		{
			service.deleteEmpById(id);
		}
		
		@PutMapping("/update/{id}")
		public Employee createNew(@RequestBody Employee emp,@PathVariable int id)
		{
			return service.create(emp);
			
		}
		
		
	//Using Finder methods	
		@GetMapping("/getdata/empname/{name}")
		public List<Employee> getEmpByName(@PathVariable("name") String name)
		{
			System.out.println(service.getEmpByName(name));
			List<Employee> emplistbyname=service.getEmpByName(name);
			return emplistbyname;
			
		}
		@GetMapping("/getdata/empsal/{sal}")
		public Employee getEmpBySal(@PathVariable("sal") Long sal)
		{
			return service.getEmpBySal(sal);
		}
		
		@GetMapping("/getdata/salary/maxsal/{maxsal}")
		public List<Employee> getEmpSalGreater(@PathVariable("maxsal") Long sal)
		{
			List<Employee> emplistbyminsal=service.getEmpGreaterThanSal(sal);
			return emplistbyminsal;
		
		}
		@GetMapping("/getdata/salary/minsal/{minsal}")
		public List<Employee> getEmpSalLesser(@PathVariable("minsal") Long sal)
		{
			List<Employee> emplistbyminsal=service.getEmpLessThanSal(sal);
			return emplistbyminsal;
		}
		
//Jpql Queries using with or without native query 	
		@GetMapping("/getdata/emp/asc")
		public List<Employee> getEmpSalAsc()
		{
			return service.getEmpSalAscending();
		}
		
		@GetMapping("/getdata/emp/nameasc")
		public List<Employee> getEmpNameAsc()
		{
			return service.getEmpNameAscending();
		}
		
// Post
		@GetMapping("/get/post/{id}/post")
		public List<Post> getAllData(@PathVariable("id") int id)
		{
			return service.getAllData(id);
		}
	
//create post
		@PostMapping("/get/post/{id}/post")
		public Post createPost(@PathVariable int id,@RequestBody Post post)
		{
			return service.CreatePost(id, post);
		}
}
