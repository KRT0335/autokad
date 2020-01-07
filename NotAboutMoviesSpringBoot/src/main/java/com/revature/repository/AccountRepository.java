package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Account;

//Annotation for repository
@Repository("accountRepository")
public interface AccountRepository extends JpaRepository<Account, Integer>{

	List<Account> findAll();

}
