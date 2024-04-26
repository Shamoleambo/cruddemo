package com.tdgcode.cruddemo.dao;

import java.util.List;

import com.tdgcode.cruddemo.entity.Student;

public interface StudentDAO {

	void save(Student theStudent);

	Student findById(Integer id);

	List<Student> findAll();

	List<Student> findByLastName(String lastName);

	void update(Student student);
}
