package com.gk.service;

import com.gk.document.PlayerInfo;

public interface IPlayerMgmtService {

	public String registerPlayer(PlayerInfo player);
	public String searchPlayer(int id);
}
