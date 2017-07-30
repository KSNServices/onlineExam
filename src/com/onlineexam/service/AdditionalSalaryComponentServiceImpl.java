


package com.onlineexam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.onlineexam.dao.AddtionalSalaryComponentDAO;
import com.onlineexam.model.AdditionalSalaryComponent;



@Service
public class AdditionalSalaryComponentServiceImpl implements AdditionalSalaryComponentService {

	@Autowired
	private AddtionalSalaryComponentDAO addtionalSalaryComponentDAO;

	@Override
	@Transactional
	public void saveAdditionalSalary(AdditionalSalaryComponent salary) {
		addtionalSalaryComponentDAO.saveAdditionalSalary(salary);
		
	}
	@Override
	@Transactional
	public void removeAdditionalSalary(AdditionalSalaryComponent salary) {
		addtionalSalaryComponentDAO.removeAdditionalSalary(salary);
		
	}
	@Override
	@Transactional
	public List<AdditionalSalaryComponent> listAdditionalSalaryStructure(int adminId, int schoolId,
			String teacherGrade) {
		return addtionalSalaryComponentDAO.listAdditionalSalaryStructure(adminId,schoolId,teacherGrade);
	}
	@Override
	@Transactional
	public Double sumAdditionalSalaryStructure(int adminId, int schoolId, String teacherGrade) {
		return  addtionalSalaryComponentDAO.sumAdditionalSalaryStructure(adminId, schoolId, teacherGrade);
	}
	@Override
	@Transactional
	public AdditionalSalaryComponent getAdditionalSalaryById(Integer id) {

		return addtionalSalaryComponentDAO.getAdditionalSalaryById(id);
	}





	

}

