package com.webencyclop.demo.service;

import java.util.List;

import com.webencyclop.demo.model.User;

public interface UserService {

	public void saveUser(User user);
	
	public boolean isUserAlreadyPresent(User user);

	public Iterable<User> getAllUsers();



	//api de clientes
	public List<User> findAll();

	public User findById(int id);

}
