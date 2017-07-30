package com.onlineexam.service;

import java.util.List;


import com.onlineexam.model.FeeStructure;

public interface FeeStructureService {

	public void saveFeeStructure(FeeStructure feeStructure);

	public List<FeeStructure> listFeeStructure(int adminId, int schoolId,String classValue, String section);

	public void removeFeeStructure(FeeStructure feeDetailsID);
	public FeeStructure getFeeById(Integer Id);
	public Double  getFeeClass(int adminId, int schoolId,String classvalue, String section);

}
