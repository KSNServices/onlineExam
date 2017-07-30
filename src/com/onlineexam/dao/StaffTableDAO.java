package com.onlineexam.dao;

import java.util.List;

import com.onlineexam.model.StaffTable;
import com.onlineexam.model.User;

public interface StaffTableDAO {
	
public Integer getId();
	
	public void saveStaffTable(StaffTable stafftable);
	
	public List<StaffTable> staffTable();
	public void removeStaffTable(Integer staffId);
	
	public void updateStaffTable(Integer staffId);
	
	public void getStaffTableById(Integer staffId);
	
	
}
