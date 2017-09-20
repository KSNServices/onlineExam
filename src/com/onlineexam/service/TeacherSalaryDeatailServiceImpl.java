


package com.onlineexam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineexam.dao.TeacherSalaryDetailDAO;
import com.onlineexam.model.TeacherPaymentDetail;


@Service
public class TeacherSalaryDeatailServiceImpl implements TeacherSalaryDetailService {

	@Autowired
	private TeacherSalaryDetailDAO teacherSalaryDetailDAO;

	@Override
	@Transactional
	public void saveTeacherSalaryDetail(TeacherPaymentDetail teacherPaymentDetail) {
		teacherSalaryDetailDAO.saveTeacherSalaryDetail(teacherPaymentDetail);
		
	}

	@Override
	@Transactional
	public List<TeacherPaymentDetail> listTeacherEditSalaryDetails(int adminId, int schoolId, String sequenceTeacherId) {
		return teacherSalaryDetailDAO.listTeacherEditSalaryDetails(adminId, schoolId, sequenceTeacherId);
	}
	
	@Override
	@Transactional
	public List<TeacherPaymentDetail> listTeacherFeeDetails(int adminId, int schoolId  ) {
		return teacherSalaryDetailDAO.listTeacherFeeDetails(adminId,schoolId);
	}
	
	@Override
	@Transactional
	public TeacherPaymentDetail getTeacherByTeacherId(String id) {
		return teacherSalaryDetailDAO.getTeacherByTeacherId(id);
	}

	@Override
	public void removeTeacherSalaryDetail(TeacherPaymentDetail teacherPaymentDetail) {
		// TODO Auto-generated method stub
		
	}
	
}
