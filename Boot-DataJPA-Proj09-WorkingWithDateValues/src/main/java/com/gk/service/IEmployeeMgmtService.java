package com.gk.service;

import java.util.List;

import com.gk.entity.Employee_Date_Time;

public interface IEmployeeMgmtService {
	public String saveEmployee(Employee_Date_Time dateTime);
	public List<Employee_Date_Time> getAllEmployees();
	public List<Integer> showEmployeeAgesByDesg(String desg);
}
