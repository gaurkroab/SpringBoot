package com.gk;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.env.Environment;

import com.gk.controller.PayrollOperationsController;
import com.gk.model.Employee;
import com.mchange.v2.c3p0.ComboPooledDataSource;

@SpringBootApplication
@ImportResource("com/gk/cfgs/applicationContext.xml")
public class BootProj04LayeredAppRealtimeDiApplication {
	
	@Autowired
	private Environment env;
	/*
	  @Bean("c3p0Ds") 
	  public ComboPooledDataSource createC3P0Ds() throws Exception{
	  ComboPooledDataSource cds = new ComboPooledDataSource();
	  cds.setDriverClass("oracle.jdbc.driver.OracleDriver");
	  cds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe"); 
	  cds.setUser("system");
	  cds.setPassword("manager");
	  cds.setMinPoolSize(10);
	  cds.setMaxPoolSize(100);
	  
	  return cds;
	  } */
	
	  @Bean("c3p0Ds") 
	  public ComboPooledDataSource createC3P0Ds() throws Exception{
	  ComboPooledDataSource cpds = new ComboPooledDataSource();
	  cpds.setDriverClass(env.getRequiredProperty("spring.datasource.driver-class-name"));
	  cpds.setJdbcUrl(env.getRequiredProperty("spring.datasource.url"));
	  cpds.setUser(env.getRequiredProperty("spring.datasource.username"));
	  cpds.setPassword(env.getRequiredProperty("spring.datasource.password"));
	  cpds.setMinPoolSize(Integer.parseInt(env.getRequiredProperty("c3p0.minsize")));
	  cpds.setMaxPoolSize(Integer.parseInt(env.getRequiredProperty("c3p0.maxsize")));
	  
	  return cpds;
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
		ApplicationContext ctx = SpringApplication.run(BootProj04LayeredAppRealtimeDiApplication.class, args);
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
