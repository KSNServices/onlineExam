package com.onlineexam.dao;

import java.util.List;

import com.onlineexam.model.OnlineExamLevels;

public interface OnlineExamLevelDAO {

	public OnlineExamLevels getOnlineExamLevelById(Integer oeLevelId);

	public List<OnlineExamLevels> listOnlineExamLevels();

	public void saveOnlineExamLevel(OnlineExamLevels examLevels);
	
	

}
