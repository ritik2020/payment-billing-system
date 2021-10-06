package com.virtusa.batch31.paymentbillingsystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.batch31.paymentbillingsystem.entities.Branch;
import com.virtusa.batch31.paymentbillingsystem.entities.Course;
import com.virtusa.batch31.paymentbillingsystem.entities.Student;
import com.virtusa.batch31.paymentbillingsystem.repository.BranchRepository;
import com.virtusa.batch31.paymentbillingsystem.repository.CourseRepository;
import com.virtusa.batch31.paymentbillingsystem.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private BranchRepository branchRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	public Student createStudent(int branchId, int courseId, Student student) {
		Branch branch = branchRepository.getById(branchId);
		Course course = courseRepository.getById(courseId);
		
		List<Student> branchStudents = branch.getStudents();
		List<Student> courseStudents = course.getStudents();
		
		branchStudents.add(student);
		courseStudents.add(student);
		
		branchRepository.save(branch);
		courseRepository.save(course);
		return studentRepository.save(student);
	}
	
	public Student getStudent(int rollNumber) {
		return studentRepository.getById(rollNumber);
	}
	
	public List<Student> getAllStudents(){
		return studentRepository.findAll();
	}
	
	public Student updateStudent(Student student) {
		Student st = studentRepository.getById(student.getRollNumber());
		st.setEmail(student.getEmail());
		st.setName(student.getName());
		st.setPhone(student.getPhone());
		return studentRepository.save(st);
	}
	
	public void deleteStudent(int rollNumber) {
		studentRepository.deleteById(rollNumber);
	}
}
