package com.onlineexam.dao;

import java.util.List;

import com.onlineexam.model.AdmissionFormModel;
import com.onlineexam.model.Country;


public interface AdmissionFormDAO {
	
	public Integer getLastId();
	
	public void saveRegistration(AdmissionFormModel admissionFormModel);
	public List<AdmissionFormModel> listRegistration(int adminId, int schoolId);
	
	public AdmissionFormModel getregistrationById(Integer Id);
	
	public void removeRegistration(Integer Id);

	public String getLaststudentId(int adminId, int schoolId);

	public	AdmissionFormModel getRegistrationByRegistrationId(String id);
	
	

}
