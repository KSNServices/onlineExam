package com.onlineexam.dao;

import java.util.List;

import com.onlineexam.model.ClassSchedule;

public interface ClassScheduleDAO {
	
public Integer getId();
	
	public void saveClassSchedule(ClassSchedule class_schedule);
	
	
	public void removeClassSchedule(ClassSchedule class_schedule);
	
	
	public void updateClassSchedule(ClassSchedule class_schedule);

}
