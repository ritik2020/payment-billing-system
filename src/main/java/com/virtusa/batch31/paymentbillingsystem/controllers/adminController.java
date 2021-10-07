package com.virtusa.batch31.paymentbillingsystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.batch31.paymentbillingsystem.entities.Admin;
import com.virtusa.batch31.paymentbillingsystem.services.AdminService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@RestController

public class adminController {
	
	@Autowired
	private AdminService service;
	@PostMapping("/createAdmin")
	public Admin createAdmin(@RequestBody Admin admin) {
		return service.createAdmin(admin);
	}
@GetMapping("/getAdmin")	
	public Admin getAdmin(@PathVariable int id) {
		return service.getAdmin(id);
	}
@GetMapping("/getAllAdmins")	
	public List<Admin> getAllAdmins(@PathVariable int id){
		return service.getAllAdmins(id);
}

@PutMapping("/update")
public Admin UpdateAdmin(@RequestBody Admin admin) {
	return service.updateAdmin(admin);
	
}


	
	
	

}
