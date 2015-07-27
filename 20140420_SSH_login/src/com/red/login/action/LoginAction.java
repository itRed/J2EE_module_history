package com.red.login.action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;
import com.red.login.dao.IUserDAO;
import com.red.login.vo.User;
import org.springframework.context.support.*;
import org.springframework.context.*;
import com.red.login.impl.*;

/**
 *登录Action 
 * @author Red
 * Email:it_red@sina.com
 */

public class LoginAction extends ActionSupport{

	private User user;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		boolean validated=false;
		//指明applicationContext的位置
		ApplicationContext context=new FileSystemXmlApplicationContext("file:H:/EB/20140420_SSH_login/src/applicationContext.xml");
		
		IUserDAO userDAO=(IUserDAO)context.getBean("userDAO");
		User u=userDAO.validateUser(user.getUsername(), user.getPassword());
		if(u!=null)
		{
			validated=true;	//登录验证		
		}
		if(validated){
			return SUCCESS;
		}else{
			return ERROR;
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
		
	}
	
