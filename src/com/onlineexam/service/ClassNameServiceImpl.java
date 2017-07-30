

package com.onlineexam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineexam.dao.ClassNameDAO;

import com.onlineexam.model.ClassName;

@Service
public class ClassNameServiceImpl implements ClassNameService{
	
	@Autowired
	private ClassNameDAO classNameDAO;

	@Override
	@Transactional
	public List<ClassName> listClassName(int adminId ,int schoolId) {
		return classNameDAO.listClassName(adminId, schoolId);
	}

	@Override
	@Transactional
	public ClassName listClassNamePresent(int adminId ,int schoolId, String classPresent) {
		return classNameDAO.listClassNamePresent(adminId, schoolId ,classPresent);
	}

	

	@Override
	@Transactional
	public void saveClassName(ClassName className) {
		classNameDAO.saveClassName(className);
		
	}

	@Override
	@Transactional
	public ClassName getClassNameById(Integer classNameId) {
		return classNameDAO.getClassNameById(classNameId);
	}
	
	

}
