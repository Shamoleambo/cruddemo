package com.tdgcode.cruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tdgcode.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO {

	private EntityManager entityManager;

	@Autowired
	public StudentDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public void save(Student student) {
		this.entityManager.persist(student);
	}

	@Override
	public Student findById(Integer id) {
		return this.entityManager.find(Student.class, id);
	}

	@Override
	public List<Student> findAll() {
		TypedQuery<Student> theQuery = this.entityManager.createQuery("FROM Student", Student.class);

		return theQuery.getResultList();
	}
}
