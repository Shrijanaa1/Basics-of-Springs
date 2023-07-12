package com.states;

import org.example.Certificate;
import org.example.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StateDemo {
    public static void main(String[] args){
        //Hibernate Object States:
        //Transient
        //Persistent
        //Detached
        //Removed

    SessionFactory f = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    Transaction tx = null;
    Session s = f.openSession();
        try {
        //Creating Student Object
        Student student = new Student();
        student.setId(1);
        student.setName("Peter");
        student.setCity("Pokhara");
        student.setCerti(new Certificate("Java Hibernate Course", "3 days"));
        //student: Transient

        tx = s.beginTransaction();
        s.save(student);
        //student: Persistence- associated with both session,database
        student.setName("Ram");

        tx.commit();
    }catch (Exception e){
            //rollback transaction if exception occurs
        if(tx!=null){
            tx.rollback();
            System.out.println("Error occurred during transaction: " + e.getMessage());
        }
    }
finally {


    s.close();
    //student: Detached, now objects will not be change in database
    //cuz it is disconnected from database.
            // student.setName("Ram");
    f.close();
}
    }
}
