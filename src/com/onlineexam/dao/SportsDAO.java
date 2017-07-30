package com.onlineexam.dao;

import java.util.List;

import com.onlineexam.model.Sports;

public interface SportsDAO {
	
public Integer getId();
	
	public void saveSports(Sports sports);
	
	
	public void removeSports(Sports sports);
	
	public void updateSports(Sports sports);

}
