package com.gk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.gk.model.Employee;
import com.gk.service.IEmployeeMgmtService;

@Controller("payrollController")
public class PayrollOperationsController {
	@Autowired
	private IEmployeeMgmtService service;
	
	public String processEmployee(Employee emp ) throws Exception{
		// delegate the request to Serivce class
		String result = service.registerEmployee(emp);
		return result;
	}
}
