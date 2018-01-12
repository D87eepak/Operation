package com.boot.operations.cache;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.boot.operations.model.Employee;
import com.boot.operations.repository.EmployeeRepository;

@Component
public class EmployeeCache {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	//@Cacheable(value="employeeCache",key="#claszz")
	public List<Employee> retrieveAllEmployee(String claszz){
		return employeeRepository.findAll();
	}

	@Cacheable(value="employeeCache")
	public Employee retrieveEmployee(Long id){
	
		return employeeRepository.findOne(id);
	}

	//@CachePut(value="employeeCache",key="#claszz")
	public void saveAllEmployee(List<Employee> empList,String claszz) throws Exception{
		employeeRepository.save(empList);
		
		/**
		 * Run time exception is thrown to check if Transaction are working properly or not
		 *//*
		if(empList.stream().anyMatch(e->e.getId()==(2L))){ 
			throw new RuntimeException("Exception");
	}	*/	
	}
	
	@CachePut(value="employeeCache")
	public Employee saveEmployee(Employee employee) throws Exception{
		return employeeRepository.save(employee);
	}
}
