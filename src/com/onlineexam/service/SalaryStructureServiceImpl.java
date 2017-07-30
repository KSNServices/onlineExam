

package com.onlineexam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.onlineexam.dao.SalaryStructureDAO;
import com.onlineexam.model.SalaryStructure;


@Service
public class SalaryStructureServiceImpl implements SalaryStructureService {

	@Autowired
	private SalaryStructureDAO salaryStructureDAO;
	
	@Override
	@Transactional
	public void saveSalary(SalaryStructure salaryStructure) {
		salaryStructureDAO.saveSalary(salaryStructure);
		
	}
	@Override
	@Transactional
	public List<SalaryStructure> listSalaryStructure(int adminId, int schoolId, String teacherGrade) {
		return salaryStructureDAO.listSalaryStructure(adminId,schoolId,teacherGrade);
	}

	@Override
	@Transactional
	public void removeSalary(SalaryStructure salaryStructure) {
		salaryStructureDAO.removeSalary(salaryStructure);
		
	}
	
	@Override
	@Transactional
	public SalaryStructure getSalaryById(Integer feeId){
		return salaryStructureDAO.getSalaryById(feeId);}

	@Override
	@Transactional
	public Double sumSalaryStructure(int adminId, int schoolId, String teacherGrade) {
		return  salaryStructureDAO.sumSalaryStructure(adminId, schoolId, teacherGrade);
	}





	

}

