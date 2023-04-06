package com.gk.service;

import java.util.Optional;

import com.gk.entity.Attendance;
import com.gk.entity.Employee;

public interface IEmployeeMgmtService {
	
	public String registerEmployee(Employee emp);
	public String registerAttendance(Attendance attendance);
	public Optional<Employee> getEmployeeById(int id);
	
}
