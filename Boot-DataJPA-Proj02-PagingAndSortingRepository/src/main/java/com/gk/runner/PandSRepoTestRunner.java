package com.gk.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.gk.entity.Doctor;
import com.gk.service.IDoctorService;

@Component
public class PandSRepoTestRunner implements CommandLineRunner {
	@Autowired
	private IDoctorService service;
	
	@Override
	public void run(String... args) throws Exception {
		/*service.showDoctorBySorting(true, "docName").forEach(System.out::println);
		System.out.println("-------------------------------------------------------------");
		service.showDoctorBySorting(false,"income","docName").forEach(System.out::println);
		
			System.out.println("----------------findAll(Pageable pageable)-------------------");
			try {
				// service.showDoctorsInfoByPageNo(2, 3, true, "docName").forEach(System.out::println);
				Page<Doctor> page=service.showDoctorsInfoByPageNo(2, 3, false, "docName");
				System.out.println("page number :: "+page.getNumber());
				System.out.println("pages count :: "+page.getTotalPages());
				System.out.println("is it first page :: "+ page.isFirst());
				System.out.println("is it last page :: "+page.isLast());
				System.out.println("page size :: "+page.getSize());
				System.out.println("page Elements count :: "+ page.getNumberOfElements());
				if(!page.isEmpty()) {
					List<Doctor>  list=page.getContent();
					list.forEach(System.out::println);
				}
				else {
					System.out.println("no page found");
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		*/
		service.showDataThrougPagination(3);
	}

}
