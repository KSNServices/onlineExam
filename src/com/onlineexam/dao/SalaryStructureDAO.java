

package com.onlineexam.dao;

import java.util.List;

import com.onlineexam.model.SalaryStructure;



public interface SalaryStructureDAO {
	
	public void saveSalary(SalaryStructure salary);
	public void removeSalary(SalaryStructure salary);
	public	List<SalaryStructure> listSalaryStructure(int adminId, int schoolId, String teacherGrade);
	public	Double sumSalaryStructure(int adminId, int schoolId, String teacherGrade);
	public	SalaryStructure getSalaryById(Integer id);

}
