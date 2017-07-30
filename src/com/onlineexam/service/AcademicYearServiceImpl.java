package com.onlineexam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineexam.dao.AcademicYearDAO;
import com.onlineexam.model.AcademicYear;

@Service
public class AcademicYearServiceImpl implements AcademicYearService{
	
	@Autowired
	private AcademicYearDAO academicYearDAO;

	@Override
	@Transactional
	public List<AcademicYear> listAcademicYear() {
		return academicYearDAO.listAcademicYear();
	}

	@Override
	@Transactional
	public void saveAcademicYear(AcademicYear academicYear) {
		academicYearDAO.saveAcademicYear(academicYear);
	}

	@Override
	@Transactional
	public AcademicYear getAcademicYearById(Integer academicYearId) {
		return academicYearDAO.getAcademicYearById(academicYearId);
	}
	
	

}
