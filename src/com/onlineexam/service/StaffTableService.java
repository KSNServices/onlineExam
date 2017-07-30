package com.onlineexam.service;

import java.util.List;

import com.onlineexam.model.StaffTable;
import com.onlineexam.model.Teacher;

public interface StaffTableService {
	public void saveStaffTable(StaffTable staffTable);
	public List<StaffTable> listStaffTable();

	public void removeStaffTable(StaffTable StaffTableId);
	public void getLastStaffTableById(Integer Id);
	public StaffTable getStaffTableById(Integer Id);
	


}
