package com.gk.runner;

import java.util.Random;

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
		e.setEno(new Random().nextInt(1000));
		e.setEname("akash");
		e.setEadd("banglore");
		e.setSalary(57000.0);
		e.setIsVaccinated(true);
		System.out.println(service.registerEmployee(e));
		*/
		/*	
			Optional<Employee> opt = service.showEmployeeById(911);
			if(opt.isPresent()) {
				System.out.println("employee details :: "+opt.get());
			}else {
				System.out.println("Employee not found");
			}
		*/
		
		//service.searchEmployeeBySalaryRange(1000.0, 100000.0).forEach(System.out::println);
		System.out.println(service.searchByEmployeeName("rishabh"));
		}

}
