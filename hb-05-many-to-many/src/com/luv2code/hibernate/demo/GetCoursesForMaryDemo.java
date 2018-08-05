package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class GetCoursesForMaryDemo {

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

            // get the student Mary from db
            Query<Student> query = session.createQuery("from Student s where s.firstName=:firstName");
            query.setParameter("firstName", "Mary");

            Student mary = query.getSingleResult();
            System.out.println("get student: " + mary);
            System.out.println("her courses: " + mary.getCourses());

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
