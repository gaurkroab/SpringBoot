package com.gk.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gk.document.Employee;

public interface IEmployeeRepository extends MongoRepository<Employee, Integer> {

}
