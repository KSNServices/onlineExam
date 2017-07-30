
package com.onlineexam.service;

import java.util.List;

import com.onlineexam.model.ClassSection;

public interface ClassSectionService {

	
	
	public List<ClassSection> listClassSection(int adminId ,int schoolId , String classPresent);

	public void saveClassSection(ClassSection classSection);

	public ClassSection getClassSectionById(Integer classSectionId);

	public	ClassSection ClassSectionList(int adminId, int schoolId, String classPresent, String classSectionValue);

	public	List<ClassSection> listClassSectionTotal(int adminId, int schoolId);

}
