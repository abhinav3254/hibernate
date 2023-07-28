package com.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args) {
        System.out.println("Hibernate started....");
        // This is a type of connection as like in JDBC
//        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        
        Configuration configuration = new Configuration();
        // Incase if hibernate.cf.xml file will not be automatically located then we have to
        // pass the path of hibernate.cf.xml in the arguments of .configure("path of hibernate.cfg.xml");
        configuration.configure();
        SessionFactory factory = configuration.buildSessionFactory();
        
        System.out.println(factory);
        System.out.println("is factory closed or not check :- "+factory.isClosed());
        
    }
}
