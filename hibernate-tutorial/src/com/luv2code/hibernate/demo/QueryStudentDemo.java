package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// start a transaction
			session.beginTransaction();

			// query students
			List<Student> students = session.createQuery("from Student").getResultList();

			// display all students
			displayStudents(students);

			// query students: lastName='Don'
			students = session.createQuery("from Student s where s.lastName='Don'").getResultList();

			// display all students
			System.out.println("\n\nStudents who have last name Don");
			displayStudents(students);
			
			// query students: lastName='Don' or firstName='Daffu'
			students = session.createQuery("from Student s where" 
											+ " s.lastName='Don' OR s.firstName='Daffu'").getResultList();
			
			// display all students
			System.out.println("\n\nStudents who have last name Don or first name Daffu");
			displayStudents(students);
			
			// query students: email ends with luv2code.com
			students = session.createQuery("from Student s where s.email like '%luv2code.com'").getResultList();
			
			// display all students
			System.out.println("\n\nStudents whose email ends with luv2code.com");
			displayStudents(students);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> students) {
		for (Student stu : students) {
			System.out.println(stu);
		}
	}

}
