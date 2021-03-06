package com.onlineexam.dao;

import java.util.List;

import com.onlineexam.model.StudentFeeDetail;

public interface StudentFeeDetailDAO {
	
	public Integer getId();
	
	public void saveStudentFeeDetail(StudentFeeDetail studentFeeDetail);
	
	public List<StudentFeeDetail> listStudentFeeDetails(int adminId, int schoolId);
	
	public void removeStudentFeeDetail(StudentFeeDetail studentFeeDetail);
	
	public void updateStudentFeeDetail(StudentFeeDetail studentFeeDetail);

	public	StudentFeeDetail getStudentByStudentId(String id);

	public	List<StudentFeeDetail> listStudentEditFeeDetails(int adminId, int schoolId, String sequenceStudentId);

	public	Double getSumTotalFeeSchool(int adminId, int schoolId);

	public	Double getRemainingTotalAdminFee(int adminId);

	public	Double getSumTotalAdminFee(int adminId);

	public	Double getRemainingTotalFeeSchool(int adminId, int schoolId);

}
