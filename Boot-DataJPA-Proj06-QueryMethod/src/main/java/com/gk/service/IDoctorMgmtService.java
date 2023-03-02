package com.gk.service;

import java.util.List;

import com.gk.entity.Doctor;

public interface IDoctorMgmtService {
	public List<Doctor > showDoctorByIncomeRange(double startRange,double endRange);
	
	public List<Doctor> showDoctorsBySpecialization(String sp1,String sp2);
	public List<Object[]> showDoctorsDataByIncome(double start,double end);
	public List<String> showDoctorsDataByIncomeRange(double min,double max);
	
	
	public Doctor searchDoctorByNameDocName(String docName);
	public Object searchDoctorDataByName(String name);
	public String searchSpecializationByName(String name);
	
	
	public int showDoctorNamesCount();
	public Object showAggregateData();
	
	public int appraiseDoctorsIncomeBySpecialization(String specialization,double hikePercentage);
	public int fireDoctorsByIncomeRange(double start,double end);
	
	public String insertDoctor(String name,double income,String specialization);
	public String showSystemDate();
	public String createTempDBtable();
}
