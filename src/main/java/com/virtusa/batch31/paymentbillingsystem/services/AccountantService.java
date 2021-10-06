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
		Branch branch = branchRepository.getById(branchId);
		List<Accountant> accountants = branch.getAccountants();
		accountants.add(accountant);
		branch.setAccountants(accountants);
		branchRepository.save(branch);
		return accountantRepository.save(accountant); 
	}
	
	public Accountant getAccountant(int id) {
		return accountantRepository.getById(id); 	
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
