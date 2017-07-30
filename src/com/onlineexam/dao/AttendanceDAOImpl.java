package com.onlineexam.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onlineexam.dao.AdmissionFormDAO;
import com.onlineexam.dao.AttendanceDAO;
import com.onlineexam.dao.BudgetDAO;
import com.onlineexam.model.Attendance;
import com.onlineexam.model.Budget;
import com.onlineexam.model.Teacher;

@Repository
public class AttendanceDAOImpl implements AttendanceDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveAttendance(Attendance attendance) {
		sessionFactory.getCurrentSession().merge(attendance);

	}
	
@Override
	public void removeAttendance(Attendance attendance) {
	Attendance id = (Attendance) sessionFactory.getCurrentSession().load(Attendance.class,
				attendance);
		if (null != id) {
			sessionFactory.getCurrentSession().delete(id);
		}

	}

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		Integer Id = (Integer) sessionFactory.getCurrentSession()
				.createQuery("from attendance ORDER BY Registration_no DESC").setMaxResults(1).uniqueResult();

		return Id;

	}

	@Override
	public void updateAttendance(Attendance attendance) {
		// TODO Auto-generated method stub
		
	}
	
	

	@Override
	public List<Attendance> listAttendance(int adminId, int schoolId) {
		
		
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Attendance.class);
		cr.add(Restrictions.eq("schoolId.id",schoolId));
		cr.add(Restrictions.eq("adminId.id",adminId));
		List<Attendance> attendance = cr.list();
		return attendance;
		
	}
	
	
	

}
