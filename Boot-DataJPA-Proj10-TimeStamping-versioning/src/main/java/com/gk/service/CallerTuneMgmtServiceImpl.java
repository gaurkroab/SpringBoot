package com.gk.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gk.entity.CallerTuneInfo;
import com.gk.repository.ICallerTuneInfoRepository;

@Service("callerTuneService")
public class CallerTuneMgmtServiceImpl implements ICallerTuneMgmtService {
	
	@Autowired
	private ICallerTuneInfoRepository callerTuneRepo;
	
	@Override
	public String saveCallerTuneInfo(CallerTuneInfo info) {
		Integer idVal = callerTuneRepo.save(info).getTuneId();
		return "CallerTune is saved with the id Value :: "+idVal ;
	}
	@Override
	public CallerTuneInfo showCallerTuneDetailsById(Integer id) {
		
		return callerTuneRepo.findById(id).orElseThrow(()->new IllegalArgumentException("caller tune not found"));
	}
	@Override
	public String updatedTuneInfoById(Integer id,String tuneName,String movieName) {
		Optional<CallerTuneInfo> opt = callerTuneRepo.findById(id);
		if(opt.isPresent()) {
			CallerTuneInfo info = opt.get();
			info.setTuneName(tuneName);
			info.setMovieName(movieName);
			CallerTuneInfo tune = callerTuneRepo.save(info);
			return "Object is updated for "+tune.getUpdatedCount()+"times ... lastely modified on: "+tune.getLastlyUpdatedOn()+"......crated On ::: "+tune.getServiceOptedOn();
		}
		else {
			return "CallerTune service is not found";
		}
	}
}
