package com.project2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.project2.model.Account;
import com.project2.repository.AccountRepository;

@Configuration
@Service(value = "accountService")
public class AccountService {

	@Autowired
	AccountRepository accountRepository;

//	public AccountService(AccountRepository accountRepository) {
//		super();
//		this.accountRepository = accountRepository;
//	}
	
	public void setAccountRepository(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	
	public void insertAccount(Account a) {
		this.accountRepository.save(a);
	}
	
	public List<Account> findAllAccounts() {
		return this.accountRepository.findAll();
	}
	
	public Account findAccountByCredentials(String u, String p) {
		return accountRepository.findAccountByUsernameAndPassword(u, p);
	}
}
