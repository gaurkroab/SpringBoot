package com.gk;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.gk.entity.Doctor;
import com.gk.service.IDoctorService;

@SpringBootApplication
public class BootDataJpaProj01CrudRepositoryApplication {

	public static void main(String[] args) {
		// get IOC container

		ApplicationContext ctx = SpringApplication.run(BootDataJpaProj01CrudRepositoryApplication.class, args);
		// get service class obj
		IDoctorService service = ctx.getBean("doctorService", IDoctorService.class);

		/*	 try {
				 // create Doctor class object
				 Doctor doctor = new Doctor();
				 doctor.setDocName("Gaurav");
				 doctor.setSpecialization("MD-Cardio");
				 doctor.setIncome(900000.0);
				 // invoke the method
				 String resultMsg=service.registerDoctor(doctor);
				 System.out.println(resultMsg);
			 }
			 catch(Exception e) {
				 e.printStackTrace();
			 }
		*/
		/*try {
		Doctor doc1 = new Doctor();
		doc1.setDocName("akash"); doc1.setIncome(90000.0);  doc1.setSpecialization("cardio");
		
		Doctor doc2 = new Doctor();
		doc2.setDocName("hirdesh"); doc2.setIncome(92000.0);  doc2.setSpecialization("physician");
		
		Doctor doc3 = new Doctor();
		doc3.setDocName("deepak"); doc3.setIncome(93000.0);  doc3.setSpecialization("ortho");
		
		String msg = service.registerGroupOfDoctorrs(List.of(doc1,doc2,doc3));
		// String msg = service.registerGroupOfDoctorrs(Arrays.asList(doc1,doc2,doc3));
		
		System.out.println(msg);
		}
		catch(Exception e) {
		 e.printStackTrace();
		}
		*/
		/* 
		 try {
			 System.out.println("count of records :: "+ service.fetchDoctorsCount());
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		 
		 try {
			 System.out.println("8 id doctor esixts ? :: "+ service.checkDoctorAvailability(8));
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		 
		 try {
			 Iterable<Doctor> it = service.showAllDoctors();
			 it.forEach(doc->System.out.println(doc)); // java 8 forEach(-) method
			 
				 System.out.println("------------------------------------------------------------------");
				 it.forEach(System.out::println);  // java 8 forEach(-) + static method reference
				 
				 System.out.println("-------------------------------------------------------------------");
				 for(Doctor doc:it) {                       // java 5 enhanced for loop
					 System.out.println(doc);
				 }
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		 */
		try {
			service.showAllDoctorsByIds(List.of(2, 4, 7, 8)).forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			Doctor doctor = service.showDoctorById(4);
			System.out.println(doctor);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		/*try {
			System.out.println(" 5 doctor info :: "+service.showDoctorById(5));
			System.out.println(service.updateDoctorIncomeById(5, 1111.0f));
			System.out.println(" 5 doctor info :: "+service.showDoctorById(5));
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		/*try {
			Doctor doc=new Doctor();
			doc.setDocId(15); doc.setDocName("sachin"); doc.setIncome(1111.11);
			System.out.println(service.registerOrUpdateDoctor(doc));
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		/*	try {
				System.out.println(service.deleteDoctorById(5));
			}
			catch(Exception e) {
				e.printStackTrace();
			}*/
		
		try {
			Doctor doc = new Doctor();
			doc.setDocId(4); doc.setDocName("deepak");
			System.out.println(service.deleteDoctor(doc));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		// close the IOC container
		((ConfigurableApplicationContext) ctx).close();
	}

}
