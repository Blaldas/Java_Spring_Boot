package com.blaldas.student.dal.repos;

import org.springframework.data.repository.CrudRepository;

import com.blaldas.student.dal.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

}
