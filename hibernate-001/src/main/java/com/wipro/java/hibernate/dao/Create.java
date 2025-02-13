package com.wipro.java.hibernate.dao;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.wipro.java.hibernate.entities.Employee;
import com.wipro.java.hibernate.utilities.SessionFactoryProvider;

public class Create {
    public static void main(String[] args) {
        try {
            SessionFactory sessionFactory = SessionFactoryProvider.provideSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            // Creating an Employee object
            Employee employee = new Employee("John Doe");
            session.save(employee);

            transaction.commit();
            session.close();
            sessionFactory.close();

            System.out.println("Employee record inserted successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}