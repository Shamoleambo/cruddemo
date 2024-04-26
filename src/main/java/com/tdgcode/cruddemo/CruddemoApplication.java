package com.tdgcode.cruddemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.tdgcode.cruddemo.dao.StudentDAO;
import com.tdgcode.cruddemo.dao.StudentDAOImpl;
import com.tdgcode.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
//			createStudent(studentDAO);
//			createMultipleStudents(studentDAO);
//			readStudent(studentDAO);
//			queryForStudents(studentDAO);
//			queryForStudentsByLastName(studentDAO);
			updateStudent(studentDAO);

		};
	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		System.out.println("Updating student...");
		myStudent.setFirstName("Scooby");

		studentDAO.update(myStudent);

		System.out.println("Updated student: " + myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		List<Student> pequeninos = studentDAO.findByLastName("Pequenino");

		for (Student student : pequeninos) {
			System.out.println(student);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();

		for (Student student : students) {
			System.out.println(student);
		}

	}

	private void readStudent(StudentDAO studentDAO) {
		Student toBeReadStudent = new Student("Kenny", "Diniz Gomes", "kenny@miau.com");
		studentDAO.save(toBeReadStudent);
		int toBeReadId = toBeReadStudent.getId();

		Student studentFromDB = studentDAO.findById(toBeReadId);
		System.out.println(studentFromDB);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating several students...");
		Student firstStudent = new Student("Truta", "Main", "truta@mail.com");
		Student secondStudent = new Student("Mary", "Maria", "mary@mail.com");
		Student thirdStudent = new Student("Any", "Bany", "any@mail.com");

		System.out.println("Saving several students");
		studentDAO.save(firstStudent);
		studentDAO.save(secondStudent);
		studentDAO.save(thirdStudent);

		System.out.println("Saved several students");
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Mano", "Silve", "mano@mail.com");

		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		System.out.println("Saved student. Generated id: " + tempStudent.getId());

	}
}
