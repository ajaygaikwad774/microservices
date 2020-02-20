package com.example.studentCrud.service;

import java.util.List;

import com.example.studentCrud.model.User;

public interface UserService {
  
	public User createUser(User user);
    public List<User> getUser();
    public User findById(long id);
    public User update(User user, long l);
    public void deleteUserById(long id);
    public void deleteUserAll();
    
}
