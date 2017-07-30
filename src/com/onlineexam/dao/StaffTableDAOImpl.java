package com.onlineexam.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onlineexam.model.StaffTable;

@Repository

public class StaffTableDAOImpl implements StaffTableDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveStaffTable(StaffTable staff_table) {
		sessionFactory.getCurrentSession().merge(staff_table);

	}

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		Integer Id = (Integer) sessionFactory.getCurrentSession()
				.createQuery("from  staff_table ORDER BY Registration_no DESC").setMaxResults(1).uniqueResult();

		return Id;

	}

	@Override
	public List<StaffTable> staffTable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeStaffTable(Integer staffId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateStaffTable(Integer staffId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void getStaffTableById(Integer staffId) {
		// TODO Auto-generated method stub

	}

}
