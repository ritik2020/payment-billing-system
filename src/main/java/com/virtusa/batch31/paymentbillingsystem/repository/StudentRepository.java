package com.virtusa.batch31.paymentbillingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtusa.batch31.paymentbillingsystem.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
