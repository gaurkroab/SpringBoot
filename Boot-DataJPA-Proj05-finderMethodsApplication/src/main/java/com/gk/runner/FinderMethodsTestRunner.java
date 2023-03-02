package com.gk.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.gk.repository.IDoctorRepository;
import com.gk.view.IResultView;
import com.gk.view.IResultView1;

@Component
public class FinderMethodsTestRunner implements CommandLineRunner {

	@Autowired
	private IDoctorRepository repo;

	@Override
	public void run(String... args) throws Exception {
		Iterable<IResultView> it = repo.findBySpecializationIn(List.of("cardio"));
		it.forEach(doc-> {
			System.out.println(doc.getDocName()+"-----"+doc.getIncome());});
		
		System.out.println("-------------------------------------------------------------------");
		Iterable<IResultView> it1 = repo.findByIncomeBetween(1000, 200000, IResultView.class);
		it1.forEach(data->{ System.out.println(data.getDocName()+"-----"+data.getIncome());});
		
		System.out.println("-------------------------------------------------------------------");
		Iterable<IResultView1> it2 = repo.findByIncomeBetween(1000, 200000, IResultView1.class);
		it2.forEach(data->{ System.out.println(data.getDocName()+"-----"+data.getIncome()+"-----"+data.getSpecialization());});
	}
	

}
