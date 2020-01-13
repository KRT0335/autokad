package com.project2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project2.model.Account;

//Annotation for repository
@Repository(value = "accountRepository")
public interface AccountRepository extends JpaRepository<Account, Integer>{

	public <S extends Account> S save(Account a);
	public List<Account> findAll();
	
	public Account findAccountByUsernameAndPassword(String u, String p);
	public List<Account> findAccountByUsernameOrPassword(String u, String p);
}
