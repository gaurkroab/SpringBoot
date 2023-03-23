package com.gk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gk.entity.PhoneNumber;

public interface IPhoneNumberRepository extends JpaRepository<PhoneNumber, Integer> {

}
