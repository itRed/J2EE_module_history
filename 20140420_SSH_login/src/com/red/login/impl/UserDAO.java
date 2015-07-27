package com.red.login.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.classic.Session;

import com.red.login.dao.BaseDAO;
import com.red.login.dao.IUserDAO;
import com.red.login.vo.User;

/**
 * 具体操作类
 * @author Red
 * Email:it_red@sina.com
 */
public class UserDAO extends BaseDAO implements IUserDAO{

	public User validateUser(String username,String password){//实现接口中的方法
		String sql="from User u where u.username=? and u.password=?";//HQL语句
		Session session=(Session) getSession();
		Query query=session.createQuery(sql);
		query.setParameter(0, username);
		query.setParameter(1, password);
		List users=query.list();
		if(users.size()!=0)
		{
			User user=(User) users.get(0);
			return user;
		}
		session.close();
		return null;
	}
}
