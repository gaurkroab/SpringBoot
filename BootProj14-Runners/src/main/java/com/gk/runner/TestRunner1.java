package com.gk.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class TestRunner1 implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("non option args values :: "+args.getNonOptionArgs());
		System.out.println("Option args names and values");
		for(String name:args.getOptionNames()) {
			System.out.println(name +"--------->"+args.getOptionValues(name));
		}

	}

}
