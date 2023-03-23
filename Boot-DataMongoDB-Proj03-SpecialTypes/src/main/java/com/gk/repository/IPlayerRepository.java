package com.gk.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gk.document.PlayerInfo;

public interface IPlayerRepository extends MongoRepository<PlayerInfo, Integer> {

}
