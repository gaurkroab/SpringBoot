package com.gk.repository;

import org.springframework.data.repository.CrudRepository;

import com.gk.entity.Doctor;

public interface IDoctorRepo extends CrudRepository<Doctor, Integer> {

}
