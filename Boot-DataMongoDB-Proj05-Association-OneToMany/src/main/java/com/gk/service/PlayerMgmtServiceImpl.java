package com.gk.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gk.document.Player;
import com.gk.repository.IPlayerRepository;

@Service("playerService")
public class PlayerMgmtServiceImpl implements IPlayerMgmtService {

	@Autowired
	private IPlayerRepository playerRepo;
	@Override
	public String registerPlayer(Player player) {
		
		return "Player with sports info and medals info is saved with the id value :: "+playerRepo.insert(player).getPid();
	}
	
	@Override
	public List<Player> searchPlayerById(Integer id) {
		Optional<Player> opt = playerRepo.findById(id);
		List<Player> list =(List<Player>) opt.get();
		return list;
	}

}
