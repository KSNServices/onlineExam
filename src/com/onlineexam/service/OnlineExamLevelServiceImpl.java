package com.onlineexam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineexam.dao.OnlineExamLevelDAO;
import com.onlineexam.model.OnlineExamLevels;

@Service
public class OnlineExamLevelServiceImpl implements OnlineExamLevelService{
	
	@Autowired
	private OnlineExamLevelDAO onlineExamLevelDAO;

	@Override
	@Transactional
	public OnlineExamLevels getOnlineExamLevelById(Integer oeLevelId) {
		return onlineExamLevelDAO.getOnlineExamLevelById(oeLevelId);
	}

	@Override
	@Transactional
	public List<OnlineExamLevels> listOnlineExamLevels() {
		return onlineExamLevelDAO.listOnlineExamLevels();
	}

	@Override
	@Transactional
	public void saveOnlineExamLevel(OnlineExamLevels examLevels) {
		onlineExamLevelDAO.saveOnlineExamLevel(examLevels);
	}
	
	

}
