package com.gk.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gk.document.Player;

public interface IPlayerRepository extends MongoRepository<Player, Integer> {

}
