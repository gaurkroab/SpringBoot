package com.gk.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gk.entity.Doctor;

public interface IDoctorRepository extends JpaRepository<Doctor, Integer> {
	// select docId,docName,specialization,name from JPA_DOCTOR_INFO where DocName=?
	public List<Doctor> findByDocNameEquals(String name);

	// select docId,docName,specialization,name from JPA_DOCTOR_INFO where DocName=?
	public List<Doctor> findByDocNameIs(String name);

	// select docId,docName,specialization,name from JPA_DOCTOR_INFO where DocName=?
	public List<Doctor> findByDocName(String name);

	// select docId,docName,specialization,name from JPA_DOCTOR_INFO where DocName
	// like 'R%'
	public Iterable<Doctor> findByDocNameStartingWith(String initChars);

	// select docId,docName,specialization,name from JPA_DOCTOR_INFO where DocName
	// like '%R'
	public Iterable<Doctor> findByDocNameEndingWith(String lastChars);
	
	// select docId,docName,specialization,name from JPA_DOCTOR_INFO where DocName
		// like '%R%'
		public Iterable<Doctor> findByDocNameContaining(String chars);

	// finder methods with multiple properties based on conditions
		public Iterable<Doctor> findByIncomeGreaterThanEqualAndIncomeLessThanEqual(double startRange,double endRange);
		public Iterable<Doctor> findBySpecializationInOrIncomeBetween(List<String> specials,double start,double end);
}
