package com.gk.service;

import java.util.Optional;

import com.gk.entity.MarriageSeeker;

public interface IMarriageSeekerMgmtService {
	public String registerMarriageSeeker(MarriageSeeker seeker);
	public Optional<MarriageSeeker> searchSeekerById(Integer id);
}
