package com.stevebarreira.football.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.stevebarreira.football.repository.AccountsRepository;

@Service
public class AccountsAuthService implements UserDetailsService  {

	private AccountsRepository accountsRespository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return accountsRespository.findByUsername(username);
	}
}
