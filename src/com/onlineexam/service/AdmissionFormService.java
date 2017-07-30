package com.onlineexam.service;

import java.util.List;

import com.onlineexam.model.AdmissionFormModel;


public interface AdmissionFormService {
	public void saveRegistration(AdmissionFormModel admissionFormModel);
	public List<AdmissionFormModel> listRegistration(int adminId, int schoolId);

	public void removeRegistration(Integer registrationId);
	public void getLastRegistrationById(Integer Id);
	public AdmissionFormModel getregistrationById(Integer Id);
	public String getLaststudentId(int adminId, int studentId);
	public	AdmissionFormModel getRegistrationByRegistrationId(String id);


}
