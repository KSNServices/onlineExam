package com.onlineexam.dao;

import java.util.List;

import com.onlineexam.model.Transportation;

public interface TransportationDAO {
	
public Integer getId();
	
	public void saveTransportation(Transportation transportation);
	
	
	public void removeTransportation(Transportation transportation);
	
	public void updateTransportation(Transportation transportation);
	

}
