package com.revature.repository;

import java.util.List;

import com.revature.model.Account;

public interface UserRepository {

	void insertUser(Account u);
	
	List<Account> getAllUsers();
	
	Account getUserByName(String name);
	
	Account getUserById(int id);
		
	void deleteUser(Account u);
}
