package com.oddiee.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oddiee.ems.entity.Employee;
import com.oddiee.ems.service.EmployeeService;

@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	// get all employee
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	
	// get employee by id
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value="id") long id) {
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(id), HttpStatus.OK);
	}
	
	// add employee
	@PostMapping("/employees")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<Employee>(employeeService.addEmployee(employee), HttpStatus.CREATED); 
	}
	
	
	// update employee
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value= "id") long id, @RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.updateEmployee(id, employee), HttpStatus.CREATED); 
	}
	
	// delete employee
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable(value= "id") long id){
		employeeService.deleteEmployee(id);
		return new ResponseEntity<String>("Employee with id "+id+" has been successfull deleted ..!! " , HttpStatus.OK);
	}
}
