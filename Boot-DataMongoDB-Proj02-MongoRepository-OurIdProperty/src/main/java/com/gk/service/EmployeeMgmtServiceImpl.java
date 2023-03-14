package com.gk.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.gk.document.Employee;
import com.gk.repository.IEmployeeRepository;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {

	@Autowired
	private IEmployeeRepository empRepo;

	@Override
	public String registerEmployee(Employee e) {
		
		return "MongoDB Doc is saved with id value :: "+empRepo.save(e).getEno();
	}
	@Override
	public Optional<Employee> showEmployeeById(int id) {
		return empRepo.findById(id);
	}
}
