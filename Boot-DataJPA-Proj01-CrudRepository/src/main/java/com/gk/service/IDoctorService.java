package com.gk.service;

import com.gk.entity.Doctor;

public interface IDoctorService {
	public String registerDoctor(Doctor doctor);
	public String registerGroupOfDoctorrs(Iterable<Doctor> doctors);
	public long fetchDoctorsCount();
	public boolean checkDoctorAvailability(Integer id);
	public Iterable<Doctor> showAllDoctors();
	public Iterable<Doctor> showAllDoctorsByIds(Iterable<Integer> ids);
	public Doctor showDoctorById(Integer id);
	public String updateDoctorIncomeById(Integer id, float hikePercentage);
	public String registerOrUpdateDoctor(Doctor doctor);
	public String deleteDoctorById(Integer id);
	public String deleteDoctor(Doctor doctor);
}
