package com.red.action;

import com.opensymphony.xwork2.ActionSupport;
import com.red.dao.IUserDAO;
import com.red.dao.impl.UserDAO;
import com.red.vo.User;

/**
 * �û���¼action
 * @author Red
 *
 */
public class LoginAction extends ActionSupport{
	private String username;
	private String password;
	//�����û������execute����
	public String execute() throws Exception{
		boolean validated=false;//��֤�ɹ���ʶ
		IUserDAO userDAO=new UserDAO();
		User user=userDAO.validateUser(getUsername(),getPassword());
		
		if(user!=null)
		{
          validated=true;		
		}
		if(validated)
		{
		   //��֤�ɹ������ַ�����success��
			return SUCCESS;
		}
		else
		{
			//��֤ʧ�ܷ����ַ�����error��
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
