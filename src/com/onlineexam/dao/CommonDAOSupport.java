package com.onlineexam.dao;

import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.onlineexam.model.User;

public abstract class CommonDAOSupport {
	
	public User getUser(){
		ServletRequestAttributes request=(ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session=request.getRequest().getSession();
		User user = (User) session.getAttribute("userDetails");
		return user;
	}
}
