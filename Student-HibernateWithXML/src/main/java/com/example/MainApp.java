package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainApp {
    public static void main(String[] args) {
        // Create a SessionFactory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // Create a Session using openSession()
        Session session = sessionFactory.openSession(); // Use openSession() instead of getCurrentSession()

        try {
            // Create a Student object
            Student student = new Student("John Doe");

            // Start a transaction
            session.beginTransaction();

            // Save the Student object
            session.save(student);

            // Commit the transaction
            session.getTransaction().commit();

            System.out.println("Student saved successfully!");
        } finally {
            session.close(); // Close the session
            sessionFactory.close(); // Close the SessionFactory
        }
    }
}