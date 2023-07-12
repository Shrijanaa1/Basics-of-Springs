package com.hql;

import org.example.Student;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HQLExample {
    public static void main(String[] args){
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();
        //HQL query
        //syntax:

        String query = "from Student where city='Lucknow'";
        Query q = session.createQuery(query);

        //single result (Unique)
        //multiple - list
        List<Student> list = q.list();
        for(Student student: list){
            System.out.println(student.getName() + " : " + student.getCerti().getCourse());
        }

        session.close();
        factory.close();
    }
}
