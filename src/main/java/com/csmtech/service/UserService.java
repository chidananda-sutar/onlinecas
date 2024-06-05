package com.csmtech.service;

import java.util.List;

import com.csmtech.model.User;

public interface UserService {

	boolean findUserByUsernameAndPassword(String username, String password);

	User saveDetailsOfUser(User newuser);

	int findRoleIdByUsername(String username);

	List<User> getAllUser();

	void deleteUserById(Integer userId);

	User findUserDetailsById(Integer userId);

	User findUserByUsernameAndPasswordForCheck(String username, String password);

	Integer getIdByName(String userName);



}
