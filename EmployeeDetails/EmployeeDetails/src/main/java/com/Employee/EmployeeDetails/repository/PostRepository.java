package com.Employee.EmployeeDetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Employee.EmployeeDetails.model.Post;

public interface PostRepository extends JpaRepository<Post,Integer>
{

}
