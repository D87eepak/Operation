package com.boot.operations.controller;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.boot.operations.model.Employee;
import com.boot.operations.services.IEmployeeService;


@RunWith(SpringRunner.class)
@WebMvcTest(value=EmployeeController.class,secure=false)
public class SpringBootMainApplicationTest {

	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	IEmployeeService employeeService;
	
	Employee employee=new Employee(1L, "AB", "Sales");
	List<Employee> empList=Arrays.asList(employee);
	
	@Test
	public void retrieveAllEmployee() throws Exception{
	
		Mockito.when(employeeService.retrieveAllEmployee()).thenReturn(empList);
		RequestBuilder reqBuilder=MockMvcRequestBuilders.get("/emp/retrieveAll1").accept(MediaType.APPLICATION_JSON);
		MvcResult mvcResult=mockMvc.perform(reqBuilder).andReturn();
		
		System.out.println("value="+mvcResult.getResponse().toString()); 
		Mockito.verify(employeeService).retrieveAllEmployee();
			
	}
	
}
