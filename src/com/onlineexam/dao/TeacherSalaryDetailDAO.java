


package com.onlineexam.dao;

import java.util.List;

import com.onlineexam.model.TeacherPaymentDetail;

public interface TeacherSalaryDetailDAO {

 public	void saveTeacherSalaryDetail(TeacherPaymentDetail teacherPaymentDetail);

 public	void removeTeacherSalaryDetail(TeacherPaymentDetail teacherPaymentDetail);

 public	TeacherPaymentDetail getTeacherByTeacherId(String id);

 public	List<TeacherPaymentDetail> listTeacherFeeDetails(int adminId, int schoolId);

 public	List<TeacherPaymentDetail> listTeacherEditSalaryDetails(int adminId, int schoolId, String sequenceTeacherId);
}
