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

import com.onlineexam.model.AdmissionFormModel;
import com.onlineexam.model.Student;

@Repository
public class AdmissionFormDAOImpl implements AdmissionFormDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveRegistration(AdmissionFormModel admissionFormModel) {
		sessionFactory.getCurrentSession().merge(admissionFormModel);

	}
	

	@Override
	public AdmissionFormModel getregistrationById(Integer id) {
	
		AdmissionFormModel idDetail = (AdmissionFormModel)  sessionFactory.getCurrentSession().get(AdmissionFormModel.class,id);
	
		return idDetail;

	}
	
	@Override
	public List<AdmissionFormModel> listRegistration(int adminId, int schoolId) {
	/*	Query query = sessionFactory.getCurrentSession().createQuery("from AdmissionFormModel");
		List<AdmissionFormModel> registrationList = query.list(); 
		return registrationList;
		*/
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(AdmissionFormModel.class);
		//ProjectionList pro = Projections.projectionList();
		//pro.add(Projections.projectionList());
		cr.add(Restrictions.eq("schoolId.id",schoolId));
		cr.add(Restrictions.eq("adminId.id",adminId));
		//cr.setProjection(pro);
		List<AdmissionFormModel> registrationList = cr.list();
		return registrationList;
	}

	@Override
	public void removeRegistration(Integer Id) {
		AdmissionFormModel id = (AdmissionFormModel) sessionFactory.getCurrentSession().load(AdmissionFormModel.class,
				Id);
		if (null != id) {
			sessionFactory.getCurrentSession().delete(id);
		}

	}

	@Override
	public Integer getLastId() {
		// TODO Auto-generated method stub
		Integer Id = (Integer) sessionFactory.getCurrentSession()
				.createQuery("from admission_form ORDER BY Registration_no DESC").setMaxResults(1).uniqueResult();

		return Id;

	}
	
	
	@Override
	public AdmissionFormModel getRegistrationByRegistrationId(String id) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(AdmissionFormModel.class);
		cr.add(Restrictions.eq("registrationNo",id));
		List<AdmissionFormModel> lt = cr.list();
		AdmissionFormModel admissionFormModel = null;
		if(lt.size()>0){
			admissionFormModel = (AdmissionFormModel)cr.list().get(0);	
		}		
		return admissionFormModel;
	}
	
	
	@Override
	public String getLaststudentId(int adminId, int schoolId) {
		// TODO Auto-generated method stub
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(AdmissionFormModel.class);
		ProjectionList pro = Projections.projectionList();
		pro.add(Projections.max("registrationNo"));
		cr.add(Restrictions.eq("schoolId.id",schoolId));
		cr.add(Restrictions.eq("adminId.id",adminId));
		cr.setProjection(pro);
		String number = (String)cr.uniqueResult();
	
		
		
		return number;
	}

}
