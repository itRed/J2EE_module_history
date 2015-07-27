package com.red.action;

import com.opensymphony.xwork2.ActionSupport;
import com.red.dao.IUserDAO;
import com.red.dao.impl.UserDAO;
import com.red.vo.User;

/**
 * 用户登录action
 * @author Red
 *
 */
public class LoginAction extends ActionSupport{
	private String username;
	private String password;
	//处理用户请求的execute方法
	public String execute() throws Exception{
		boolean validated=false;//验证成功标识
		IUserDAO userDAO=new UserDAO();
		User user=userDAO.validateUser(getUsername(),getPassword());
		
		if(user!=null)
		{
          validated=true;		
		}
		if(validated)
		{
		   //验证成功返回字符串“success”
			return SUCCESS;
		}
		else
		{
			//验证失败返回字符串“error”
			return ERROR;
		}
	}
	public String getUsername(){
		return username;
	}
	public void setUsername(String username){
		this.username=username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
