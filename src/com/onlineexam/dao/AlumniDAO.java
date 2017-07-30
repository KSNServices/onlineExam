package com.onlineexam.dao;

import java.util.List;

import com.onlineexam.model.Alumni;

public interface AlumniDAO {
	
public Integer getId();
	
	public void saveAlumni(Alumni alumni);
	
	
	public void removeAlumni(Alumni alumni);
	
	
	public void updateAlumni(Alumni alumni);

}
