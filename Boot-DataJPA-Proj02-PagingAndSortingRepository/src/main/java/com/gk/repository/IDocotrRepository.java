package com.gk.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.gk.entity.Doctor;

//public interface IDocotrRepository extends PagingAndSortingRepository<Doctor, Integer> {
public interface IDocotrRepository extends PagingAndSortingRepository<Doctor, Integer> , CrudRepository<Doctor,Integer>{
}
