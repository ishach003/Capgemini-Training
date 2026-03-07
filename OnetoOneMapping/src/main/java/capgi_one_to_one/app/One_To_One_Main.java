package capgi_one_to_one.app;

import capgi_one_to_one.entity.Human;
import capgi_one_to_one.entity.Pan;
import capgi_one_to_one.entity.Passport;
import capgi_one_to_one.entity.Person1;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class One_To_One_Main {
    public static void main(String[] args) {
//        Person1 person1=new Person1();
//        person1.setId(1);
//        person1.setName("Tom");
//
//        Pan pan=new Pan();
//        pan.setPanNumber(1);
//        pan.setPanAddress("Noida");
//
//        person1.setPan(pan);
//        pan.setPerson1(person1);

        Passport passport=new Passport();
        passport.setPassportNumber(123);
        passport.setCountry("America");

        Human human=new Human();
        human.setId(1);
        human.setName("Tom");
        human.setAddress("noida");
        human.setPassport(passport);


        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("jpa-example");
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction=entityManager.getTransaction();

        entityTransaction.begin();

//        entityManager.persist(pan);
//        entityManager.persist(person1);

        entityManager.persist(human);
        entityManager.persist(passport);
        entityTransaction.commit();

    }
}
