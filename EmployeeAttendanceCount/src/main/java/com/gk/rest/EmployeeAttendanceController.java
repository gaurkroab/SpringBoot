package com.gk.rest;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gk.entity.Attendance;
import com.gk.entity.Employee;
import com.gk.service.IEmployeeMgmtService;

@RestController
@RequestMapping("/employee/api")
public class EmployeeAttendanceController {

	@Autowired
	private IEmployeeMgmtService service;
	
	@PostMapping("/save")
	public ResponseEntity<String> registerEmployee(@RequestBody Employee emp){
		try {
			String msg = service.registerEmployee(emp);
			return new ResponseEntity<String>(msg,HttpStatus.CREATED);
		}
		catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}// end of method
	
	@PutMapping("/update/{aId}")
	public ResponseEntity<String> updateAttendance(@PathVariable int aId, @RequestBody Attendance attendance){
		String msg=null;
		try {
			Optional<Employee> opt= service.getEmployeeById(aId);
			if(opt.isPresent()) {
				Employee emp = opt.get();
				Set<Attendance> atten=emp.getAttendance();
				attendance.setEmployee(emp);
				atten.add(attendance);
				 msg = service.registerAttendance(attendance);
			}
			else {
				System.out.println("employee is not found");
			}
			
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}
		catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	} // end of method
	
	@GetMapping("/get/{id}")
	public ResponseEntity<String> getAttendanceCount(@PathVariable int id){
	
	try {
		Optional<Employee> opt  = service.getEmployeeById(id);
		Employee emp = opt.get();
		int count =emp.getAttendance().size();
		String msg = "Attendance count is :::  "+count;
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	catch(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	}
}
