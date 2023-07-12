package com.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class MapDemo {
    public static void main(String[] args){
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

//        //Creating question object
//        Question q1 = new Question();
//        q1.setQuestionId(12);
//        q1.setQuestion("What is java?");
//
//        //Creating Answer
//        Answer ans1 = new Answer();
//        ans1.setAnswerId(123);
//        ans1.setAnswer("Java is independent programming language");
//        ans1.setQuestion(q1);

//        Answer ans2 = new Answer();
//        ans2.setAnswerId(456);
//        ans2.setAnswer("Java is OOP");
//        ans2.setQuestion(q1);
//
//        Answer ans3 = new Answer();
//        ans2.setAnswerId(789);
//        ans2.setAnswer("Java is platform-independent");
//        ans2.setQuestion(q1);
//
//        List<Answer> list = new ArrayList<Answer>();
//        list.add(ans1);
//        list.add(ans2);
//        list.add(ans3);
//
//        q1.setAnswers(list);

//        //Creating question object
//        Question q2 = new Question();
//        q2.setQuestionId(34);
//        q2.setQuestion("What is OOP?");

//        //Creating Answer
//        Answer ans2 = new Answer();
//        ans2.setAnswerId(456);
//        ans2.setAnswer("OOP is Object Oriented Programming");
//        ans2.setQuestion(q2);
//        q2.setAnswer(ans2);

        //to save we need session

        Session s = factory.openSession();
        Transaction tx = s.beginTransaction();

        Question q = (Question) s.get(Question.class, 12);
        System.out.println(q.getQuestionId());
        System.out.println(q.getQuestion());
        //Lazy fetching
        System.out.println(q.getAnswers().size());

//        for(Answer a: q.getAnswers()){
//            System.out.println(a.getQuestion());
//        }


//        //save
//        s.save(q1);
//        s.save(ans1);
//        s.save(ans2);
//        s.save(ans3);


//        s.save(q2);
//        s.save(ans1);
//        s.save(ans2);
        tx.commit();

        //fetching
//        Question newQ = s.get(Question.class, 12);
//        System.out.println(newQ.getQuestion());
//        System.out.println(newQ.getAnswer().getAnswer());

        s.close();
        factory.close();
    }
}
