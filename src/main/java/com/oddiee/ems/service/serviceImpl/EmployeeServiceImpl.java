package com.oddiee.ems.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oddiee.ems.entity.Employee;
import com.oddiee.ems.exception.ResourceNotFoundException;
import com.oddiee.ems.repository.EmployeeRepository;
import com.oddiee.ems.service.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) {
		return employeeRepository.findById(id).orElseThrow(() -> 
				new ResourceNotFoundException("Employee not found for ID :: " + id));
		
	}

	@Override
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee updateEmployee(long id, Employee employee) {
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() -> 
									new ResourceNotFoundException("Employee not found for ID :: " + id));
		
		existingEmployee.setId(employee.getId());
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		
		return employeeRepository.save(existingEmployee);
	}

	@Override
	public void deleteEmployee(long id) {
		employeeRepository.deleteById(id);
		
	}
}
