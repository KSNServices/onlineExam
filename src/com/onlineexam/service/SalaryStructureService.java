
package com.onlineexam.service;

import java.util.List;
import com.onlineexam.model.SalaryStructure;

public interface SalaryStructureService {

	
	public void saveSalary(SalaryStructure salaryStructure);
	public void removeSalary(SalaryStructure salaryStructure);
	public	List<SalaryStructure> listSalaryStructure(int adminId, int schoolId, String teacherGrade);

	public	Double sumSalaryStructure(int adminId, int schoolId, String teacherGrade);

	public	SalaryStructure getSalaryById(Integer id);
	

}
