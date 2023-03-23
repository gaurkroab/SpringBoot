package com.gk.runner;

import java.util.List;

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
		System.out.println("hello");
		List<Object[] > list=service.fetchDataUsingJoins();
		list.forEach(row->{
			for(Object val:row) {
				System.out.print(val+"   ");
			}
			System.out.println();
		});
	
	}

}
