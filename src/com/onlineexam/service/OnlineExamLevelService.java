package com.onlineexam.service;

import java.util.List;

import com.onlineexam.model.OnlineExamLevels;

public interface OnlineExamLevelService {

	public OnlineExamLevels getOnlineExamLevelById(Integer oeLevelId);

	public List<OnlineExamLevels> listOnlineExamLevels();

	public void saveOnlineExamLevel(OnlineExamLevels examLevels);
	
	
	

}
