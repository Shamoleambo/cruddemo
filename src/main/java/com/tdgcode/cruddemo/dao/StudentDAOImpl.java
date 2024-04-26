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

	@Override
	public List<Student> findByLastName(String lastName) {
		TypedQuery<Student> theQuery = this.entityManager.createQuery("FROM Student WHERE lastName=:theData",
				Student.class);
		theQuery.setParameter("theData", lastName);
		return theQuery.getResultList();
	}

	@Override
	@Transactional
	public void update(Student student) {
		this.entityManager.merge(student);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		Student student = this.entityManager.find(Student.class, id);
		this.entityManager.remove(student);
	}

	@Override
	@Transactional
	public int deleteAll() {
		int numRowsAffected = entityManager.createQuery("DELETE FROM Student").executeUpdate();
		return numRowsAffected;
	}
}
