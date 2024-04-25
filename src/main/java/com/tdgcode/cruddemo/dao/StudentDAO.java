package com.tdgcode.cruddemo.dao;

import com.tdgcode.cruddemo.entity.Student;

public interface StudentDAO {

	void save(Student theStudent);

	Student findById(Integer id);
}
