

package com.onlineexam.dao;

import java.util.List;

import com.onlineexam.model.AdditionalSalaryComponent;




public interface AddtionalSalaryComponentDAO {
	
	public void saveAdditionalSalary(AdditionalSalaryComponent salary);
	public void removeAdditionalSalary(AdditionalSalaryComponent salary);
	public	List<AdditionalSalaryComponent> listAdditionalSalaryStructure(int adminId, int schoolId, String teacherGrade);
	public	Double sumAdditionalSalaryStructure(int adminId, int schoolId, String teacherGrade);
	public	AdditionalSalaryComponent getAdditionalSalaryById(Integer id);
	public	Double sumAdditionalMonthSalaryStructure(int adminId, int schoolId, String teacherId, String month);

}
