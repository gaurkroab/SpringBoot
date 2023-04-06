package com.gk.repostitory;

import org.springframework.data.repository.CrudRepository;

import com.gk.entity.Employee;

public interface IEmployeeDetailRepository extends CrudRepository<Employee, Integer> {

}
