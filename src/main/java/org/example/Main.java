package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Student s1 = new Student(1,"Milan",22);
        Student s2 = new Student(2,"Andrej",22);

        Laptop l1 = new Laptop("Lenovo","Ideapad 5");
        l1.setId(1);

        Laptop l2 = new Laptop("Asus","Rogue");
        l2.setId(2);
        s1.setLaptops(Arrays.asList(l1,l2));

        Laptop l3 = new Laptop("Toshiba", "XYZ");
        l3.setId(3);
        s2.setLaptops(Arrays.asList(l3));

        s1.setLaptops(Arrays.asList(l1,l2));
        s2.setLaptops(Arrays.asList(l3));

        Configuration cfg = new Configuration();
        SessionFactory sf = cfg.configure().addAnnotatedClass(Student.class)
                .addAnnotatedClass(Laptop.class)
                .buildSessionFactory();
        Session session = sf.openSession();
        Transaction t = session.beginTransaction();
        //CREATE
        session.persist(s1);
        session.persist(s2);
        session.persist(l1);
        session.persist(l2);
        session.persist(l3);


        t.commit();
        session.close();

        Session session1 = sf.openSession();
        Student student = session1.get(Student.class,1);


    }
}