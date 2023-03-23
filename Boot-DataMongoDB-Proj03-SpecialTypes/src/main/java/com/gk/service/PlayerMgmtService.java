package com.gk.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gk.document.PlayerInfo;
import com.gk.repository.IPlayerRepository;

@Service("playerService")
public class PlayerMgmtService implements IPlayerMgmtService {

	@Autowired
	private IPlayerRepository playerRepo;
	@Override
	public String registerPlayer(PlayerInfo player) {
		
		return "Player is saved with the id value "+playerRepo.save(player).getPid();
	}// end of method
	
	
	@Override
	public String searchPlayer(int id) {
		Optional<PlayerInfo> opt = playerRepo.findById(id);
		if(opt.isEmpty()) {
			return "Document not found";
		}
		else {
			return opt.get().toString();	
		}
	}
}
