package com.onlineexam.dao;

import java.util.List;

import com.onlineexam.model.User;

public interface UserDAO {
	public void saveUser(User User);
	public List<User> listUser();
	public List<User> listUser(Integer companyId,String searchString);
	public void removeUser(Integer userNo);
	public User getUserById(Integer userNo);
	public User getUserByUserName(String userName);
	public List<User> listUserByRole(String role);
	 String getLastId(String role);
	public String getLastschoolId(String role, int adminId);

}
