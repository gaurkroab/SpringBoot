package com.gk.service;

import java.util.List;

import com.gk.document.Employee;

public interface IEmployeeMgmtService {
	public String saveEmployee(Employee emp);
	public List<Employee> showAllEmployees();
	
	public String searchEmployeeById(String idVal);
	public String modifyEmployeeById(String idVal,Double newSal);
	public String removeEmployeeById(String idVal);
	public List<Employee> showAllEmployees(boolean asc,String ...properites);
	
	public String registerEmployee(Employee e);
}
