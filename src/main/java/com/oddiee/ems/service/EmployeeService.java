package com.oddiee.ems.service;

import java.util.List;

import com.oddiee.ems.entity.Employee;

public interface EmployeeService {
	
	List<Employee> getAllEmployees();
	Employee getEmployeeById(long id);
	Employee addEmployee(Employee employee);
	Employee updateEmployee(long id, Employee employee);
	void deleteEmployee(long id);
	
	
}
