package com.virtusa.batch31.paymentbillingsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.batch31.paymentbillingsystem.dtos.LoginRequest;
import com.virtusa.batch31.paymentbillingsystem.entities.Accountant;
import com.virtusa.batch31.paymentbillingsystem.entities.Admin;
import com.virtusa.batch31.paymentbillingsystem.services.AccountantService;
import com.virtusa.batch31.paymentbillingsystem.services.AdminService;
import com.virtusa.batch31.paymentbillingsystem.services.JwtUtilService;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private AccountantService accountantService;
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private JwtUtilService jwtUtilService;
	
	@GetMapping("/")
	public ResponseEntity login(@RequestBody LoginRequest loginRequest) {
		String role = loginRequest.getRole();
		String username = loginRequest.getUsername();
		String password = loginRequest.getPassword();
		
		if(role.equals("admin")) {
			Admin admin = adminService.isExists(username, password);
			System.out.println(admin);
			if(admin!=null) {
				String token = jwtUtilService.generateToken(username, role);
				return ResponseEntity.status(HttpStatus.OK).body(token);
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad Credentials");
			}
		}
		
		else if(role.equals("accountant")) {
			Accountant accountant = accountantService.isExists(username, password);
			System.out.println(accountant);
			if(accountant!=null) {
				String token = jwtUtilService.generateToken(username, role);
				return ResponseEntity.status(HttpStatus.OK).body(token);
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad Credentials");
			}
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid role");
		}
	}
}
