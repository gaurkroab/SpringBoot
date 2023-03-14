package com.gk.runner;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.gk.document.Employee;
import com.gk.service.IEmployeeMgmtService;

@Component
public class MongoRepositoryTestRunner implements CommandLineRunner {

	@Autowired
	private IEmployeeMgmtService service;
	@Override
	public void run(String... args) throws Exception {
		/*Employee e =new Employee();
		e.setEno(1001);
		e.setEname("rishabh");
		e.setEadd("aligarh");
		e.setSalary(55000.0);
		e.setIsVaccinated(true);
		System.out.println(service.saveEmployee(e));
		*/	
	
		//service.showAllEmployees().forEach(System.out::println);
		
		//System.out.println("Document Info :: "+service.searchEmployeeById("6409fdf817e6731238bf5cf2"));
		
		//System.out.println(service.modifyEmployeeById("6409fdf817e6731238bf5cf2", 57000.0));
		
		//System.out.println(service.removeEmployeeById("6409fdf817e6731238bf5cf2"));
		
		// find dall the docs
		//service.showAllEmployees(true, "ename").forEach(System.out::println);
		
		Employee e=new Employee();
		e.setId(UUID.randomUUID().toString());
		e.setEno(103);
		e.setEname("gaurav");
		e.setEadd("aligarh");
		e.setSalary(60000.0);
		e.setIsVaccinated(true);
		System.out.println(service.registerEmployee(e));
	}

}
