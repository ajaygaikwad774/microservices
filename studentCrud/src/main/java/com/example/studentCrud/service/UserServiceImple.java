package com.example.studentCrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.studentCrud.dao.UserRepository;
import com.example.studentCrud.model.User;

@Service
@Transactional
public class UserServiceImple  implements UserService {

	
	@Autowired
	UserRepository userRepository;
	
	
	public User createUser(User user) {
		
	   return userRepository.save(user);	
	}

	@Override
	public List<User> getUser() {
		
		return userRepository.findAll();
	}

	@Override
	public User findById(long id) {
		
		return userRepository.findOne(id);
	}

	@Override
	public User update(User user,long id) {
		User usr=userRepository.findOne(id);
		usr.setFirstName(user.getFirstName());
		usr.setLastName(user.getLastName());
		usr.setEmail(user.getEmail());
		return userRepository.save(usr);
	}

	@Override
	public void deleteUserById(long id) {
		userRepository.delete(id);
	}

	@Override
	public void deleteUserAll() {	
		userRepository.deleteAll();		
	}

	

}
