package com.wipro.java.hibernate.utilities;



import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryProvider {
    private static SessionFactory sessionFactory;

    public static SessionFactory provideSessionFactory() {
        if (sessionFactory == null) {
            try {
                sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
            } catch (Exception e) {
                System.out.println("SessionFactory creation failed: " + e);
            }
        }
        return sessionFactory;
    }
}