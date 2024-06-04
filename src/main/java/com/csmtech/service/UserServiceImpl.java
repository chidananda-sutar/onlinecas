package com.csmtech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.csmtech.model.User;
import com.csmtech.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	PasswordEncoder encoder;

	@Override
	public boolean findUserByUsernameAndPassword(String username, String password) {
		
		User user=userRepository.findUserByUsername(username);
		if(user!=null)
		{
			return encoder.matches(password, user.getPassword());
		}
		else {
			return false;
		}
		
	}

	@Override
	public User saveDetailsOfUser(User newuser) {
		String encodedPassword=encoder.encode(newuser.getPassword());
		newuser.setPassword(encodedPassword);
		
		return userRepository.save(newuser);
	}

	
	@Override
	public int findRoleIdByUsername(String username) {
		
		return userRepository.getRoleIdByUsername(username);		
	}

	@Override
	public List<User> getAllUser() {
		
		return userRepository.getAllUserNotDeleted();
	}

	@Override
	public void deleteUserById(Integer userId) {
		
		userRepository.deleteUserById(userId);
	}

	@Override
	public User findUserDetailsById(Integer userId) {
		
		return userRepository.findUserDetailsById(userId);
	}

	@Override
	public User findUserByUsernameAndPasswordForCheck(String username, String password) {
		
		User user=userRepository.findUserByUsername(username);
		System.out.println("Password matches: " + encoder.matches(password, user.getPassword()));
		System.out.println(password + " " + encoder.encode(password));
		if(user!=null && encoder.matches(password, user.getPassword()))
		{
			return user;
		}
		else {
			return null;
		}
	}

	@Override
	public Integer getIdByName(String userName) {
		
		return null;
	}

}
