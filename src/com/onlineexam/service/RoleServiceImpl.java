package com.onlineexam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineexam.dao.RoleDAO;
import com.onlineexam.model.Role;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleDAO roleDAO;
	@Transactional
	@Override
	public List<Role> listRoleFor() {
		return roleDAO.listRolesFor();
	}

}
