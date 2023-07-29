package com.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainMap {
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		// Question and Answer

		Question q = new Question();
		Answer a = new Answer();
		
		q.setQuestion("What is OOPs");
		q.setQuestionId(13);
		
		a.setAnswer("OOPs is programming paradigm");
		a.setAnswerId(103);
		a.setQuestion(q);
		q.setAnswer(a);

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(q);
		session.save(a);
		transaction.commit();

		session.close();
		sessionFactory.close();

	}
}
