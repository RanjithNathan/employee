package com.Employee.EmployeeDetails.TestCases;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.Employee.EmployeeDetails.EmployeeDetailsApplication;
import com.Employee.EmployeeDetails.model.Employee;
import com.Employee.EmployeeDetails.repository.EmployeeRepository;

@ExtendWith(SpringExtension.class)
@Transactional
@SpringBootTest(classes = EmployeeDetailsApplication.class)
public class EmployeeTestCases {
	
	@Autowired
	private EmployeeRepository emprepo;
	@Test
	public void testByFindId()
	{
		Employee emp=new Employee();
			emprepo.save(emp);
			Employee result=emprepo.findById(emp.getId()).get();
			assertEquals(emp.getId(),result.getId());
		
	}
//	@Test
//	public void findAllSortedByName()
//	{
//		Employee emp1=new Employee();
//		Employee emp2=new Employee();
//		emp1.setId(5);
//		emp1.setName("ashok");
//		emp1.setSal(19000l);
//		emp1.setId(6);
//		emp1.setName("ranjith");
//		emp1.setSal(25000l);
//		emprepo.save(emp1);
//		emprepo.save(emp2);
//		
//		List<Employee> result=emprepo.findAllSortedByName();
//		assertEquals(emp2.getName(),result.get(0).getName());
//		
//		
//	}
//	
	
}
