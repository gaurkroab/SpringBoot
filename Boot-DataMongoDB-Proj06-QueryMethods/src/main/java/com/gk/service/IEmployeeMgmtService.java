package com.gk.service;

import java.util.List;

import com.gk.document.Employee;

public interface IEmployeeMgmtService {
	
	public List<Object[]> showEmpDataByAddrs(String addrs); 
	public List<Employee> showEmpAllDataByAddrs(String addrs);
	public List<Employee> showEmpAllDataByAddrsAndName(String addrs,String neame);
	public List<Employee> showEmpAllDataBySalaryRange(double startSalary,double endSalary);
	public List<Employee> showEmpAllDataByAddresses(String addrs1,String addrs2);
	public List<Employee> showEmpAllDataByEnameInitialChars(String initialChars);
	public int fetchEmpsCountBySalaryRange(double startSalary,double endSalary);
	public List<Employee> fetchEmpsDataByEnameSorted();
}
