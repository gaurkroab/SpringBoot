package com.gk.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.gk.document.Employee;

public interface IEmployeeRepo extends MongoRepository<Employee, Integer> {

	// ============================ Projection Query ======================
	 
	//@Query(fields="{eno:0,eadd:1,salary:1}",value="{eadd:?0}") // where eadd=?
	@Query(fields="{eno:1,eadd:1,salary:1}",value="{eadd:?0}") // where eadd=?
	public List<Object[]> getEmpDataByAddrs(String addrs);
	
	// ============================= Entity Queries =========================
	//@Query(fields="{}",value="{eadd:?0}")
	@Query(value="{eadd:?0}")
	public List<Employee> getEmpAllDataByAddrs(String addrs);
	
	@Query(value="{eadd:?0,ename:?1}")
	public List<Employee> getEmpAllDataByAddrsAndName(String addrs,String name);
	
	//@Query(value="{salary:{$gte:?0,$lte:?1}}")
	@Query(value="{salary:{$gte:?0},salary:{$lte:?1}}")
	public List<Employee> getEmpAllDataBySalaryRange(double startSalary,double endSalary);
	
	@Query(value="{$or:[{eadd:?0},{eadd:?1}]}")  // where eadd=? or eadd=?
	public List<Employee> getEmpAllDataByAddresses(String addrs1,String addrs2);
	
	@Query(value="{ename:{'$regex':?0,'$options':'i'}}")
	public List<Employee> getEmpAllDataByEnameInitialChars(String initialChars);
	
	@Query(value="{salary:{$gte:?0,$lte:?1}}",count=true)
	public int getEmpCountBySalaryRange(double startSalary,double endSalary);
	
	@Query(value="{}",sort="{ename:-1}")  // value is compulsory in this query method
	public List<Employee> showAllEmpsByEnameSorted();
}
