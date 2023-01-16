package com.gk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import com.gk.sbeans.Vehicle;

@SpringBootApplication
@ImportResource("com/gk/cfgs/applicationContext.xml")
public class BootProj02StrategyDpApplication {

	public static void main(String[] args) {
		// get IOC container
		ApplicationContext ctx = SpringApplication.run(BootProj02StrategyDpApplication.class, args);
		// get Target spring bean class object
		Vehicle vehicle = ctx.getBean("vehicle",Vehicle.class);
		// invoke the b.method
		vehicle.move("aligarh","delhi");
		
		// close the container
		((ConfigurableApplicationContext) ctx).close();
	}

}
