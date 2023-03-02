package com.gk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gk.entity.Doctor;
import com.gk.view.IResultView;
import com.gk.view.IView;

public interface IDoctorRepository extends JpaRepository<Doctor,Integer> {
	public Iterable<IResultView> findBySpecializationIn(List<String> specials);
	public <T extends IView> Iterable<T> findByIncomeBetween(double start,double end ,Class<T> clazz);
}
