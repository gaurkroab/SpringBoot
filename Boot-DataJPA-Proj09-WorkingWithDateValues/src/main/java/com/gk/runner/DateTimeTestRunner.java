package com.gk.runner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.gk.entity.Employee_Date_Time;
import com.gk.service.IEmployeeMgmtService;

@Component
public class DateTimeTestRunner implements CommandLineRunner {

	@Autowired
	private IEmployeeMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		/*
		  try { 
			  System.out.println("runner class"); // save the object
		  Employee_Date_Time emp = new Employee_Date_Time("shashank","frondenddeveloper", LocalDateTime.of(1996, 7, 10, 11, 34), LocalTime.of(17,
		  45), LocalDate.of(2020, 10, 30)); 
		  String result = service.saveEmployee(emp);
		  System.out.println(result);
		  }
		  catch (Exception e)
		  { 
			  e.printStackTrace();
		 }
		 

		try {
			service.getAllEmployees().forEach(System.out::println);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		*/
		try {
			service.showEmployeeAgesByDesg("javadeveloper").forEach(System.out::println);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
