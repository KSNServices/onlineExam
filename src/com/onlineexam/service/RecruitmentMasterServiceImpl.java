package com.onlineexam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineexam.dao.RecruitmentMasterDAO;
import com.onlineexam.model.RecruitmentMaster;

@Service
public class RecruitmentMasterServiceImpl implements RecruitmentMasterService{
	
	@Autowired
	private RecruitmentMasterDAO recruitmentMasterDAO;

	@Override
	@Transactional
	public List<RecruitmentMaster> listRecruitmentMaster() {
		return recruitmentMasterDAO.listRecruitmentMaster();
	}

	@Override
	@Transactional
	public void saveRecruitmentMaster(RecruitmentMaster recruitmentMaster) {
		recruitmentMasterDAO.saveRecruitmentMaster(recruitmentMaster);
	}

	@Override
	@Transactional
	public RecruitmentMaster getRecruitmentMasterById(Integer rmId) {
		return recruitmentMasterDAO.getRecruitmentMasterById(rmId);
	}
	
	
	

}
