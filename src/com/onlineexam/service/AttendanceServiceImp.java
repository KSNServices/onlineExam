package com.onlineexam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineexam.dao.AttendanceDAO;
import com.onlineexam.model.AdmissionFormModel;
import com.onlineexam.model.Attendance;

@Service
public class AttendanceServiceImp implements AttendanceService {
	
	@Autowired
	private AttendanceDAO attendanceDAO;

	@Override
	@Transactional
	public Integer getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void saveAttendance(Attendance attendance) {
		attendanceDAO.saveAttendance(attendance);
		
	}
	@Override
	@Transactional
	public List<Attendance> listRegistration(int adminId, int schoolId) {		
		return attendanceDAO.listAttendance(adminId,schoolId);
	}

	@Override
	@Transactional
	public void removeAttendance(Attendance attendance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public void updateAttendance(Attendance attendance) {
		// TODO Auto-generated method stub
		
	}

}
