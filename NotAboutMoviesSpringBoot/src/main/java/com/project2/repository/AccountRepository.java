package com.project2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project2.model.Account;

//Annotation for repository
@Repository("accountRepository")
public interface AccountRepository extends JpaRepository<Account, Integer>{

	List<Account> findAll();

}
