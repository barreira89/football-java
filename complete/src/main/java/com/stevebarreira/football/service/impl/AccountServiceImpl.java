package com.stevebarreira.football.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import com.stevebarreira.football.model.Accounts;
import com.stevebarreira.football.model.Models;
import com.stevebarreira.football.model.Picks;
import com.stevebarreira.football.model.PicksDTO;
import com.stevebarreira.football.repository.AccountsRepository;
import com.stevebarreira.football.repository.PicksRepository;
import com.stevebarreira.football.service.AccountsService;
import com.stevebarreira.football.service.PicksService;
import com.stevebarreira.football.service.QueryBuilderService;

@Service
public class AccountServiceImpl implements AccountsService {

	@Autowired
	AccountsRepository accountsRepository;
	
	@Autowired
	QueryBuilderService queryService;
	
	public Accounts saveAccount (Accounts accounts) {
		return accountsRepository.save(accounts);
	}
	
//	@Override
//	public List<Accounts> findAllPicks() {
//		return (List<Accounts>) accountsRepository.findAll();
//	}
//
//	@Override
//	public List<Accounts> findAllPicksByParams(MultiValueMap<String, String> queryParameters) {
//		return (List<Accounts>) accountsRepository.findAll(queryService.createQuery(queryParameters, Models.PICKS));
//	}
//
//	@Override
//	public Accounts getPicksById(String id) {
//		return accountsRepository.findOne(id);
//	}
//
//	@Override
//	public Accounts addOrUpdatePick(Picks pickToSave, String id) {
//		return accountsRepository.save(pickToSave);
//	}
//
////	public List<PicksDTO> findAllPicksWithGames(String username) {
////		return accountsRepository.findPicksByUsernameWithGameDetails(username);
////	}
//
//	@Override
//	public void updateListOfPicks(List<Picks> inputPicks) {
//		inputPicks.forEach(
//				p -> {
//					accountsRepository.save(p);
//				});
//	}
//
//	@Override
//	public List<Accounts> findAllAccount() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public List<Accounts> findAllAccountsByParams(MultiValueMap<String, String> queryParameters) {
		return (List<Accounts>) accountsRepository.findAll();
	}

	@Override
	public List<Accounts> findAllAccounts() {
		return (List<Accounts>) accountsRepository.findAll();
	}

	@Override
	public Accounts findAccountById(String id) {
		// TODO Auto-generated method stub
		return accountsRepository.findOne(id);
	}

}
