package com.example.learn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.learn.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

	Employee findByName(String name);
	Employee findByEmailId(String emailId);
	Employee findByPhNo(String phNo);
	List<Employee> findByCurrency(String currency);
}
