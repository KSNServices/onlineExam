
package com.onlineexam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineexam.dao.StudentDAO;
import com.onlineexam.model.Student;


@Service
public class StudentFormServiceImpl implements StudentFormService {

	@Autowired
	private StudentDAO studentDAO;
	
	
	@Override
	@Transactional
	public void saveStudentForm(Student student) {
		//student.setStudentId(String.valueOf(System.currentTimeMillis()));
		studentDAO.saveStudent(student);
	}

	@Override
	@Transactional
	public List<Student> listStudent(int adminId, int schoolId) {
		return studentDAO.listStudent( adminId,  schoolId);
		
	}
	

	@Override
	@Transactional
	public List<Student> listStudentAdmin(int adminId) {
		return studentDAO.listStudentAdmin( adminId);
		
	}

	@Override
	@Transactional
	public void removeStudent(Integer studentId) {
		studentDAO.removeStudent(studentId);
		
	}

	@Override
	@Transactional
	public void getLastStudentById(Integer lastStudentId) {
		lastStudentId=  studentDAO.getId();
		
	}

	@Override
	@Transactional
	public Student getStudentById(Integer lastStudentId) {
		return studentDAO.getStudentById(lastStudentId);}

	@Override
	@Transactional
	public String getLaststudentId(int adminId, int schoolId) {
		return studentDAO.getLaststudentId(adminId, schoolId);}

	@Override
	@Transactional
	public Student getStudentByStudentId(String id) {
		return studentDAO.getStudentByStudentId(id);
	}


		
	@Override
	@Transactional
	public List<Student> listClassStudent(int adminId, int schoolId, String classValue, String section) {
		return studentDAO.listClassStudent(adminId, schoolId, classValue, section);
	}


}
