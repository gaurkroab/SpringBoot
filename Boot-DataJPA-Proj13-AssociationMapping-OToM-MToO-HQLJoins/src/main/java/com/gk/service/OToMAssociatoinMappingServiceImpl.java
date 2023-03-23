package com.gk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gk.repository.IPersonRepository;
import com.gk.repository.IPhoneNumberRepository;

@Service("OToMService")
public class OToMAssociatoinMappingServiceImpl implements IOToMAssociationMgmtService {

	@Autowired
	private IPersonRepository personRepo;
	
	@Autowired
	private IPhoneNumberRepository phoneRepo;
	
	@Override
	public List<Object[]> fetchDataUsingJoins() {
		
		return personRepo.getDataUsingJoins();
	}

}
