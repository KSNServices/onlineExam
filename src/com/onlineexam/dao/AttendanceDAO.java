package com.onlineexam.dao;


import java.util.List;

import com.onlineexam.model.Attendance;

public interface AttendanceDAO {
	
	public Integer getId();
	
	public void saveAttendance(Attendance attendance);
	
	
	public void removeAttendance(Attendance attendance);
	
	public void updateAttendance(Attendance attendance);

     public List<Attendance> listAttendance(int adminId, int schoolId);

}
