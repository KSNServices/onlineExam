package com.onlineexam.dao;

import java.util.List;


import com.onlineexam.model.FeeStructure;

public interface FeeStructureDAO {
	
	public Integer getId();
	
	public void saveFeeStructure(FeeStructure feestructure);

	
	public void removeFeeStructure(FeeStructure feeDetailsID);
	
	public void updateFeeStructure(FeeStructure feestructure);
	public FeeStructure getFeeById(Integer Id);

	public  List<FeeStructure> listFeeStructure(int adminId, int schoolId, String classValue, String section);

	public	Double getFeeClass(int adminId, int schoolId, String classvalue, String section);

}
