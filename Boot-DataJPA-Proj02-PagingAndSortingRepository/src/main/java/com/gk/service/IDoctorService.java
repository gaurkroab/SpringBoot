package com.gk.service;

import org.springframework.data.domain.Page;

import com.gk.entity.Doctor;

public interface IDoctorService {
	public Iterable<Doctor> showDoctorBySorting(boolean asc,String...props);
	public Page<Doctor> showDoctorsInfoByPageNo(int pageNO,int pageSize,boolean ascOrder,String props);
	public void showDataThrougPagination(int pageSize);
}
