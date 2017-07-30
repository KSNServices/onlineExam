package com.onlineexam.dao;

import java.util.List;

import com.onlineexam.model.AcademicYear;

public interface AcademicYearDAO {

	public List<AcademicYear> listAcademicYear();

	public void saveAcademicYear(AcademicYear academicYear);

	public AcademicYear getAcademicYearById(Integer academicYearId);
	
	

}
