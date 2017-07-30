package com.onlineexam.service;

import java.util.List;

import com.onlineexam.model.AcademicYear;

public interface AcademicYearService {

	public List<AcademicYear> listAcademicYear();

	public void saveAcademicYear(AcademicYear academicYear);

	public AcademicYear getAcademicYearById(Integer academicYearId);
	
	

}
