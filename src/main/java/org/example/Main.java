package org.example;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Student s1 = new Student(1,"Milan",22);
        Student s2 = new Student(2,"Andrej",22);

        Laptop l1 = new Laptop("Lenovo","Ideapad 5");
        l1.setId(1);
        s1.setLaptop(l1);


        Configuration cfg = new Configuration();
        Session session = cfg.configure().addAnnotatedClass(Student.class)
                .addAnnotatedClass(Laptop.class)
                .buildSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        //CREATE
        session.persist(s1);
        session.persist(l1);
        //READ
        Student student = session.get(Student.class,1);
        System.out.println(student);

//        //UPDATE
//        Student s3 = new Student(1,"Milan",23);
//        session.merge(s3);
//
//        //UPDATE(new obj)
//        Student s4 = new Student(4,"Kristina",22);
//        session.merge(s4);
//
//        //DELETE
//        session.remove(s1);
         t.commit();
    }
}