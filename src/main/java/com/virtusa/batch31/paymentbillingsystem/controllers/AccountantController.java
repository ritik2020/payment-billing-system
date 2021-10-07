package com.virtusa.batch31.paymentbillingsystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.batch31.paymentbillingsystem.entities.Accountant;
import com.virtusa.batch31.paymentbillingsystem.services.AccountantService;

@RestController
@RequestMapping("/Accountant")
public class AccountantController {
	@Autowired
	private AccountantService accountantService;
	
	@PostMapping("/")
	public Accountant createAccountant(@RequestBody Accountant accountant) {
		return accountantService.createAccountant(id, accountant);
	}
	
	@GetMapping("/")
	public List<Accountant> getAllAccountants(){
		return accountantService.getAllAccountants();
	}
	
	@GetMapping("/{id}")
	public Accountant getAccountantById(@PathVariable("id") int id) {
		return accountantService.getAccountant(id);
	}
	
	@PutMapping("/")
	public Accountant updateAccountant(@RequestBody Accountant accountant) {
		return accountantService.updateAccountant(accountant);
	}
	
	@DeleteMapping("/{id}")
	public String deleteAccountant(@PathVariable("id") int id) {
		accountantService.deleteAccountant(id);
		return "Deleted Successfully";
	}

}
