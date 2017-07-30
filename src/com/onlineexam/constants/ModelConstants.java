package com.onlineexam.constants;

import java.util.ArrayList;
import java.util.List;

import com.onlineexam.model.Role;
import com.onlineexam.model.transients.Status;

public class ModelConstants {

	public static final String SUPER_ADMIN = "ROLE_SUPER_ADMIN";
	public static final String ADMIN = "ROLE_ADMIN";
	public static final String SCHOOL_ADMIN = "ROLE_SCHOOL_ADMIN";
	public static final String TEACHER = "ROLE_TEACHER";
	public static final String PARENT = "ROLE_PARENT";
	public static final String STUDENT = "ROLE_STUDENT";
	
	public static final String APPLICANT = "ROLE_APPLICANT";
	
	public static final List<Role> roleList=new ArrayList<Role>(){
		private static final long serialVersionUID = 1L;
		{
			Role admin=new Role();
			admin.setId(1);
			admin.setName(ADMIN);
			
			Role schoolAdmin=new Role();
			schoolAdmin.setId(2);
			schoolAdmin.setName(SCHOOL_ADMIN);
			
			Role teacher=new Role();
			teacher.setId(3);
			teacher.setName(TEACHER);
			
			Role parent=new Role();
			parent.setId(3);
			parent.setName(PARENT);
			
			Role student=new Role();
			student.setId(3);
			student.setName(STUDENT);
			
			add(admin);
			add(schoolAdmin);
			add(teacher);
			add(parent);
			add(student);
		}
	};
	
	public static final List<Role> roleListSuperAdmin=new ArrayList<Role>(){
		private static final long serialVersionUID = 1L;
		{
			Role admin=new Role();
			admin.setId(1);
			admin.setName(ADMIN);
			
			add(admin);
		}
	};
	
	public static final List<Role> roleListAdmin=new ArrayList<Role>(){
		private static final long serialVersionUID = 1L;
		{
			Role candidate=new Role();
			candidate.setId(1);
			candidate.setName(APPLICANT);
			
			add(candidate);
		}
	};
	
	public static final String PAYMENT_PLAN_MODULAR = "MODULAR";
	public static final String PAYMENT_PLAN_USERS = "USERS";
	
	public static final List<Status> paymentPlanList=new ArrayList<Status>(){
		private static final long serialVersionUID = 1L;
		{
			Status status=new Status();
			status.setId(1);
			status.setName(PAYMENT_PLAN_MODULAR);
			
			Status status1=new Status();
			status1.setId(2);
			status1.setName(PAYMENT_PLAN_USERS);
			
			add(status);
			add(status1);
		}
	};
	
	
	
	
}
