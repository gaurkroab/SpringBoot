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
	public List<Doctor> showDoctorByIncomeRange(double startRange, double endRange) {
		
		return doctorRepo.searchDoctorByIncomeRange(startRange, endRange);
	}
	@Override
	public List<Doctor> showDoctorsBySpecialization(String sp1, String sp2) {
		// use repo
		List<Doctor> list = doctorRepo.searchDoctorsBySpecializations(sp1, sp2);
		return list;
	}
	@Override
	public List<Object[]> showDoctorsDataByIncome(double start, double end) {
		List<Object[]> list = doctorRepo.searchDoctorsByIncome(start, end);
		return list;
	}
	@Override
	public List<String> showDoctorsDataByIncomeRange(double min, double max) {
		List<String> list = doctorRepo.searchAllDoctorNamesByIncomeRange(min, max);
		return list;
	}
	
	@Override
	public Doctor searchDoctorByNameDocName(String docName) {
		Doctor doc = doctorRepo.showDoctorInfoByName(docName).orElseThrow(()-> new IllegalArgumentException("Doctor not found") );
		return doc;
	}
	
	@Override
	public Object searchDoctorDataByName(String name) {
		Object obj = doctorRepo.showDoctorDataByName(name);
		return obj;
	}
	
	@Override
	public String searchSpecializationByName(String name) {
		String result = doctorRepo.showSpecializationByName(name);
		return result;
	}
	
	@Override
	public int showDoctorNamesCount() {
		return doctorRepo.fetchDoctorsNameCount();
	}
	
	@Override
	public Object showAggregateData() {
		return doctorRepo.fetchAggregateData();
	}
	
	@Override
		public int appraiseDoctorsIncomeBySpecialization(String specialization, double hikePercentage) {
			int count = doctorRepo.hikeDoctorsIncomeBySpecialization(specialization, hikePercentage);
			return count;
		}	
	
	@Override
	public int fireDoctorsByIncomeRange(double start, double end) {
		int count = doctorRepo.removeDoctorsByIncomeRange(start, end);
		return count;
	}
	
	@Override
	public String insertDoctor(String name, double income, String specialization) {
		int count = doctorRepo.registerDoctor(name, specialization, income);
		return count==0?"Doctor not registered":"Doctor is registered";
	}
	
	@Override
	public String showSystemDate() {
		return doctorRepo.fetchSystemDate();
	}
	
	@Override
	public String createTempDBtable() {
		int count = doctorRepo.createTempTable();
		return count==0?"table is created":"db table is not created";
	}
}
