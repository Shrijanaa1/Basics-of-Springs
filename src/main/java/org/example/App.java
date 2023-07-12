package org.example;

import org.example.Address;
import org.example.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

public class App {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello");
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        //Creating Student object
        Student s3 = new Student();
        s3.setId(1);
        s3.setName("Shrijana");
        s3.setCity("Gurjudhara");
        System.out.println(s3);

        //creating object of Address class
        Address ad = new Address();
        ad.setStreet("Patan");
        ad.setCity("Lalitpur");
        ad.setOpen(true);
        ad.setAddedDate(new Date());
        ad.setX(123.45);

        //Reading image
        FileInputStream fis = new FileInputStream("/Users/shrijanakarki/Desktop/springs/src/main/resources/image.png");
        byte[] data = new byte[fis.available()];
        fis.read(data);
        ad.setImage(data);

        //To save s1 object
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(s3);
        session.save(ad);

        tx.commit();
        session.close();

        System.out.println("Done....");
    }
}
