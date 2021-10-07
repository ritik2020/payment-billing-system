package com.virtusa.batch31.paymentbillingsystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.batch31.paymentbillingsystem.entities.Accountant;
import com.virtusa.batch31.paymentbillingsystem.entities.Branch;
import com.virtusa.batch31.paymentbillingsystem.repository.AccountantRepository;
import com.virtusa.batch31.paymentbillingsystem.repository.BranchRepository;

@Service
public class AccountantService {
	@Autowired
	private AccountantRepository accountantRepository;
	
	@Autowired
	private BranchRepository branchRepository;
	
	public Accountant createAccountant(int branchId, Accountant accountant) {
		Accountant acc = accountantRepository.save(accountant);
		Branch branch = branchRepository.getById(branchId);
		branch.getAccountants().add(acc);
		branchRepository.save(branch);
		return acc; 
	}
	
	public Accountant getAccountant(int id) {
		return accountantRepository.findById(id).orElse(null); 	
	}
	
	public List<Accountant> getAllAccountants(){
		return accountantRepository.findAll();
	}
	
	public Accountant updateAccountant(Accountant accountant) {
		Accountant acc = accountantRepository.getById(accountant.getId());
		acc.setName(accountant.getName());
		acc.setSalary(accountant.getSalary());
		acc.setUsername(accountant.getUsername());
		acc.setPassword(accountant.getPassword());
		return accountantRepository.save(acc);		
	}
	
	public void deleteAccountant(int id) {
		accountantRepository.deleteById(id);
	}
}
