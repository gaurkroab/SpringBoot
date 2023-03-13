package com.gk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gk.entity.Person;

public interface IPersonRepository extends JpaRepository<Person, Integer> {

}
