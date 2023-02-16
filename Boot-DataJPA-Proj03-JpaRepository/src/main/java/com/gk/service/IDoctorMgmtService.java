package com.gk.service;

import java.util.List;

import com.gk.entity.Doctor;

public interface IDoctorMgmtService {
	public String deleteDoctorsByIdsInBatch(List<Integer> ids);
	public List<Doctor> showDoctorsByExampleData(Doctor exDoctor,boolean ascOrder,String ...properties);
	public Doctor findDoctorById(Integer id);
}
