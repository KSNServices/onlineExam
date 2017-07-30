package com.onlineexam.dao;

import java.util.List;

import com.onlineexam.model.RecruitmentMaster;

public interface RecruitmentMasterDAO {

	public List<RecruitmentMaster> listRecruitmentMaster();

	public void saveRecruitmentMaster(RecruitmentMaster recruitmentMaster);

	public RecruitmentMaster getRecruitmentMasterById(Integer rmId);

}
