package com.gk.service;

import com.gk.entity.CallerTuneInfo;

public interface ICallerTuneMgmtService {
	public String saveCallerTuneInfo(CallerTuneInfo info);
	public String updatedTuneInfoById(Integer id,String tuneName,String movieName);
	public CallerTuneInfo showCallerTuneDetailsById(Integer id);
}
