package com.tdgcode.cruddemo;

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
			createMultipleStudents(studentDAO);

		};
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
