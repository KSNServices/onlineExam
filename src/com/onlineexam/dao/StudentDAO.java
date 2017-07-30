package com.onlineexam.dao;

import java.util.List;

import com.onlineexam.model.Student;

public interface StudentDAO {

	public Integer getId();

	public void saveStudent(Student student);

	public void removeStudent(Integer studentId);

	public void updateStudent(Student student);

	public List<Student> listStudent(int adminId, int schoolId);

	public Student getStudentById(Integer lastStudentId);

    public String getLaststudentId(int adminId, int schoolId);

	public Student getStudentByStudentId(String id);

   public 	List<Student> listClassStudent(int adminId, int schoolId, String classValue, String section);

	

}
