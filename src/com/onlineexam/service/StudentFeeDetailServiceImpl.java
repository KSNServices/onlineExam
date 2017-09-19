
package com.onlineexam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineexam.dao.StudentFeeDetailDAO;
import com.onlineexam.model.StudentFeeDetail;


@Service
public class StudentFeeDetailServiceImpl implements StudentFeeDetailService {

	@Autowired
	private StudentFeeDetailDAO studentFeeDetailDAO;

	@Override
	@Transactional
	public void saveStudentFeeDetail(StudentFeeDetail studentFeeDetail) {
		studentFeeDetailDAO.saveStudentFeeDetail(studentFeeDetail);
		
	}

	@Override
	@Transactional
	public List<StudentFeeDetail> listStudentEditFeeDetails(int adminId, int schoolId, String sequenceStudentId) {
		return studentFeeDetailDAO.listStudentEditFeeDetails(adminId, schoolId, sequenceStudentId);
	}
	
	@Override
	@Transactional
	public List<StudentFeeDetail> listStudentFeeDetail(int adminId, int schoolId  ) {
		return studentFeeDetailDAO.listStudentFeeDetails(adminId,schoolId);
	}
	
	@Override
	@Transactional
	public StudentFeeDetail getStudentByStudentId(String id) {
		return studentFeeDetailDAO.getStudentByStudentId(id);
	}
	
	
	
	
	@Override
	@Transactional
	public Double getSumTotalFeeSchool(int adminId, int schoolId  ) {
		return studentFeeDetailDAO.getSumTotalFeeSchool(adminId,schoolId);
	}

	@Override
	@Transactional
	public Double getRemainingTotalFeeSchool(int adminId, int schoolId  ) {
		return studentFeeDetailDAO.getRemainingTotalFeeSchool(adminId,schoolId);
	}

	@Override
	@Transactional
	public Double getSumTotalAdminFee(int adminId ) {
		return studentFeeDetailDAO.getSumTotalAdminFee(adminId);
	}

	@Override
	@Transactional
	public Double getRemainingTotalAdminFee(int adminId ) {
		return studentFeeDetailDAO.getRemainingTotalAdminFee(adminId);
	}

	@Override
	public void removeStudentFeeDetail(StudentFeeDetail StudentFeeDetailId) {
		// TODO Auto-generated method stub
		
	}
	
}
