package com.carbox.service;

import com.carbox.dao.impl.UserDAOImpl;
import com.carbox.model.User;

public class UserDAOService {
	

	public static void main(String[] args) {
		
		UserDAOImpl userDao = new UserDAOImpl();
		
/*		User user1 = new User("vural2", "atici", "mail@gmail.com", "pass");
		User user2 = new User("ufuk2", "atici", "mail2@gmail.com", "pass2");
		User user3 = new User("perihan", "atici", "mail3@gmail.com", "pass3");
		User user4 = new User("perihan4", "atici", "mail3@gmail.com", "pass4");
		
		userDao.addUser(user1);
		userDao.addUser(user2);
		userDao.addUser(user3);
		userDao.addUser(user4);*/
		
		
		User readUser = userDao.getUserById(1);
		System.out.println(readUser);

//		User user = (User) list.get(0);
//		System.out.println(user.getName());
		
		
//		User updateUser = new User("test", "test", "mail6@gmail.com", "pass2");
//		userDao.update(updateUser,2);
//		User readUser2 = userDao.getUserById(2);
//		System.out.println(readUser2);
		
//		userDao.delete(3);
	}

}
