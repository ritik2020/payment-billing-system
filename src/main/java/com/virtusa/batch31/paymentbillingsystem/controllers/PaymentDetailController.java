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

import com.virtusa.batch31.paymentbillingsystem.entities.PaymentDetail;
import com.virtusa.batch31.paymentbillingsystem.services.PaymentDetailService;

@RestController
@RequestMapping("/paymentdetails")

public class PaymentDetailController {
	
@Autowired
private PaymentDetailService paymentDetailService;

@PostMapping("/")
public PaymentDetail createPaymentDetail(int rollNumber, PaymentDetail paymentDetail) {
	return paymentDetailService.createPaymentDetail(rollNumber, paymentDetail);
}

@GetMapping("/")
public PaymentDetail getPaymentDetail(@PathVariable int id) {
	return paymentDetailService.getPaymentDetail(id);
}

@GetMapping("/")
public List<PaymentDetail> getAllPaymentDetails(){
	return paymentDetailService.getAllPaymentDetails();
	}

@PutMapping("/")
public PaymentDetail updatePaymentDetail(@RequestBody PaymentDetail paymentDetail) {
	return paymentDetailService.updatePaymentDetail(paymentDetail);
}

@DeleteMapping("/")
public String deleteBranch(@PathVariable("id") int id) {
	paymentDetailService.deletePaymentDetail(id);
	return "Deleted Successfully";
}
}
