package com.onlineexam.service;

import java.util.List;

import com.onlineexam.model.StudentFeeDetail;

public interface StudentFeeDetailService {

	public void saveStudentFeeDetail(StudentFeeDetail studentFeeDetail);

	public List<StudentFeeDetail> listStudentFeeDetail(int adminId, int schoolId);

	public void removeStudentFeeDetail(StudentFeeDetail StudentFeeDetailId);

	public StudentFeeDetail getStudentByStudentId(String id);

	public	List<StudentFeeDetail> listStudentEditFeeDetails(int adminId, int schoolId, String sequenceStudentId);

}