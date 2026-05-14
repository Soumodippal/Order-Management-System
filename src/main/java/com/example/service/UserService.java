package com.example.service;

import java.util.List;


import com.example.model.User;

public interface UserService {
	
	public User createUser(User user);
	
	public User getById(String email,String password);
	
	public List<User> getAll();
	
	public void deleteById(Long id);
	
	public User updateById(Long id,User us);
	
}
