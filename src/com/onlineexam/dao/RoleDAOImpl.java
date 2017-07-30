package com.onlineexam.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.onlineexam.constants.ModelConstants;
import com.onlineexam.model.Role;
@Repository
public class RoleDAOImpl extends CommonDAOSupport implements RoleDAO{

	@Override
	public List<Role> listRolesFor() {
		if(ModelConstants.SUPER_ADMIN.equalsIgnoreCase(getUser().getAuthority())){
			return ModelConstants.roleListSuperAdmin;
		}else if(ModelConstants.ADMIN.equalsIgnoreCase(getUser().getAuthority())){
			return ModelConstants.roleListAdmin;
		}
		return new ArrayList<Role>();
	}

}
