package com.gk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.gk.entity.Doctor;
import com.gk.repository.IDocotrRepository;

@Service("doctorService")
public class DoctorServiceImpl implements IDoctorService {

	@Autowired
	private IDocotrRepository doctorRepo;
	@Override
	public Iterable<Doctor> showDoctorBySorting(boolean asc, String... props) {
		// prepaer the Sort object
		Sort sort = Sort.by(asc?Direction.ASC:Direction.DESC,props);
		// use Repo
		Iterable<Doctor> it=doctorRepo.findAll(sort);
		return it;
	}
	
	@Override
	public Page<Doctor> showDoctorsInfoByPageNo(int pageNO, int pageSize, boolean ascOrder, String props) {
		// prepare the Sort object
		Sort sort=Sort.by(ascOrder?Direction.ASC:Direction.DESC,props);
		// prepare Pageable object
		Pageable pageable=PageRequest.of(pageNO, pageSize,sort);
		// use Repo
		Page<Doctor> page=doctorRepo.findAll(pageable);
		return page;
	}
	
	@Override
	public void showDataThrougPagination(int pageSize) {
		// decode the no. of pages
		long count = doctorRepo.count();
		long pagesCount = count/pageSize;
		// pagesCount = count%pageSize==0?pagesCount:++pagesCount;
		if(count%pagesCount!=0) {
			pagesCount++;
		}
		for(int i=0;i<pagesCount;i++) {
			// create Pageable object
			Pageable pageable = PageRequest.of(i, pageSize);
			// get each page records
			Page<Doctor> page = doctorRepo.findAll(pageable);
			System.out.println("Page :: "+ (page.getNumber()+1)+"  records of   "+page.getTotalPages());
			page.getContent().forEach(System.out::println);
			System.out.println("---------------------------------------------------------------------------------");
		}
		
	}

}
