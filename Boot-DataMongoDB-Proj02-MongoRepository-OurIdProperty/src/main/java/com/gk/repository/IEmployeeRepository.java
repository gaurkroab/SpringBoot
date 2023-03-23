package com.gk.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gk.document.Employee;

public interface IEmployeeRepository extends MongoRepository<Employee, Integer> {

	public List<Employee> findBySalaryBetween(double start,double end);
	public Employee findByEname(String name);
}
