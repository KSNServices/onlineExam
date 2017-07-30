

package com.onlineexam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineexam.dao.ClassSectionDAO;

import com.onlineexam.model.ClassSection;

@Service
public class ClassSectionServiceImpl implements ClassSectionService{
	
	@Autowired
	private ClassSectionDAO classSectionDAO;


	
	
	@Override
	@Transactional
	public void saveClassSection(ClassSection classSection) {
		classSectionDAO.saveClassSection(classSection);
	}

	@Override
	@Transactional
	public ClassSection getClassSectionById(Integer classSectionId) {
		return classSectionDAO.getClassSectionById(classSectionId);
	}
	
	

	@Override
	@Transactional
	public ClassSection ClassSectionList(int adminId, int schoolId, String classPresent,String classSectionValue) {
		return classSectionDAO.ClassSectionList(adminId, schoolId, classPresent, classSectionValue);
	}

	@Override
	@Transactional
	public List<ClassSection> listClassSection(int adminId, int schoolId, String classPresent) {
		return classSectionDAO.listClassSection(adminId, schoolId, classPresent);
	}
	
	@Override
	@Transactional
	public List<ClassSection> listClassSectionTotal(int adminId, int schoolId) {
		return classSectionDAO.listClassSectionTotal(adminId, schoolId);
	}
	
	

}
