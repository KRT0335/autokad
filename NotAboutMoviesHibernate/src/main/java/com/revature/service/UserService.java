package com.revature.service;

import java.util.List;

import com.revature.model.Account;
import com.revature.repository.UserRepository;
import com.revature.repository.UserRepositoryImpl;

public class UserService {

	UserRepository ur = new UserRepositoryImpl();

	public void insertUser(Account u) {
		ur.insertUser(u);
	}

	public List<Account> getAllUsers() {
		return ur.getAllUsers();
	}

	public Account getUserByName(String name) {
		return ur.getUserByName(name);
	}

	public Account getUserById(int id) {
		return ur.getUserById(id);
	}

	public void deleteUser(Account u) {
		ur.deleteUser(u);
	}
	
	
}
