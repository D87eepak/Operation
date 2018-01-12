package com.boot.operations.services;

import java.util.List;

import com.boot.operations.model.Employee;

public interface IEmployeeService {

	public List<Employee> retrieveAllEmployee();

	public Employee retrieveEmployee(Long id);

	public List<Employee> saveAllEmployee(List<Employee> empList) throws Exception;  
	
	public Employee saveEmployee(Employee employee) throws Exception;  
}
