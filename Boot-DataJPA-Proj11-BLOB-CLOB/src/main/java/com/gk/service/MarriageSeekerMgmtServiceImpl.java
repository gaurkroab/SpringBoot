package com.gk.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gk.entity.MarriageSeeker;
import com.gk.repository.IMarriageSeekerRepo;

@Service("marriageSeeker")
public class MarriageSeekerMgmtServiceImpl implements IMarriageSeekerMgmtService {

	@Autowired
	private IMarriageSeekerRepo msRepo;
	
	@Override
	public String registerMarriageSeeker(MarriageSeeker seeker) {
		return "Marriage Seeker info is saved with id value " +msRepo.save(seeker).getId();
	}
	
	@Override
	public Optional<MarriageSeeker> searchSeekerById(Integer id) {
		return msRepo.findById(id);
	}
}
