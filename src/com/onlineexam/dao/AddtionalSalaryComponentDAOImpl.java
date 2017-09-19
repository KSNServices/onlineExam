package com.onlineexam.dao;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.onlineexam.model.AdditionalSalaryComponent;
import com.onlineexam.model.SalaryStructure;


@Repository

public class AddtionalSalaryComponentDAOImpl implements AddtionalSalaryComponentDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveAdditionalSalary(AdditionalSalaryComponent additionalSalaryComponent) {
		sessionFactory.getCurrentSession().merge(additionalSalaryComponent);

	}
	
	@Override
	public void removeAdditionalSalary(AdditionalSalaryComponent additionalSalaryComponent) {
	
			sessionFactory.getCurrentSession().delete(additionalSalaryComponent);
		

	}
	

	@Override
	public List<AdditionalSalaryComponent> listAdditionalSalaryStructure(int adminId, int schoolId, String teacherId) {
		
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(SalaryStructure.class);
		cr.add(Restrictions.eq("schoolId.id",schoolId));
		cr.add(Restrictions.eq("adminId.id",adminId));
		cr.add(Restrictions.eq("teacherGrade",teacherId));
		List<AdditionalSalaryComponent> additionalSalaryComponent = cr.list();
		return additionalSalaryComponent;
	}

	@Override
	public Double sumAdditionalSalaryStructure(int adminId, int schoolId, String teacherId) {
		
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(AdditionalSalaryComponent.class);
		ProjectionList pro = Projections.projectionList();
		pro.add(Projections.sum("amount"));
		cr.add(Restrictions.eq("schoolId.id",schoolId));
		cr.add(Restrictions.eq("adminId.id",adminId));
		cr.add(Restrictions.eq("teacherId",teacherId));
		cr.setProjection(pro);
		Double number = (Double)cr.uniqueResult();
		
	return number;
		
	}
	
	@Override
	public Double sumAdditionalMonthSalaryStructure(int adminId, int schoolId, String teacherId, String month) {
		
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(AdditionalSalaryComponent.class);
		ProjectionList pro = Projections.projectionList();
		pro.add(Projections.sum("amount"));
		cr.add(Restrictions.eq("schoolId.id",schoolId));
		cr.add(Restrictions.eq("adminId.id",adminId));
		cr.add(Restrictions.eq("teacherIdValue",teacherId));
		cr.add(Restrictions.eq("additionalMonth",month));
		cr.setProjection(pro);
		Double number = (Double)cr.uniqueResult();
		
	return number;
		
	}
	
	
	@Override
	public AdditionalSalaryComponent getAdditionalSalaryById(Integer id) {
	
		AdditionalSalaryComponent idDetail = (AdditionalSalaryComponent)  sessionFactory.getCurrentSession().get(AdditionalSalaryComponent.class,id);
	
		return idDetail;

	}

	





}



