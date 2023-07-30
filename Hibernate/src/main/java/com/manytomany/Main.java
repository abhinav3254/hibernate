package com.manytomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure();
		SessionFactory factory = configuration.buildSessionFactory();
		
		Employee ramesh = new Employee();
		ramesh.seteId(14);
		ramesh.seteName("Ramesh");
		Employee rajesh = new Employee();
		rajesh.seteId(16);
		rajesh.seteName("Rajesh");
		
		Project webiste = new Project();
		webiste.setpId(104);
		webiste.setpName("Portfolio Website");
		
		Project android = new Project();
		android.setpId(106);
		android.setpName("IRCTC Mobile Applicaion");
		
		List<Employee> listEmployees = new ArrayList<Employee>();
		List<Project> listProjects = new ArrayList<Project>();
		
		listEmployees.add(rajesh);
		listEmployees.add(ramesh);
		
		listProjects.add(webiste);
		listProjects.add(android);
		
		rajesh.setProjects(listProjects);
		android.setEmployees(listEmployees);
		
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		session.save(rajesh);
		session.save(ramesh);
		session.save(webiste);
		session.save(android);
		
		transaction.commit();
		
		session.close();
		factory.close();
		
	}
}
