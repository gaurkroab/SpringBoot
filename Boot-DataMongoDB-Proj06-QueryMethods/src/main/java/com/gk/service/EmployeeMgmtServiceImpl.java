package com.gk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gk.document.Employee;
import com.gk.repository.IEmployeeRepo;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {

	@Autowired
	IEmployeeRepo empRepo;
	
	@Override
	public List<Object[]> showEmpDataByAddrs(String addrs) {
		return empRepo.getEmpDataByAddrs(addrs);
	}
	
	@Override
	public List<Employee> showEmpAllDataByAddrs(String addrs) {	
		return empRepo.getEmpAllDataByAddrs(addrs);
	}
	
	@Override
	public List<Employee> showEmpAllDataByAddrsAndName(String addrs, String neame) {
		return empRepo.getEmpAllDataByAddrsAndName(addrs, neame);
	}
	
	@Override
	public List<Employee> showEmpAllDataBySalaryRange(double startSalary, double endSalary) {
		return empRepo.getEmpAllDataBySalaryRange(startSalary, endSalary);
	}

	@Override
	public List<Employee> showEmpAllDataByAddresses(String addrs1, String addrs2) {
		return empRepo.getEmpAllDataByAddresses(addrs1, addrs2);
	}
	
	@Override
	public List<Employee> showEmpAllDataByEnameInitialChars(String initialChars) {
		return empRepo.getEmpAllDataByEnameInitialChars(initialChars);
	}
	
	@Override
	public int fetchEmpsCountBySalaryRange(double startSalary, double endSalary) {
		return empRepo.getEmpCountBySalaryRange(startSalary, endSalary);
	}
	
	@Override
	public List<Employee> fetchEmpsDataByEnameSorted() {
		return empRepo.showAllEmpsByEnameSorted();
	}
}
