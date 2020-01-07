package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Account;
import com.revature.repository.AccountRepository;

@Service(value = "accountService")
public class AccountService {

	@Autowired
	AccountRepository userRepository;

	public List<Account> findAllAccounts() {
		return userRepository.findAll();
	}
}
