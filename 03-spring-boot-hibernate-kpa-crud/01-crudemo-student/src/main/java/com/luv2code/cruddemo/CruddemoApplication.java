package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLOutput;
import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){

		return runner-> {
			//createStudent(studentDAO);

			//createMultipleStudents(studentDAO);

			// readStudent(studentDAO);

			//queryForStudents(studentDAO);
			
			//queryForStudentsByLastName(studentDAO);

			updateStudent(studentDAO);

		};

	}

	private void updateStudent(StudentDAO studentDAO) {

		// retrieve students based on the id: primary key
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		// change first name to "Scooby"
		System.out.println("U[dating student ...");
		myStudent.setFirstName("Scooby");
		studentDAO.update

		// update the student

		// display te updated student
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Doe");

		// display list of students
		for (Student tempStudent: theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {


		// get a list of students
		List<Student> theStudents = studentDAO.findall();

		// display list of students
		for (Student tempStudent: theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		// create a student object
		System.out.println("Creating new student object ....");
		Student tempStudent = new Student("Daffy","Duck","daffy@luv2code.com");

		// save the student
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		// display id of the save student
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: " + theId);

		// retrieve student based on the id: primary key
		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		// display student
		System.out.println("Found the student: " + myStudent);

	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		// create multiple students
		System.out.println("Create 3 student object....");
		Student tempStudent1 = new Student("John", "Doe", "Doe@luv2code.com");
		Student tempStudent2 = new Student("Mary", "Public", "mary@luv2code.com");
		Student tempStudent3 = new Student("Bonita", "Applebum", "bonita@luv2code.com");

		// save the student objects
		System.out.println("Saving the students ...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);


	}

	private void createStudent(StudentDAO studentDAO) {
		// create tje student object
		System.out.println("Create new student object....");
		Student tempStudent = new Student("Paul","Doe", "paul@luv2code.com");
		// save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);
		// display id of the saved student
		System.out.println("Save student. Generated id: " + tempStudent.getId());

	}


}
