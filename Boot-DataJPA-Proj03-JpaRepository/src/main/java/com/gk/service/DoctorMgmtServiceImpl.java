package com.gk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.gk.entity.Doctor;
import com.gk.repository.IDoctorRepository;

@Service("doctorService")
public class DoctorMgmtServiceImpl implements IDoctorMgmtService {

	@Autowired
	private IDoctorRepository doctorRepo;
	@Override
	public String deleteDoctorsByIdsInBatch(List<Integer> ids) {
		// load the entities 
		List<Doctor> list = doctorRepo.findAllById(ids);
		// delete the entities
		doctorRepo.deleteAllByIdInBatch(ids);
		return list.size() + "  :: records are deleted"; 
	}
	
	@Override
	public List<Doctor> showDoctorsByExampleData(Doctor exDoctor, boolean ascOrder, String... properties) {
		// prepare Sort Object
		Sort sort=Sort.by(ascOrder?Direction.ASC:Direction.DESC,properties);
		// Example object
		Example example = Example.of(exDoctor);
		// use the repo
		List<Doctor> list = doctorRepo.findAll(example, sort);
		// return the collection
		return list;
	}

	@Override
	public Doctor findDoctorById(Integer id) {
		// Doctor doctor = doctorRepo.getById();
		Doctor doctor = doctorRepo.getReferenceById(id);
		return doctor;
	}
}
