package com.onlineexam.dao;

import java.util.List;

import com.onlineexam.model.SuperUser;

public interface SuperUserDAO {
	public void saveSuperUser(SuperUser superUser);
	public List<SuperUser> listUser();
	public void removeSuperUser(Integer superUserId);
	public SuperUser getSuperUserById(Integer superUserId);
	public SuperUser getSuperUserByUserName(String superUserName);
}
