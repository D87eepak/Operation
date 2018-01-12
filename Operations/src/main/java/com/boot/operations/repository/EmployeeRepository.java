package com.boot.operations.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.operations.model.Employee;



public interface EmployeeRepository extends JpaRepository<Employee,Long>{
	

}
