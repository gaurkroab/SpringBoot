package com.gk.service;

import java.util.List;

import com.gk.entity.Doctor;

public interface IDoctorMgmtService {
	public List<Doctor> showDoctorByIncomeRange(double start,double end);
}
