package com.gk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.gk.sbeans.Employee;

@SpringBootApplication
public class BootProj09DataInjectionMoreOnYmlApplication {

	public static void main(String[] args) {
		// get IOC container
		ApplicationContext ctx = SpringApplication.run(BootProj09DataInjectionMoreOnYmlApplication.class, args);
		// get Spring bean class object
		Employee emp = ctx.getBean("emp" , Employee.class);
		System.out.println(emp);
		
		// close IOC container
		((ConfigurableApplicationContext) ctx).close();
	}

}
