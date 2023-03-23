package com.gk.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gk.document.Person;

public interface IPersonRepository extends MongoRepository<Person, Integer> {

}
