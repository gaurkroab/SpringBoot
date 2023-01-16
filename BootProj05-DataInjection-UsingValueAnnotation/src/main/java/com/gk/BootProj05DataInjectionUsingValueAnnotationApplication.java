package com.gk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.gk.sbeans.PatientInfo;

@SpringBootApplication
public class BootProj05DataInjectionUsingValueAnnotationApplication {

	public static void main(String[] args) {
		// get IOC container
		ApplicationContext ctx = SpringApplication.run(BootProj05DataInjectionUsingValueAnnotationApplication.class, args);
		// get PatientInfo spring bean class object
		PatientInfo info = ctx.getBean("pInfo",PatientInfo.class);
		System.out.println(info);
		
		// close the IOC container
		((ConfigurableApplicationContext) ctx).close();
	}

}
