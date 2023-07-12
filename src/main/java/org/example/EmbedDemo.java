package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbedDemo {
    public static void main(String[] args){
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        //Creating Student object
        Student student1 = new Student();
        student1.setId(123);
        student1.setName("Bipana");
        student1.setCity("Koteshwor");

        Certificate certificate = new Certificate();
        certificate.setCourse("Java");
        certificate.setDuration("3 months");
        student1.setCerti(certificate);

        Student student2 = new Student();
        student2.setId(123);
        student2.setName("Monika");
        student2.setCity("Pepsi");

        Certificate certificate1 = new Certificate();
        certificate1.setCourse("DBA");
        certificate1.setDuration("2 months");
        student2.setCerti(certificate);

        Session s = factory.openSession();
        Transaction tx = s.beginTransaction();

        //Objects save
        s.save(student1);
        s.save(student2);
        tx.commit();
        s.close();
        factory.close();

    }
}
