package com.gk.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.gk.repository.IDoctorRepository;


@Component
public class JpaRepoTestRunner implements CommandLineRunner {

	@Autowired
	private IDoctorRepository repo;
	@Override
	public void run(String... args) throws Exception {
		
	// =======finder method==============
		repo.findByDocNameEquals("akash").forEach(System.out::println);
		System.out.println("--------------------------------------------------------------------");
		repo.findByDocNameIs("deepak").forEach(System.out::println);
		System.out.println("----------------------------------------------------------------------");
		repo.findByDocName("hirdesh").forEach(System.out::println);
		System.out.println("--------------------------------------------------------------------------");
		repo.findByDocNameStartingWith("G").forEach(System.out::println);
		System.out.println("--------------------------------------------------------------------------");
		repo.findByDocNameEndingWith("h").forEach(System.out::println);
		System.out.println("--------------------------------------------------------------------------");
		repo.findByDocNameContaining("ka").forEach(System.out::println);
		System.out.println("---------------------------------------------------------------------------");
		repo.findByIncomeGreaterThanEqualAndIncomeLessThanEqual(10000.0,200000.0).forEach(System.out::println);
		System.out.println("----------------------------------------------------------------------------");
		repo.findBySpecializationInOrIncomeBetween(List.of("cardio","physician"), 1000.0,200000.0).forEach(System.out::println);
	}

}
