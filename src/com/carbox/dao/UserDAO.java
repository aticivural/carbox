package com.carbox.dao;

import com.carbox.model.User;

public interface UserDAO {
	
	public void addUser(User user);
	public User getUserById(int id);
	public void update(User user, int id);
	public void delete(int id);

}
