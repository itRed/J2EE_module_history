package com.red.login.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
/**
 * 基类：通过session工厂来打开session
 * @author Red
 * Email:it_red@sina.com
 */
public class BaseDAO {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;//返回session工厂
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public Session getSession(){
		Session session=sessionFactory.openSession();//打开session
		return session;
	}
	
}
