package com.hibernate;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args) throws IOException {
        System.out.println("Hibernate started....");
        // This is a type of connection as like in JDBC
//        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        
        Configuration configuration = new Configuration();
        // Incase if hibernate.cf.xml file will not be automatically located then we have to
        // pass the path of hibernate.cf.xml in the arguments of .configure("path of hibernate.cfg.xml");
        configuration.configure();
        SessionFactory factory = configuration.buildSessionFactory();
        
//        System.out.println(factory);
//        System.out.println("is factory closed or not check :- "+factory.isClosed());
        
        // creating student
        Student student = new Student();
        student.setId(102);
        student.setName("Mohan");
        student.setCity("Delhi");
        
        
        System.out.println(student);
        
        
        
//        Creating Address Object Here
        
        Address addressMohan = new Address();
        addressMohan.setAddedDate(new Date(2022, 02, 10));
        addressMohan.setCity("Delhi");
        
        addressMohan.setOpen(true);
        addressMohan.setStreet("street no 20");
        addressMohan.setX(22.44);
        
        // First Read Image
        FileInputStream fileInputStream = new FileInputStream("src/main/java/pic.jpeg");
        byte[] image = new byte[fileInputStream.available()];
        fileInputStream.read(image);
        addressMohan.setImage(image);
        
        
        // How to save our student into the database
        
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(student);
        // we can use this persist
//        session.persist(student);
        
        session.save(addressMohan);
        System.out.println("Saved Mohan");
        
        transaction.commit();
        
        session.close();
        
        System.out.println("Added..");
        
    }
}
