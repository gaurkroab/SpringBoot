package com.gk.service;

import java.util.List;

import com.gk.document.Player;

public interface IPlayerMgmtService {

	public String registerPlayer(Player player);
	public List<Player> searchPlayerById(Integer id);
}
