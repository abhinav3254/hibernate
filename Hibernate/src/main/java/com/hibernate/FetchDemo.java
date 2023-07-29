package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
//	In this class we are going to fetch the data from the database
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		// Get method
		
		// getting using the id = 104
		int id = 104;
		Student studentGet = (Student) session.get(Student.class, id);
		System.out.println(studentGet.toString());
		
		// load method
		Student studentLoad = (Student) session.get(Student.class, 102);
		System.out.println(studentLoad.toString());
		
		
		session.close();
		sessionFactory.close();
	}
}
