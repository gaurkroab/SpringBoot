package com.gk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gk.entity.Doctor;

public interface IDoctorRepository extends JpaRepository<Doctor,Integer> {

}
