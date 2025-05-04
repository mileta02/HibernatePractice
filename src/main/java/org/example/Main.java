package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;
import java.util.Queue;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        Student s1 = new Student(1,"Milan",22);
//        Student s2 = new Student(2,"Andrej",22);

        Laptop l1 = new Laptop("Lenovo","Ideapad 5");
        l1.setId(1);

        Laptop l2 = new Laptop("Asus","Rogue");
        l2.setId(2);

        Laptop l3 = new Laptop("Toshiba", "XYZ");
        l3.setId(3);


        Configuration cfg = new Configuration();
        SessionFactory sf = cfg.configure().addAnnotatedClass(Student.class)
                .addAnnotatedClass(Laptop.class)
                .buildSessionFactory();
        Session session = sf.openSession();
        Transaction t = session.beginTransaction();

        session.persist(l1);
        session.persist(l2);
        session.persist(l3);

        Query query = session.createQuery("from Laptop");
        List<Laptop> laptops = query.getResultList();
        System.out.println(laptops);

        Query query1 = session.createQuery("from Laptop where brand like ?1");
        query1.setParameter(1,"Lenovo");
        List<Laptop> laptops1 = query1.getResultList();
        System.out.println(laptops1);

        t.commit();
        session.close();




    }
}