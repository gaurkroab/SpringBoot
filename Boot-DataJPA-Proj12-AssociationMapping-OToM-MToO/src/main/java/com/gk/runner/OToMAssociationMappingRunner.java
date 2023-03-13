package com.gk.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.gk.service.IOToMAssociationMgmtService;

@Component
public class OToMAssociationMappingRunner implements CommandLineRunner {

	@Autowired
	private IOToMAssociationMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
		// service.saveDataUsingParent();
		//service.saveDateUsingChild();
		service.loadDataUsingParent();

	}

}
