package com.onlineexam.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onlineexam.model.Student;
import com.onlineexam.model.StudentFeeDetail;
import com.onlineexam.model.Teacher;

@Repository

public class StudentFeeDetailDAOImpl implements StudentFeeDetailDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveStudentFeeDetail(StudentFeeDetail studentFeeDetail) {
		sessionFactory.getCurrentSession().merge(studentFeeDetail);

	}

	@Override
	public void removeStudentFeeDetail(StudentFeeDetail studentFeeDetail) {
		StudentFeeDetail id = (StudentFeeDetail) sessionFactory.getCurrentSession().load(StudentFeeDetail.class,
				studentFeeDetail);
		if (null != id) {
			sessionFactory.getCurrentSession().delete(id);
		}

	}
	
	
	
	@Override
	public StudentFeeDetail getStudentByStudentId(String id) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(StudentFeeDetail.class);
		cr.add(Restrictions.eq("sequenceStudentId",id));
		List<StudentFeeDetail> lt = cr.list();
		StudentFeeDetail student = null;
		if(lt.size()>0){
			student = (StudentFeeDetail)cr.list().get(0);	
		}		
		return student;
	}
	
	

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateStudentFeeDetail(StudentFeeDetail studentFeeDetail) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<StudentFeeDetail> listStudentFeeDetails(int adminId, int schoolId) {
		
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(StudentFeeDetail.class);
		cr.add(Restrictions.eq("schoolId.id",schoolId));
		cr.add(Restrictions.eq("adminId.id",adminId));
	
		List<StudentFeeDetail> studentFeeDetail = cr.list();
		return studentFeeDetail;
	}
	
	@Override
	public List<StudentFeeDetail> listStudentEditFeeDetails(int adminId, int schoolId , String sequenceStudentId) {
		
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(StudentFeeDetail.class);
		cr.add(Restrictions.eq("schoolId.id",schoolId));
		cr.add(Restrictions.eq("adminId.id",adminId));
		cr.add(Restrictions.eq("sequenceStudentId",sequenceStudentId));
		List<StudentFeeDetail> studentFeeDetail = cr.list();
		return studentFeeDetail;
	}

}
