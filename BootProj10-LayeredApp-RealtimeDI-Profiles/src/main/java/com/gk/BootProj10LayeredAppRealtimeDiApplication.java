package com.gk;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

import com.gk.controller.PayrollOperationsController;
import com.gk.model.Employee;
import com.mchange.v2.c3p0.ComboPooledDataSource;

@SpringBootApplication
public class BootProj10LayeredAppRealtimeDiApplication {
	
	@Autowired
	private Environment env;
	
	@Bean(name="c3P0Ds")
	@Profile("test")
	public  ComboPooledDataSource  createC3P0Ds()throws Exception {
		System.out.println("BootProj03LayeredAppRealtimeDiApplication.createC3P0Ds()");
		  ComboPooledDataSource  cds=new ComboPooledDataSource();
		  cds.setDriverClass(env.getProperty("spring.datasource.driver-class-name"));
		  cds.setJdbcUrl(env.getProperty("spring.datasource.url"));
		  cds.setUser(env.getProperty("spring.datasource.username"));
		  cds.setPassword(env.getProperty("spring.datasource.password"));
		  
		  cds.setMinPoolSize(Integer.parseInt(env.getProperty("c3P0.minSize")));
		  cds.setMaxPoolSize(Integer.parseInt(env.getProperty("c3P0.maxSize")));
		  return cds;
	}

	public static void main(String[] args) {
		
		// read inputs from the enduser
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter employee name:: ");
		String name = sc.next();
		System.out.println("Enter employee desg :: ");
		String desg  = sc.next();
		System.out.println("Enter employee basic salary :: ");
		double basicSalary = sc.nextDouble();
		
		// create the Employee class object
		Employee emp = new Employee();
		emp.setDesg(desg);
		emp.setEname(name);
		emp.setSalary(basicSalary);
		
		// get IOC container
		ApplicationContext ctx = SpringApplication.run(BootProj10LayeredAppRealtimeDiApplication.class, args);
		// get Controller class object
		PayrollOperationsController controller = ctx.getBean("payrollController",PayrollOperationsController.class);
		// invoke the method
		try {
			String result = controller.processEmployee(emp);
			System.out.println(result);
		}// try
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Internal Problem --- Try again "+ e.getMessage());
		
		}
		// close the container
			((ConfigurableApplicationContext) ctx).close();
	}

}
