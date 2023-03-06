package com.gk.service;

import java.util.List;

import com.gk.entity.Employee_Info;

public interface IEmployeeMgmtService {
	public List<Employee_Info> showEmployeeBySalaryRange(double start,double end);
}
