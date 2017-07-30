package com.onlineexam.service;

import java.util.List;

import com.onlineexam.model.RecruitmentMaster;

public interface RecruitmentMasterService {

	public List<RecruitmentMaster> listRecruitmentMaster();

	public void saveRecruitmentMaster(RecruitmentMaster recruitmentMaster);

	public RecruitmentMaster getRecruitmentMasterById(Integer rmId);
	
	

}
