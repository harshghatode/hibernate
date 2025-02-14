package com.wipro.java.hibernate.result;

import com.wipro.java.hibernate.model.Student;
import com.wipro.java.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Open Hibernate session
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            // Begin Transaction
            transaction = session.beginTransaction();

            // Insert Student Data
            Student student1 = new Student("Harsh", 101);
            Student student2 = new Student("Prasad", 102);
            Student student3 = new Student("Raghav", 103);

            session.save(student1);
            session.save(student2);
            session.save(student3);

            // Commit Transaction
            transaction.commit();
            System.out.println("✅ Student data inserted successfully!\n");

            // Begin a new transaction to fetch data
            transaction = session.beginTransaction();

            // Fetch and display all students from the database
            List<Student> students = session.createQuery("FROM Student", Student.class).list();

            System.out.println(" Student Records:");
            for (Student student : students) {
                System.out.println(" ID: " + student.getId() + ",  Name: " + student.getName() + ",  Roll No: " + student.getRollNumber());
            }

            // Commit Transaction
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}