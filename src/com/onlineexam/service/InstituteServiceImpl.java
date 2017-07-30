package com.onlineexam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineexam.dao.InstituteDAO;

@Service
public class InstituteServiceImpl implements InstituteService{
	
	@Autowired
	private InstituteDAO instituteDAO;
	
	

}
