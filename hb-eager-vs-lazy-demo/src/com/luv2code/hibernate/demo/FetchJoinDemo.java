package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;

public class FetchJoinDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                                    .configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(Instructor.class)
                                    .addAnnotatedClass(InstructorDetail.class)
                                    .addAnnotatedClass(Course.class)
                                    .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // start transaction
            session.beginTransaction();

            // get the instructor from db
            int id = 1;

            // Option 1: call getter while session is open
            // the data will be stored in memory even thought the session close later
//            System.out.println("Courses: " + instructor.getCourses());

            // Option 2: HQL Join Fetch
            Query<Instructor> query =
                    session.createQuery(
                            "select i from Instructor i "
                            + "JOIN FETCH i.courses "
                            + "where i.id=:theInstructorId",
                            Instructor.class);

            // set parameter on query
            query.setParameter("theInstructorId", id);

            // execute query and get isntructor
            Instructor instructor = query.getSingleResult();

            System.out.println("Instructor: " + instructor);

            // commit
            session.getTransaction().commit();

            // close the session to break it purposely
            session.close();

            // this should fail, because it's lazy loaded...
            // get courses for instructor
            System.out.println("Courses: " + instructor.getCourses());


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
