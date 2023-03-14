package com.gk.service;

import java.util.Optional;

import com.gk.document.Employee;

public interface IEmployeeMgmtService {
	
	public Optional<Employee> showEmployeeById(int id);
	public String registerEmployee(Employee e);
}
