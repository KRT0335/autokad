package com.project2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project2.repository.AccountRepository;
import com.project2.model.Account;

@Service(value = "accountService")
public class AccountService {

	@Autowired
	AccountRepository userRepository;

	public List<Account> findAllAccounts() {
		return userRepository.findAll();
	}
}
