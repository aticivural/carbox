package com.carbox.service;

import com.carbox.model.User;

public interface UserService {

	public void addUser(User user);
	public User getUserById(int id);
	public void update(User user, int id);
	public void delete(int id);
}
