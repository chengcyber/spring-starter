package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndStudentsDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                                    .configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(Instructor.class)
                                    .addAnnotatedClass(InstructorDetail.class)
                                    .addAnnotatedClass(Course.class)
                                    .addAnnotatedClass(Review.class)
                                    .addAnnotatedClass(Student.class)
                                    .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // start transaction
            session.beginTransaction();

            // create a course
            Course course = new Course("Pacman - How to Scorce One Million Points");


            // save the course ... and leverage the cascade all :-)
            System.out.println("Saving the course");
            System.out.println(course);
            session.save(course);
            System.out.println("Saved the course.");

            // create students
            Student stu1 = new Student("John", "Doe", "john@gmail.com");
            Student stu2 = new Student("Mary", "Public", "mary@gmail.com");

            // add students to course
            course.addStduent(stu1);
            course.addStduent(stu2);

            // save the students
            System.out.println("Saving students...");
            System.out.println(stu1);
            System.out.println(stu2);
            session.save(stu1);
            session.save(stu2);
            System.out.println("Saved students: " + course.getStudents());

            // commit
            session.getTransaction().commit();

            System.out.println("DONE!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            // add clean up code
            session.close();
            factory.close();
        }

    }

}
