package com.virtusa.batch31.paymentbillingsystem.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/accountant")
public class AccountantController {
	
	@GetMapping("/")
	public String sayHello() {
		return "Hello";
	}

}
