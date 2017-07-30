package com.onlineexam.dao;

import java.util.List;

import com.onlineexam.model.Requirement;

public interface RequirementDAO {

	public Integer getId();
	
	public void saveRequirement( Requirement requirement);
	
	
	public void removeRequirement( Requirement requirement);
	
	
	public void updateRequirement( Requirement requirement);
}
