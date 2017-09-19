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

import com.onlineexam.model.Student;
import com.onlineexam.model.Teacher;

@Repository
public class TeacherDAOImpl implements TeacherDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveTeacher(Teacher teacher) {
		try{
			sessionFactory.getCurrentSession().merge(teacher);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		Integer Id = (Integer) sessionFactory.getCurrentSession()
				.createQuery("from  teacher ORDER BY teacher_id DESC").setMaxResults(1).uniqueResult();

		return Id;

	}
	@Override
	public void removeTeacher(Integer Id) {
		Teacher id = (Teacher) sessionFactory.getCurrentSession().load(Teacher.class,
				Id);
		if (null != id) {
			sessionFactory.getCurrentSession().delete(id);
		}

	}
	
	@Override
	public List<Teacher> listTeacher(int adminId, int schoolId) {
		
		
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Teacher.class);
		cr.add(Restrictions.eq("schoolId.id",schoolId));
		cr.add(Restrictions.eq("adminId.id",adminId));
		List<Teacher> teacherList = cr.list();
		return teacherList;
		
	}

	
	@Override
	public List<Teacher> listTeacherAdmin(int adminId) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Teacher.class);
		cr.add(Restrictions.eq("adminId.id",adminId));
		List<Teacher> teacherList = cr.list();
		return teacherList;
		
	}
	
	@Override
	public void updateTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Teacher getTeacherById(Integer lastTeacherId) {
		// TODO Auto-generated method stub
		return (Teacher)sessionFactory.getCurrentSession().get(Teacher.class,lastTeacherId);
	}

	@Override
	public String getLastTeacherId(int adminId, int schoolId) {
		// TODO Auto-generated method stub
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Teacher.class);
		ProjectionList pro = Projections.projectionList();
		pro.add(Projections.max("id"));
		cr.add(Restrictions.eq("schoolId.id",schoolId));
		cr.add(Restrictions.eq("adminId.id",adminId));
		cr.setProjection(pro);
		Integer number = (Integer)cr.uniqueResult();
		if(number != null){
			Teacher teacher = (Teacher)sessionFactory.getCurrentSession().get(Teacher.class, number);
		
		
		return teacher.getTeacherId();
		}
		return null;
	}

	
	@Override
	public Teacher getTeacherByTeacherId(String id) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Teacher.class);
		cr.add(Restrictions.eq("teacherId",id));
		List<Teacher> lt = cr.list();
		Teacher teacher = null;
		if(lt.size()>0){
			teacher = (Teacher)cr.list().get(0);	
		}		
		return teacher;
	}
	
	
	
}


