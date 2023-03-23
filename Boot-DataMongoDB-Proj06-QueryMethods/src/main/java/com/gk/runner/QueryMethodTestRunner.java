package com.gk.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.gk.service.IEmployeeMgmtService;

@Component
public class QueryMethodTestRunner implements CommandLineRunner {

	@Autowired
	IEmployeeMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
		/*service.showEmpDataByAddrs("aligarh").forEach(row->{
			for(Object val:row) {
				System.out.print(val+"--");
			}
			System.out.println();
		});
		*/
		
		//service.showEmpAllDataByAddrs("lucknow").forEach(System.out::println);
		//service.showEmpAllDataByAddrsAndName("aligarh", "rishabh").forEach(System.out::println);
		//service.showEmpAllDataBySalaryRange(20000.0, 80000.0).forEach(System.out::println);
		//service.showEmpAllDataByAddresses("aligarh", "lucknow").forEach(System.out::println);
		//service.showEmpAllDataByEnameInitialChars("a").forEach(System.out::println);
		//System.out.println(service.fetchEmpsCountBySalaryRange(20000.0, 80000.0));
		service.fetchEmpsDataByEnameSorted().forEach(System.out::println);
		
	}

}
