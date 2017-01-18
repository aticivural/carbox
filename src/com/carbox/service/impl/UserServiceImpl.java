package com.carbox.service.impl;

import com.carbox.dao.impl.UserDAOImpl;
import com.carbox.model.User;
import com.carbox.service.UserService;

public class UserServiceImpl implements UserService {

	UserDAOImpl userDao = new UserDAOImpl() ;
	
	@Override
	public void addUser(User user) {
		userDao.addUser(user);
	}

	@Override
	public User getUserById(int id) {
		return userDao.getUserById(id);
	}

	@Override
	public void update(User user, int id) {
		userDao.update(user, id);
	}

	@Override
	public void delete(int id) {
		userDao.delete(id);
	}

}
