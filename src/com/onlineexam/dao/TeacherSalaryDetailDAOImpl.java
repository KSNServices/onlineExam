

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
import com.onlineexam.model.TeacherPaymentDetail;

@Repository

public class TeacherSalaryDetailDAOImpl implements TeacherSalaryDetailDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveTeacherSalaryDetail(TeacherPaymentDetail teacherPaymentDetail) {
		sessionFactory.getCurrentSession().merge(teacherPaymentDetail);

	}

	@Override
	public void removeTeacherSalaryDetail(TeacherPaymentDetail teacherPaymentDetail) {
		TeacherPaymentDetail id = (TeacherPaymentDetail) sessionFactory.getCurrentSession().load(TeacherPaymentDetail.class,
				teacherPaymentDetail);
		if (null != id) {
			sessionFactory.getCurrentSession().delete(id);
		}

	}
	
	
	
	@Override
	public TeacherPaymentDetail getTeacherByTeacherId(String id) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(TeacherPaymentDetail.class);
		cr.add(Restrictions.eq("sequenceTeacherId",id));
		List<TeacherPaymentDetail> lt = cr.list();
		TeacherPaymentDetail teacherPaymentDetail = null;
		if(lt.size()>0){
			teacherPaymentDetail = (TeacherPaymentDetail)cr.list().get(0);	
		}		
		return teacherPaymentDetail;
	}
	
	


	@Override
	public List<TeacherPaymentDetail> listTeacherFeeDetails(int adminId, int schoolId) {
		
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(TeacherPaymentDetail.class);
		cr.add(Restrictions.eq("schoolId.id",schoolId));
		cr.add(Restrictions.eq("adminId.id",adminId));
	
		List<TeacherPaymentDetail> teacherPaymentDetail = cr.list();
		return teacherPaymentDetail;
	}
	
	@Override
	public List<TeacherPaymentDetail> listTeacherEditSalaryDetails(int adminId, int schoolId , String sequenceStudentId) {
		
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(TeacherPaymentDetail.class);
		cr.add(Restrictions.eq("schoolId.id",schoolId));
		cr.add(Restrictions.eq("adminId.id",adminId));
		cr.add(Restrictions.eq("sequenceTeacherId",sequenceStudentId));
		List<TeacherPaymentDetail> teacherPaymentDetail = cr.list();
		return teacherPaymentDetail;
	}

}
