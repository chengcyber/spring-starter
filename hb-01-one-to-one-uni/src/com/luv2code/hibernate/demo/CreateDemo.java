package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
                                    .addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {

			// create the objects
			Instructor instructor =
					new Instructor("Chad", "Darby", "darby@luv2code.com");

			InstructorDetail instructorDetail =
					new InstructorDetail(
							"http://youtube.com",
							"LUV2CODE"
					);

			// associate the objects
            instructor.setInstructorDetail(instructorDetail);

			// start a transaction
			session.beginTransaction();

			// save the instructor
			// NOTE: this will also save the details object
			// because of CascadeType.ALL
			System.out.println("Saving instructor" + instructor);
			session.save(instructor);

			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}
	}

}
