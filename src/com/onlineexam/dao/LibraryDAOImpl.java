package com.onlineexam.dao;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onlineexam.model.ExamMarks;
import com.onlineexam.model.Library;

@Repository

public class LibraryDAOImpl implements LibarayDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveLibrary(Library library) {
		sessionFactory.getCurrentSession().merge(library);

	}
	@Override
	public void removeLibrary(Library library) {
	Library id = (Library) sessionFactory.getCurrentSession().load(Library.class,
			library);
		if (null != id) {
			sessionFactory.getCurrentSession().delete(id);
		}

	}

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		Integer Id = (Integer) sessionFactory.getCurrentSession()
				.createQuery("from  library ORDER BY Registration_no DESC").setMaxResults(1).uniqueResult();

		return Id;

	}

	@Override
	public void updateLibrary(Library library) {
		// TODO Auto-generated method stub
		
	}




}


