package com.boot.operations.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boot.operations.cache.EmployeeCache;
import com.boot.operations.model.Employee;
import com.boot.operations.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeService implements IEmployeeService{

	@Autowired 
	EmployeeCache employeeCache;
	@Autowired
	EmployeeRepository employeeRepository;
	/*@PostConstruct
	public void init(){
		Employee employee=new Employee(1L, "A", "sales");
		employeeRepository.save(employee);
	}*/
	
	/** 
	 * Cache not working in case of collection
	 */
	//@Cacheable(value="employeeCache",key="e")
	public List<Employee> retrieveAllEmployee() {
		return employeeRepository.findAll();
	}

	@Cacheable(value="employeeCache",key="#id")
	public Employee retrieveEmployee(Long id) {
		return employeeRepository.findOne(id);//employeeCache.retrieveEmployee(id); 
	}

	/** 
	 * Cache not working in case of collection
	 */
	//@CachePut(value="employeeCache" )
	public List<Employee> saveAllEmployee(List<Employee> empList) throws Exception {
		return employeeRepository.save(empList);
		
	}

	/**
	 * We need to add key for cache
	 */
	@CachePut(value="employeeCache",key="#employee.id" )
	public Employee saveEmployee(Employee employee) throws Exception {
		return employeeRepository.save(employee);
		
	}

}
