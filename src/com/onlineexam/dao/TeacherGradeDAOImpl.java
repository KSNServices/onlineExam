


package com.onlineexam.dao;

import java.util.List;

import org.hibernate.Criteria;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onlineexam.model.ClassName;
import com.onlineexam.model.FeeStructure;
import com.onlineexam.model.TeacherGrade;





@Repository
public class TeacherGradeDAOImpl implements TeacherGradeDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	

	@Override
	public List<TeacherGrade> listTeacherGrade(int adminId ,int schoolId) {
		
		
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(TeacherGrade.class);
		cr.add(Restrictions.eq("schoolId.id",schoolId));
		cr.add(Restrictions.eq("adminId.id",adminId));
		
		List<TeacherGrade> teacherGradeList = cr.list();
		return teacherGradeList;
	}
	
	

	@Override
	public TeacherGrade listTeacherGradePresent(int adminId ,int schoolId , String teacherGrade) {
		
		
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(TeacherGrade.class);
		cr.add(Restrictions.eq("schoolId.id",schoolId));
		cr.add(Restrictions.eq("adminId.id",adminId));
		cr.add(Restrictions.eq("teacherGradeValue",teacherGrade));
		List<TeacherGrade> teacherGradeList = cr.list();
		
		TeacherGrade teacherGradeValue = null;
		if(teacherGradeList.size()>0){
			teacherGradeValue = (TeacherGrade)cr.list().get(0);	
		}		
		return teacherGradeValue;
		
		
		
	}

	
	@Override
	public void removeTeacherGrade(TeacherGrade id) {
	sessionFactory.getCurrentSession().delete(id);

	}

	

	@Override
	public void saveTeacherGrade(TeacherGrade teacherGrade) {
		sessionFactory.getCurrentSession().merge(teacherGrade);
		
	}

	@Override
	public TeacherGrade getTeacherGradeById(Integer teacherGradeId) {
		return (TeacherGrade) sessionFactory.getCurrentSession().get(TeacherGrade.class, teacherGradeId);
	}


	
	

}
