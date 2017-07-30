
package com.onlineexam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineexam.dao.FeeStructureDAO;
import com.onlineexam.model.AdmissionFormModel;
import com.onlineexam.model.FeeStructure;


@Service
public class FeeStructureServiceImpl implements FeeStructureService {

	@Autowired
	private FeeStructureDAO feeStructureDAO;
	
	@Override
	@Transactional
	public void saveFeeStructure(FeeStructure feeStructure) {
		feeStructureDAO.saveFeeStructure(feeStructure);
		
	}
	@Override
	@Transactional
	public List<FeeStructure> listFeeStructure(int adminId, int schoolId,String classValue, String section) {
		return feeStructureDAO.listFeeStructure(adminId,schoolId,classValue , section);
	}

	@Override
	@Transactional
	public void removeFeeStructure(FeeStructure feeDetailsID) {
		feeStructureDAO.removeFeeStructure(feeDetailsID);
		
	}
	
	@Override
	@Transactional
	public FeeStructure getFeeById(Integer feeId){
		return feeStructureDAO.getFeeById(feeId);}

	@Override
	@Transactional
	public Double getFeeClass(int adminId, int schoolId,String classvalue, String section) {
		return  feeStructureDAO.getFeeClass(adminId, schoolId, classvalue, section);
	}





	

}

