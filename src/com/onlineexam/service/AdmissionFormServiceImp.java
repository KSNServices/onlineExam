package com.onlineexam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineexam.dao.AdmissionFormDAO;
import com.onlineexam.model.AdmissionFormModel;


@Service
public class AdmissionFormServiceImp implements AdmissionFormService {

	@Autowired
	private AdmissionFormDAO admissionFormDAO;
	
	@Override
	@Transactional
	public void saveRegistration(AdmissionFormModel admissionFormModel)
	{
		admissionFormDAO.saveRegistration(admissionFormModel);
		
	}
	
	@Transactional
	public List<AdmissionFormModel> listRegistration(int adminId, int schoolId) {		
		return admissionFormDAO.listRegistration(adminId,schoolId);
	}

	
	@Override
	@Transactional
	public void removeRegistration(Integer registrationId){
		admissionFormDAO.removeRegistration(registrationId);
	}
	
	@Override
	@Transactional
	public void getLastRegistrationById(Integer lastRegistrationId){
		lastRegistrationId=  admissionFormDAO.getLastId();}

	
	@Override
	@Transactional
	public AdmissionFormModel getregistrationById(Integer lastRegistrationId){
		return admissionFormDAO.getregistrationById(lastRegistrationId);}

	@Override
	@Transactional
	public AdmissionFormModel getRegistrationByRegistrationId(String id){
		return admissionFormDAO.getRegistrationByRegistrationId(id);}
	
	
	@Override
	@Transactional
	public String getLaststudentId(int adminId, int schoolId) {
		return admissionFormDAO.getLaststudentId(adminId, schoolId);}

}
