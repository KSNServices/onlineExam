

package com.onlineexam.service;

import java.util.List;

import com.onlineexam.model.TeacherPaymentDetail;

public interface TeacherSalaryDetailService 
{

public	void saveTeacherSalaryDetail(TeacherPaymentDetail teacherPaymentDetail);

public	List<TeacherPaymentDetail> listTeacherEditSalaryDetails(int adminId, int schoolId, String sequenceTeacherId);

public	List<TeacherPaymentDetail> listTeacherFeeDetails(int adminId, int schoolId);

public	TeacherPaymentDetail getTeacherByTeacherId(String id);

public	void removeTeacherSalaryDetail(TeacherPaymentDetail teacherPaymentDetail);
	
}