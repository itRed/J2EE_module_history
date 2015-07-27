package com.red.dao.impl;

import java.util.List;

import javax.persistence.Query;

import com.red.dao.IUserDAO;
import com.red.factory.HibernateSessionFactory;
import com.red.vo.User;

/**
 * 实现接口
 * @author Red
 *
 */
public class UserDAO  implements IUserDAO{
	public User validateUser(String username,String password){
		String sql="from User u where u.username=? and u.password=?";
		org.hibernate.Query query=HibernateSessionFactory.getSession().createQuery(sql);
		query.setParameter(0, username);
		query.setParameter(1, password);
		List users=query.list();
		if(users.size()!=0){
			User user=(User)users.get(0);
			return user;
		}
		HibernateSessionFactory.closeSession();
		return null;
	}
}
