
package com.onlineexam.service;

import java.util.List;

import com.onlineexam.model.Student;

public interface StudentFormService {

	public void saveStudentForm(Student student);

	public List<Student> listStudent(int adminId, int schoolId);

	public void removeStudent(Integer studentId);

	public void getLastStudentById(Integer Id);

	public Student getStudentById(Integer Id);
	
	public String getLaststudentId(int adminId, int schoolId);

	public Student getStudentByStudentId(String id);

	public List<Student> listClassStudent(int adminId, int schoolId, String classValue, String section);

	

}
