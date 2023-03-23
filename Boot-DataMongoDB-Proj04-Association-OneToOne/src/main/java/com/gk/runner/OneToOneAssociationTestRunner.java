package com.gk.runner;

import java.time.LocalDate;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.gk.document.DrivingLicense;
import com.gk.document.Person;
import com.gk.service.IRTOMgmtService;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;

@Component
public class OneToOneAssociationTestRunner implements CommandLineRunner {

	@Autowired
	private IRTOMgmtService service;
	@Override
	public void run(String... args) throws Exception {
		/*// parent to child
		try {
			Person per = new Person(1001,"gaurav","aligarh");
			DrivingLicense license = new DrivingLicense(54545454L, "2-wheeler", LocalDate.now());
			// child to parent 
			per.setLicenseDetails(license);
			
			System.out.println(service.registerPersonWithDrivingLicense(per));
			
		}
		catch(Exception e) {
			 e.printStackTrace();
		}
		*/
		
		/*	//  child to parent
					try {
						Person per = new Person(new Random().nextInt(1000),"akash1","aligarh1");
						DrivingLicense license = new DrivingLicense(new Random().nextLong(9999999L), "4-wheeler", LocalDate.now());
						// parent to child 
						license.setPersonDetails(per);
						
						System.out.println(service.registerLicenseWithPerson(license));
						
					}
					catch(Exception e) {
						 e.printStackTrace();
					}
		*/
		
		System.out.println("==================parent to child ============");
		service.fetchAllPersonDetails().forEach(per ->{
			System.out.println("parent :: "+per);
			DrivingLicense license = per.getLicenseDetails();
			System.out.println("child :: "+license);
		});
		
		System.out.println("==================  child to parent ============");
		service.fetchAllLicenseDetails().forEach(lic ->{
			System.out.println("child :: "+lic);
			Person per = lic.getPersonDetails();
			System.out.println("parent :: "+per);
		});
	}

}
