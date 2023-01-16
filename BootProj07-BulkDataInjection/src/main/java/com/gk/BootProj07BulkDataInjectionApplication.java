package com.gk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.gk.sbeans.Employee;

@SpringBootApplication
public class BootProj07BulkDataInjectionApplication {

	public static void main(String[] args) {
		// get IOC container
	 ApplicationContext ctx = SpringApplication.run(BootProj07BulkDataInjectionApplication.class, args);
	 // get Employee Spring bean class object
	 Employee emp = ctx.getBean("emp",Employee.class);
	 System.out.println(emp);
	 // close the IOC container
	 ((ConfigurableApplicationContext) ctx).close();
	}

}
