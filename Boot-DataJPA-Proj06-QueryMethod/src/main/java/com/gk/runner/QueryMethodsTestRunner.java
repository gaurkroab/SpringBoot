package com.gk.runner;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.gk.entity.Doctor;
import com.gk.service.IDoctorMgmtService;

@Component
public class QueryMethodsTestRunner implements CommandLineRunner {

	@Autowired
	private IDoctorMgmtService service;
	@Override
	public void run(String... args) throws Exception {
		//service.showDoctorByIncomeRange(1000.0, 200000.0).forEach(System.out::println);
		
		// -------------------Select - Entity Query-------------------
		/*service.showDoctorsBySpecialization("cardio", "physician").forEach(System.out::println);
		System.out.println("---------------------------Select -- Entity Projection Query (specific multiple col values) -----");
		service.showDoctorsDataByIncome(1000.0, 200000.0).forEach(row->{
								for(Object obj:row) {
									System.out.print(obj+"---");
								}
								System.out.println();
							});
		
			System.out.println("-----------------------Select --- Entity Projection Query ----(specific single col value---");
			service.showDoctorsDataByIncomeRange(1000.0, 20000.0).forEach(System.out::println);
			
			System.out.println("=====================================================");
			Doctor doctor = service.searchDoctorByNameDocName("deepak");
			System.out.println("Doctor Info :: "+ doctor);
			
			System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=");
			Object obj =service.searchDoctorDataByName("sachin");
			Object data[] =(Object[])obj;
			for(Object o:data) {
				System.out.print(o+"       ");
			}
			System.out.println();
			System.out.println("Result is :: "+Arrays.toString(data));
			
			
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
			String result = service.searchSpecializationByName("deepak");
			System.out.println("Specialization is ::: "+result);
			
			*/
		
		/*	System.out.println("unique doctor names count :: "+service.showDoctorNamesCount());
			System.out.println("-----------------------------------------------------------------------------------------------");
			Object[] results=(Object[])service.showAggregateData();
			System.out.println("records count :: "+results[0]);
			System.out.println("max income value :: "+results[1]);
			System.out.println("min income value :: "+results[2]);
			System.out.println("sum of income  :: "+results[3]);
			System.out.println("avg of income  :: "+results[4]);*/
		
		/*System.out.println("--------------non-select operations -----------");
		int count=service.appraiseDoctorsIncomeBySpecialization("cardio", 10.0);
		System.out.println("no. of records that are effected :: "+count);
		System.out.println("deleted doctors count::"+service.fireDoctorsByIncomeRange(85000.0, 200000.0));*/
		
		System.out.println("-----------------native SQL Queries ------------------------");
		//System.out.println(service.insertDoctor("hiredesh", 75000.0, "cardio"));
		
		System.out.println("system date time :: "+service.showSystemDate());
		System.out.println("-----------------------------------");
		//System.out.println(service.createTempDBtable());
		
		}
	
}
