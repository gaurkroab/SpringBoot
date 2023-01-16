package com.gk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.gk.sbeans.Company1;
import com.gk.sbeans.Company2;

@SpringBootApplication
public class BootProj06DataInjectionApplication {

	public static void main(String[] args) {
		// get IOC container
		
		ApplicationContext ctx = SpringApplication.run(BootProj06DataInjectionApplication.class, args);
		// get spring bean class object
		Company1 comp1 = ctx.getBean("comp1",Company1.class);
		System.out.println(comp1);
		System.out.println("----------------------------------------------------------------------");
		Company2 comp2 = ctx.getBean("comp2", Company2.class);
		System.out.println(comp2);
		System.out.println("system properties are :: "+ System.getProperties());
		// close the container
		((ConfigurableApplicationContext) ctx).close();
		
	
	}

}
