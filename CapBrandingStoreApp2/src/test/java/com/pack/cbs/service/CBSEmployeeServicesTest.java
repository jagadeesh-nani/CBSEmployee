package com.pack.cbs.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.pack.cbs.dao.CBSEmployeeRepository;
import com.pack.cbs.model.CBSEmployee;
import org.mockito.Mockito;
import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
class CBSEmployeeServicesTest {

	@MockBean
	 private CBSEmployeeRepository employeeRepository;
	
	 @Autowired
	 private CBSEmployeeServices employeeServices;
	@Test
	void testGetEmployeeById() throws Exception {
//		CBSEmployee emp = new CBSEmployee();
//		  emp.setEmpId(103);
//		  emp.setEmpName("Ellora");
//	      emp.setEmpPhone(690658943); 
//	      emp.setEmpEmail("ellora@gmail.com");
//	      emp.setEmpLocation("Chennai");
//	      System.out.println(employeeRepository.findById(100));
//	        Mockito.when(employeeRepository.findById(100).get()).thenReturn((emp));
//	    assertThat(employeeServices.getEmployeeById(100)).isEqualTo(emp);
		
		CBSEmployee emp = new CBSEmployee();
		emp.setEmpId(103);
		  emp.setEmpName("Ellora");
	      emp.setEmpPhone(690658943); 
	      emp.setEmpEmail("ellora@gmail.com");
	      emp.setEmpLocation("Chennai");

	        Mockito.when(employeeRepository.findById(100).get()).thenReturn(emp);
	        assertThat(employeeServices.getEmployeeById(100)).isEqualTo(emp);
	      
	}

	@Test
	void testDeleteEmployee() throws Exception {
		CBSEmployee emp = new CBSEmployee();
		  emp.setEmpName("Rabia");
	      emp.setEmpPhone(879658943); 
	      emp.setEmpEmail("rabia@gmail.com");
	      emp.setEmpLocation("Chennai");
	        
	      employeeRepository.deleteById(emp.getEmpId());
        System.out.println(employeeRepository.findById(100));
        Assert.assertTrue(employeeRepository.findById(100).isEmpty());
	}

	@Test
	void testUpdateEmployeeById() throws Exception {
		CBSEmployee emp=new CBSEmployee();
		  emp.setEmpId(100); 
		  emp.setEmpName("Ajantha");
	      emp.setEmpPhone(690658943); 
	      emp.setEmpEmail("ajantha@gmail.com");
	      emp.setEmpLocation("Chennai");
     
	      employeeRepository.save(emp);

		        Mockito.when(employeeRepository.findById(100).get()).thenReturn(emp);
		       emp.setEmpPhone(999658943); 
		        Mockito.when(employeeRepository.save(emp)).thenReturn(emp);
		        System.out.println(emp.getEmpPhone());
		        assertThat(employeeServices.updateEmployeeById(100, emp)).isEqualTo(emp);
		  
//		CBSEmployee emp = new CBSEmployee();
//		  emp.setEmpName("Rabia");
//	      emp.setEmpPhone(879658943); 
//	      emp.setEmpEmail("rabia@gmail.com");
//	      emp.setEmpLocation("Chennai");
//	        
//	      employeerepository.save(emp);
//      System.out.println(employeerepository.findById(100));
//      Assert.assertTrue(employeerepository.findById(100).isEmpty());
	}

	@Test
	void testGetAllEmployees() {
		CBSEmployee emp=new CBSEmployee();
		  emp.setEmpName("Ajantha");
	      emp.setEmpPhone(690658943); 
	      emp.setEmpEmail("ajantha@gmail.com");
	      emp.setEmpLocation("Chennai");
	        
	      CBSEmployee emp1=new CBSEmployee();
	      emp1.setEmpName("Alla");
	      emp1.setEmpPhone(876965894); 
	      emp1.setEmpEmail("alla@gmail.com");
	      emp1.setEmpLocation("Bangalore");
        List<CBSEmployee> empList = new ArrayList<>();
        empList.add(emp);
        empList.add(emp1);

        Mockito.when(employeeRepository.findAll()).thenReturn(empList);
        assertThat(employeeServices.getAllEmployees()).isEqualTo(empList);
	}

	@Test
	void testSaveEmployee() {
		
		CBSEmployee emp = new CBSEmployee();
		emp.setEmpId(100); 
		  emp.setEmpName("Reshma");
	      emp.setEmpPhone(879658943); 
	      emp.setEmpEmail("resh@gmail.com");
	      emp.setEmpLocation("Chennai");

        Mockito.when(employeeRepository.save(emp)).thenReturn(emp);
        assertThat(employeeServices.saveEmployee(emp)).isEqualTo(emp);
	}

}
