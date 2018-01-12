package com.boot.operations.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boot.operations.model.Employee;
import com.boot.operations.services.IEmployeeService;

@RestController
@RequestMapping(value="/emp")
public class EmployeeController {
	//private static final Logger logger = LoggerFactory.getLogger(SpringBootMainApplication.class);
	@Autowired
	IEmployeeService employeeService;

	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public List<Employee> saveAllEmployee(@RequestBody List<Employee> empList) throws Exception{
		/*logger.error("Message logged at ERROR level");
	    logger.warn("Message logged at WARN level");
	    logger.info("Message logged at INFO level");
	    logger.debug("Message logged at DEBUG level");*/
		List<Employee> list=employeeService.saveAllEmployee(empList);
		return list; 
	}
	
	@RequestMapping(value="/retrieveAll",method=RequestMethod.GET)
	public List<Employee> retrieveAllEmployee() throws Exception {
		List<Employee> list=employeeService.retrieveAllEmployee();
		return list; 
	}

	@RequestMapping(value="/retrieveOne/{id}",method=RequestMethod.GET)
	public Employee retrieveEmployee(@PathVariable  Long id) {

		Employee ee=employeeService.retrieveEmployee(id);
		return ee;
	}
	
	@RequestMapping(value="/saveEmployee",method=RequestMethod.POST)
	public Employee saveEmployee(@RequestBody Employee employee) throws Exception {

		Employee ee= employeeService.saveEmployee(employee);
		return ee;
	}
}
