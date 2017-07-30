package com.onlineexam.dao;

import java.util.List;

import com.onlineexam.model.ExtraActivities;

public interface ExtraActivitiesDAO {
	
	public Integer getId();
	
	public void saveExtraActivities(ExtraActivities extra_activities);
	
	
	public void removeExtraActivities(ExtraActivities extra_activities);
	
	public void updateExtraActivities(ExtraActivities extra_activities);

}
