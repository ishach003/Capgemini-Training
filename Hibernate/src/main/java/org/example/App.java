package org.example;

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        Person pr=new Person();
        pr.setId(1);
        pr.setName("Isha");

        Configuration configuration=new Configuration()
                .configure().addAnnotatedClass(Person.class);

        SessionFactory sessionFactory= configuration.buildSessionFactory();
        Session session= sessionFactory.openSession();
        Transaction transaction= (Transaction) session.beginTransaction();
//      session.persist(pr);

        Person p=session.get(Person.class,1);
        System.out.println(p);
        p.setName("Isha");
        session.merge(p);
//        session.remove(p);

        List<Person> list = session
                .createQuery("from Person", Person.class)
                .getResultList();

        System.out.println("All persons: " + list);
        transaction.commit();
    }
}
