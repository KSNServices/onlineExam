package com.onlineexam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineexam.dao.ConstantsDAO;

@Service
public class ConstantsServiceImpl implements ConstantsService{
	@Autowired
	private ConstantsDAO constantsDAO;
	@Override
	public List listConstants(Class classType) {
		return constantsDAO.listConstants(classType);
	}

}
