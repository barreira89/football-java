package com.stevebarreira.football.service;
import java.util.List;

import org.springframework.util.MultiValueMap;

import com.stevebarreira.football.model.Accounts;
import com.stevebarreira.football.model.Games;

public interface AccountsService {
	
	List<Accounts> findAllAccounts();
	
	List<Accounts> findAllAccountsByParams (MultiValueMap<String, String> queryParameters);

	Accounts saveAccount(Accounts accounts);
	
	Accounts findAccountById(String id);
}
