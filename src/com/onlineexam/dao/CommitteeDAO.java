package com.onlineexam.dao;

import java.util.List;

import com.onlineexam.model.Committee;

public interface CommitteeDAO {
	
	public Integer getId();
	
	public void saveCommittee(Committee committee);
	
	
	public void removeCommittee(Committee committee);
	
	public void updateCommittee(Committee committee);

}
