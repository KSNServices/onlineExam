package com.onlineexam.dao;

import java.util.List;

import com.onlineexam.model.SchoolInfrastructure;

public interface SchoolInfrastructureDAO {

public Integer getId();
	
	public void saveSchoolInfrastructure(SchoolInfrastructure school_infrastructure);
	
	
	public void removeSchoolInfrastructure(SchoolInfrastructure school_infrastructure);
	
	
	public void updateSchoolInfrastructure(SchoolInfrastructure school_infrastructure);
}
