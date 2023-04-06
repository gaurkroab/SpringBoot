package com.gk.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gk.entity.Attendance;
import com.gk.entity.Employee;
import com.gk.repostitory.IAttendanceDetailRepository;
import com.gk.repostitory.IEmployeeDetailRepository;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {

	@Autowired
	private IEmployeeDetailRepository repo;
	
	@Autowired
	private IAttendanceDetailRepository arepo;
	
	@Override
	public String registerEmployee(Employee emp) {
		int idval = repo.save(emp).getEmpId();
		return "Employee is saved with id value :: "+idval;
	}
	
	@Override
	public String registerAttendance(Attendance attendance) {
		
		return "Attendance objcet is saved"+arepo.save(attendance);
	}
	
	@Override
	public Optional<Employee> getEmployeeById(int id) {
	
		return repo.findById(id);
	}
	
}
