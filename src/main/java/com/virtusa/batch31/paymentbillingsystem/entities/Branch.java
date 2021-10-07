package com.virtusa.batch31.paymentbillingsystem.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Branch {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	
	private String name;
	private String address;
	
	@OneToMany(mappedBy="branch")
	List<Student> students = new ArrayList<>();
	
	@OneToMany(mappedBy="branch")
	List<Accountant> accountants = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<Accountant> getAccountants() {
		return accountants;
	}

	public void setAccountants(List<Accountant> accountants) {
		this.accountants = accountants;
	}
	
}
