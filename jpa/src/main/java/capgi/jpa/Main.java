package capgi.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("jpa-example");
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction=entityManager.getTransaction();

        entityTransaction.begin();

        // Save

//        Person p1=new Person();
//        p1.setId(11);
//        p1.setName("Naina");
//        p1.setSalary(1.2);
//
//        Person p2=new Person();
//        p2.setId(12);
//        p2.setName("Saksam");
//        p2.setSalary(1.3);
//
//        entityManager.persist(p1);
//        entityManager.persist(p2);
//
//        entityTransaction.commit();

        // Fetch

//        Person person=entityManager.find(Person.class,1);
//        System.out.println(person);
//
//        List<Person>list =entityManager.
//                createQuery("from Person",Person.class).getResultList();
//        for(Person persons:list){
//            System.out.println(persons);
//        }


        //Update
//
//        Person person1=entityManager.find(Person.class,12);
//        person1.setName("Saksham");
//        entityManager.merge(person1);
//        entityTransaction.commit();

        // Delete

        Person person =entityManager.find(Person.class,1);
        entityManager.remove(person);
        entityTransaction.commit();
    }
}
