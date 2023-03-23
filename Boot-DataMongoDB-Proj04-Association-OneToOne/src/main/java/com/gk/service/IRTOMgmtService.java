package com.gk.service;

import java.util.List;

import com.gk.document.DrivingLicense;
import com.gk.document.Person;

public interface IRTOMgmtService {

	public String registerPersonWithDrivingLicense(Person person);
	public String registerLicenseWithPerson(DrivingLicense license);
	
	public List<Person> fetchAllPersonDetails();
	public List<DrivingLicense> fetchAllLicenseDetails();
}
