package com.onlineexam.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onlineexam.model.FeeStructure;
import com.onlineexam.model.Student;
import com.onlineexam.model.User;

@Repository

public class StudentDAOImpl implements StudentDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveStudent(Student student) {
		sessionFactory.getCurrentSession().merge(student);

	}

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		Integer Id = (Integer) sessionFactory.getCurrentSession().createQuery("from  student ORDER BY Student_id DESC")
				.setMaxResults(1).uniqueResult();

		return Id;

	}

	@Override
	public void updateStudent(Student student) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeStudent(Integer Id) {
		Student id = (Student) sessionFactory.getCurrentSession().load(Student.class, Id);
		if (null != id) {
			sessionFactory.getCurrentSession().delete(id);
		}
	}

	@Override
	public List<Student> listStudent(int adminId, int schoolId) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Student.class);
		cr.add(Restrictions.eq("schoolId.id",schoolId));
		cr.add(Restrictions.eq("adminId.id",adminId));
		List<Student> studentList = cr.list();
		return studentList;
	}
	
	@Override
	public List<Student> listStudentAdmin(int adminId) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Student.class);
		cr.add(Restrictions.eq("adminId.id",adminId));
		List<Student> studentList = cr.list();
		return studentList;
	}

	@Override
	public Student getStudentById(Integer id) {

		Student idDetail = (Student) sessionFactory.getCurrentSession().get(Student.class, id);

		return idDetail;

	}
	
	@Override
	public String getLaststudentId(int adminId, int schoolId) {
		// TODO Auto-generated method stub
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Student.class);
		ProjectionList pro = Projections.projectionList();
		pro.add(Projections.max("id"));
		cr.add(Restrictions.eq("schoolId.id",schoolId));
		cr.add(Restrictions.eq("adminId.id",adminId));
		cr.setProjection(pro);
		Integer number = (Integer)cr.uniqueResult();
		if(number != null){
	Student st = (Student)sessionFactory.getCurrentSession().get(Student.class, number);
		
		
		return st.getStudentId();
		}
		return null;
	}

	@Override
	public Student getStudentByStudentId(String id) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Student.class);
		cr.add(Restrictions.eq("studentId",id));
		List<Student> lt = cr.list();
		Student student = null;
		if(lt.size()>0){
			student = (Student)cr.list().get(0);	
		}		
		return student;
	}
	

	@Override
	public List<Student> listClassStudent(int adminId, int schoolId, String classValue ,String section) {
		

		
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Student.class);
		cr.add(Restrictions.eq("schoolId.id",schoolId));
		cr.add(Restrictions.eq("adminId.id",adminId));
		cr.add(Restrictions.eq("className",classValue));
		cr.add(Restrictions.eq("classSection",section));
		List<Student> student = cr.list();
		return student;
	}

}
