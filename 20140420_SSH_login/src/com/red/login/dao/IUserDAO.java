package com.red.login.dao;

import com.red.login.vo.User;
/**
 * 定义接口
 * @author Red
 * Email:it_red@sina.com
 */
public interface IUserDAO {

	public User validateUser(String username,String password);
}
