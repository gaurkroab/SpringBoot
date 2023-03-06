package com.gk.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.gk.service.IEmployeeMgmtService;

@Component
public class CallingPLSQLProcedureTest implements CommandLineRunner {
	@Autowired
	private IEmployeeMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
		// invoke the b.method of service
		System.out.println("===================runner============class");
		service.showEmployeeBySalaryRange(1000.0, 200000.0).forEach(System.out::println);

	}

}
