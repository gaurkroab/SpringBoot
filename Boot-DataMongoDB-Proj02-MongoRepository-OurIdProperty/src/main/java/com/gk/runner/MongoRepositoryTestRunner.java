package com.gk.runner;

import java.util.Optional;

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
		e.setEname("rishabh");
		e.setEadd("aligarh");
		e.setSalary(55000.0);
		e.setIsVaccinated(true);
		System.out.println(service.registerEmployee(e));
		*/
		
		Optional<Employee> opt = service.showEmployeeById(911);
		if(opt.isPresent()) {
			System.out.println("employee details :: "+opt.get());
		}else {
			System.out.println("Employee not found");
		}
	
		}

}
