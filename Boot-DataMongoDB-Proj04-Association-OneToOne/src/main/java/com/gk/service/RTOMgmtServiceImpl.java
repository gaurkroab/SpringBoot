package com.gk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gk.document.DrivingLicense;
import com.gk.document.Person;
import com.gk.repository.IDrivingLicenseRepository;
import com.gk.repository.IPersonRepository;


@Service("rtoService")
public class RTOMgmtServiceImpl implements IRTOMgmtService {

	@Autowired
	private IPersonRepository personRepo;
	
	@Autowired
	private IDrivingLicenseRepository licenseRepo;
	
	@Override
	public String registerPersonWithDrivingLicense(Person person) {
		return "Person with DrivingLicense is saved with id value :: "+personRepo.save(person).getPid();
	}

	@Override
	public String registerLicenseWithPerson(DrivingLicense license) {
		return "Person with DrivingLicense is saved with id value :: "+licenseRepo.save(license).getLicenseNo();
	}
	
	@Override
	public List<DrivingLicense> fetchAllLicenseDetails() {
		return licenseRepo.findAll() ;
	}
	
	@Override
	public List<Person> fetchAllPersonDetails() {
		return personRepo.findAll();
	}

}
