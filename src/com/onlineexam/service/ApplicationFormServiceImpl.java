package com.onlineexam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineexam.dao.ApplicationFormDAO;
import com.onlineexam.model.ApplicationForm;

@Service
public class ApplicationFormServiceImpl implements ApplicationFormService{
	
	@Autowired
	private ApplicationFormDAO applicationFormDAO;

	@Override
	@Transactional
	public List<ApplicationForm> listApplicant() {
		// TODO Auto-generated method stub
		return applicationFormDAO.listApplicant();
	}
	
	

}
