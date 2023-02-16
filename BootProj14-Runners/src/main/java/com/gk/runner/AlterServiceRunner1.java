package com.gk.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AlterServiceRunner1 implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("AlterServiceRunner1.run() .... the cmd line args are");
		for(String arg:args) {
			System.out.println(arg);
		}

	}

}
