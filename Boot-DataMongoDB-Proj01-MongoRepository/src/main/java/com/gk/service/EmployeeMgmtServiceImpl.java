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
	public String saveEmployee(Employee emp) {
		
		return "MongoDB doc is saved with id value :: "+empRepo.insert(emp).getId();
	}
	
	@Override
	public List<Employee> showAllEmployees() {
		
		return empRepo.findAll();
	}
	
	@Override
	public String searchEmployeeById(String idVal) {
		Optional<Employee> opt = empRepo.findById(idVal);
		if(opt.isEmpty()) {
			return "Document not found";
		}
		else {
			return opt.get().toString();	
		}
		
	}
	
	@Override
	public String modifyEmployeeById(String idVal, Double newSal) {
		Optional<Employee> opt = empRepo.findById(idVal);
		if(opt.isEmpty()) {
			return "Document not found";
		}else {
			Employee emp = opt.get();
			emp.setSalary(newSal);
			empRepo.save(emp);
			return "Document found and updated";	
		}
		
	}// end of method
	
	@Override
	public String removeEmployeeById(String idVal) {
		Optional<Employee> opt = empRepo.findById(idVal);
		if(opt.isEmpty()) {
			return "Document not found ";
		}else {
			empRepo.deleteById(idVal);
			return "Document found and deleted";
		}
	}// end of method
	
	@Override
	public List<Employee> showAllEmployees(boolean asc, String... properites) {
		// create the Sort object
		Sort sort = Sort.by(asc?Direction.ASC:Direction.DESC, properites);
		// get the docs by sorting
		List<Employee> list = empRepo.findAll(sort);
		return list;
	}// end of method
	
	@Override
	public String registerEmployee(Employee e) {
		
		return "MongoDB Doc is saved with id value :: "+empRepo.insert(e).getId();
	}// end of method
}
