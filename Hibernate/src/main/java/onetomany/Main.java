package onetomany;

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
		
		System.out.println("Correct here");
		Question question = new Question();
		question.setQuestionId(1002);
		question.setQuestion("Who are you?");
		
		
		Answer answer  = new Answer();
		answer.setAnswerId(2010);
		answer.setAnswer("I am a student");
		answer.setQuestion(question);
		
		Answer answer2 = new Answer();
		answer2.setAnswerId(2011);
		answer2.setAnswer("I am a Programmer");
		answer2.setQuestion(question);
		
		List<Answer> ansList = new ArrayList<Answer>();
		ansList.add(answer);
		ansList.add(answer2);
		
		question.setAnswers(ansList);
		
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		
//		session.save(question);
//		session.save(answer);
//		session.save(answer2);
		
		// fetching data
		
		Question q = (Question) session.get(Question.class, 1002);
//		System.out.println(q);
		
		System.out.println("Question is :- "+q.getQuestion());
		
		for (Answer a:q.getAnswers())
			System.out.println("Answer is :- "+a.getAnswer());
		
		transaction.commit();
		
		session.close();
		factory.close();
		
	}
}
