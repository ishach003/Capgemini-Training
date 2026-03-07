package Student_laptop.dao;

import Student_laptop.entity.Laptop;
import Student_laptop.entity.Student1;
import Student_laptop.repository.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class StudentDaoImpl implements StudentDao {

    @Override
    public void saveData() {
        EntityManager em = Repository.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        // -------- Student 1 --------
        Laptop laptop1 = new Laptop();
        laptop1.setBrand("Dell");
        laptop1.setPrice(65000);

        Student1 student1 = new Student1();
        student1.setName("Isha");
        student1.setCourse("Java");
        student1.setLaptop(laptop1);
        laptop1.setStudent(student1);

        em.persist(student1);  // cascade will save laptop

        // -------- Student 2 --------
        Laptop laptop2 = new Laptop();
        laptop2.setBrand("HP");
        laptop2.setPrice(70000);

        Student1 student2 = new Student1();
        student2.setName("Rahul");
        student2.setCourse("Spring");
        student2.setLaptop(laptop2);
        laptop2.setStudent(student2);

        em.persist(student2);

        // -------- Student 3 --------
        Laptop laptop3 = new Laptop();
        laptop3.setBrand("Lenovo");
        laptop3.setPrice(55000);

        Student1 student3 = new Student1();
        student3.setName("Priya");
        student3.setCourse("Hibernate");
        student3.setLaptop(laptop3);
        laptop3.setStudent(student3);

        em.persist(student3);

        tx.commit();
        em.close();

        System.out.println("Multiple Data Saved Successfully");
    }

    @Override
    public void fetchLaptopFromStudent(int studentId) {
        EntityManager em = Repository.getEntityManager();

        Student1 student = em.find(Student1.class, studentId);

        if (student != null && student.getLaptop() != null) {
            System.out.println("Laptop Brand: " + student.getLaptop().getBrand());
            System.out.println("Laptop Price: " + student.getLaptop().getPrice());
        }

        em.close();
    }

    @Override
    public void fetchStudentFromLaptop(int laptopId) {
        EntityManager em = Repository.getEntityManager();

        Laptop laptop = em.find(Laptop.class, laptopId);

        if (laptop != null && laptop.getStudent() != null) {
            System.out.println("Student Name: " + laptop.getStudent().getName());
            System.out.println("Course: " + laptop.getStudent().getCourse());
        } else {
            System.out.println("Laptop or Student not found");
        }

        em.close();
    }

    @Override
    public void updateLaptopBrand(int laptopId, String newBrand) {
        EntityManager em = Repository.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Laptop laptop = em.find(Laptop.class, laptopId);

        if (laptop != null) {
            laptop.setBrand(newBrand);
            System.out.println("Laptop Brand Updated");
        } else {
            System.out.println("Laptop not found");
        }

        tx.commit();
        em.close();
    }

    @Override
    public void updateStudentCourse(int studentId, String newCourse) {
        EntityManager em = Repository.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Student1 student = em.find(Student1.class, studentId);

        if (student != null) {
            student.setCourse(newCourse);
            System.out.println("Student Course Updated");
        } else {
            System.out.println("Student not found");
        }

        tx.commit();
        em.close();
    }

    @Override
    public void changeLaptopForStudent(int studentId, int newLaptopId) {
        EntityManager em = Repository.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Student1 student = em.find(Student1.class, studentId);

        if (student == null) {
            System.out.println("Student not found");
            tx.rollback();
            em.close();
            return;
        }

        Laptop newlaptop =em.find(Laptop.class,newLaptopId);

        if(newlaptop==null){
            newlaptop=new Laptop();
            newlaptop.setBrand("Random_"+newLaptopId);
            newlaptop.setPrice(10000+newLaptopId*100);

           em.persist(newlaptop);
            System.out.println("New Laptop Created and Saved");

        }
        student.setLaptop(newlaptop);
        newlaptop.setStudent(student);


        tx.commit();
        em.close();
    }

    @Override
    public void removeLaptopFromStudent(int studentId) {
        EntityManager em = Repository.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Student1 student = em.find(Student1.class, studentId);

        if (student != null && student.getLaptop() != null) {

            Laptop laptop = student.getLaptop();

            student.setLaptop(null);
            em.remove(laptop);

            System.out.println("Laptop removed from student and deleted from table");
        } else {
            System.out.println("Student or Laptop not found");
        }

        tx.commit();
        em.close();
    }

    @Override
    public void deleteStudentAndLaptop(int studentId) {
        EntityManager em = Repository.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Student1 student = em.find(Student1.class, studentId);

        if (student != null) {

            Laptop laptop = student.getLaptop();

            if (laptop != null) {
                em.remove(laptop);
            }

            em.remove(student);

            System.out.println("Student and Laptop deleted successfully");
        } else {
            System.out.println("Student not found");
        }

        tx.commit();
        em.close();
    }
}