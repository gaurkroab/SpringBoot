package com.gk.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gk.document.DrivingLicense;
import com.gk.document.Person;

public interface IDrivingLicenseRepository extends MongoRepository<DrivingLicense, Long>{
	
	
}
