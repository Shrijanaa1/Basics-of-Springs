package com.map1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

public class MappingDemo {
    public static void main(String[] args){
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        //Creating Objects
        Emp e1 = new Emp();
        Emp e2 = new Emp();
        e1.setEmpId(1);
        e1.setEmpName("Ram");
        e1.setEmpId(2);
        e1.setEmpName("Shyam");

        Project p1 = new Project();
        Project p2 = new Project();
        p1.setpId(11);
        p1.setProjectName("Hospital Management System");
        p2.setpId(22);
        p2.setProjectName("Library Management System");

        List<Emp> list1 = new ArrayList<Emp>();
        List<Project> list2 = new ArrayList<Project>();

        list1.add(e1);
        list1.add(e2);
        list2.add(p1);
        list2.add(p2);

        e1.setProjects(list2);
        p2.setEmps(list1);

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction(); //Physically change garna lai
        session.save(e1);
        session.save(e2);
        session.save(p1);
        session.save(p2);

        tx.commit();
        session.close();
        factory.close();
    }
}
