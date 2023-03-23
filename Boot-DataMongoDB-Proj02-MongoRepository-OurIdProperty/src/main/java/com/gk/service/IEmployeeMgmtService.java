package com.gk.service;

import java.util.List;
import java.util.Optional;

import com.gk.document.Employee;

public interface IEmployeeMgmtService {
	
	public Optional<Employee> showEmployeeById(int id);
	public String registerEmployee(Employee e);
	
	public List<Employee> searchEmployeeBySalaryRange(double start,double end);
	public Employee searchByEmployeeName(String name);
}
