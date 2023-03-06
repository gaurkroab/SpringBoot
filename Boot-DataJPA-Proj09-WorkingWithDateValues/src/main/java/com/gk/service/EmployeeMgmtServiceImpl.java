package com.gk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gk.entity.Employee_Date_Time;
import com.gk.repository.IEmployeeDateTimeRepository;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	@Autowired
	private IEmployeeDateTimeRepository empRepo;
	
	@Override
	public String saveEmployee(Employee_Date_Time dateTime) {
		int idVal = empRepo.save(dateTime).getEno();
		return "Employee object is saved with the id Value :: "+idVal;
	}
	
	@Override
	public List<Employee_Date_Time> getAllEmployees() {
		return empRepo.findAll();
	}
	
	@Override
	public List<Integer> showEmployeeAgesByDesg(String desg) {
		return empRepo.getEmployeeAgesByDesg(desg);
	}
}
