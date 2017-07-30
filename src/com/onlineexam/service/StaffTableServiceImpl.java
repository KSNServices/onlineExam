
package com.onlineexam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineexam.dao.StaffTableDAO;
import com.onlineexam.dao.TeacherDAO;
import com.onlineexam.model.AdmissionFormModel;
import com.onlineexam.model.StaffTable;
import com.onlineexam.model.Student;
import com.onlineexam.model.Teacher;


@Service
public class StaffTableServiceImpl implements StaffTableService {

	@Autowired
	private StaffTableDAO staffTableDAO;

	@Override
	public void saveStaffTable(StaffTable staffTable) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<StaffTable> listStaffTable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeStaffTable(StaffTable StaffTableId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getLastStaffTableById(Integer Id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public StaffTable getStaffTableById(Integer Id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
		
	


}
