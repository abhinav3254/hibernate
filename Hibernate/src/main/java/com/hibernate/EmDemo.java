package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		Student student = new Student();
		student.setId(1);
		student.setName("Mohan Kumar");
		student.setCity("Kanpur");
		
		Certificate certificate = new Certificate();
		certificate.setCourse("Android");
		certificate.setDuration("2 Months");
		
		student.setCertificate(certificate);
		
		Student student2 = new Student();
		student2.setId(2);
		student2.setName("Rohan Kumar");
		student2.setCity("Gurugram");
		
		Certificate certificate2 = new Certificate();
		certificate2.setCourse("Java");
		certificate2.setDuration("18 Months");
		
		student2.setCertificate(certificate2);
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		session.save(student);
		session.save(student2);
		
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
}
