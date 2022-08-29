package com.oddiee.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oddiee.ems.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
