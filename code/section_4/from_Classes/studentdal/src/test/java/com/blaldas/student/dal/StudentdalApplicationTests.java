package com.blaldas.student.dal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.blaldas.student.dal.entities.Student;
import com.blaldas.student.dal.repos.StudentRepository;

@SpringBootTest
class StudentdalApplicationTests {

	@Autowired
	private StudentRepository repo;
	
	@Test
	void testSetNewStudent() {
		Student student = new Student();
		student.setName("Nuno Santos");
		student.setCourse("Computer Science");
		student.setFee(3627);
		
		repo.save(student);
	}

}
