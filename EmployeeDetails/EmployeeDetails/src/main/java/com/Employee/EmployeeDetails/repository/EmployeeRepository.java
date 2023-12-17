package com.Employee.EmployeeDetails.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Employee.EmployeeDetails.model.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>
{
	//Finder Methods 
	public List<Employee> findByName(String name);
	
	public Employee findBySal(Long sal);
	
	public List<Employee> findBySalGreaterThan(Long sal);
	
	public List<Employee> findBySalLessThan(Long sal);
	
	//Jpql Queries using with and without native query 
	@Query (value="SELECT * FROM Employee ORDER BY sal",nativeQuery = true)
	public List<Employee> findAllSortedBysal();
	
	
	 @Query(value = "SELECT a FROM Employee a ORDER BY name")
	   public List<Employee> findAllSortedByName();
	   
}
