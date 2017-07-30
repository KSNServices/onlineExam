package com.onlineexam.service;

import java.util.List;

import com.onlineexam.model.Attendance;

public interface AttendanceService {

public Integer getId();
	
	public void saveAttendance(Attendance attendance);
	
	
	public void removeAttendance(Attendance attendance);
	
	public void updateAttendance(Attendance attendance);

	public	List<Attendance> listRegistration(int adminId, int schoolId);

	
}
