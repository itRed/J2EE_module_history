package com.red.dao;
import com.red.vo.User;

/**
 * �ӿ�
 * @author Red
 *
 */
public interface IUserDAO {

	public User validateUser(String username,String password);
}
