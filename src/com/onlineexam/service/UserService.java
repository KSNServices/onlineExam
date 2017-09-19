package com.onlineexam.service;

import java.util.List;

import com.onlineexam.model.User;

public interface UserService {
    public void saveUser(User user);
    public List<User> listUser();
    public List<User> listUser(Integer companyId,String searchString);
    public List<User> listUserByRole(String role);
    public void removeUser(Integer userNo);
    public User getUserById(Integer userNo);
    public User getUserByUsername(String userName);
    public void notifyUserByMail(User user,String tempPass);
    public void resetPassword(User user);
	public String getLastId(String role);
	public String getLastschoolId(String role, int adminId);
	public	List<User> getListschoolId(String role, int adminId);
}
