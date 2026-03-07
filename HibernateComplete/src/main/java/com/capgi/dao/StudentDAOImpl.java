package com.capgi.dao;

import com.capgi.entity.Student;
import com.capgi.repository.StudentRepository;
import org.hibernate.Session;
import org.hibernate.SessionBuilder;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;


public class StudentDAOImpl implements StudentDMO {


    @Override
    public void save(Student student) {
        Session session= StudentRepository.getSession();
        Transaction tx=session.beginTransaction();
        session.persist(student);
        tx.commit();
        session.close();
    }

    @Override
    public List<Student> fetchAll() {
        Session session= StudentRepository.getSession();
        List<Student> list=
                session.createQuery("from Student",Student.class).list();
        session.close();
        return list;
    }

    @Override
    public Student fetchById(int id) {
        Session session = StudentRepository.getSession();
        Student student = session.createQuery("from Student where id=:id",Student.class)
                        .setParameter("id",id)
                                .uniqueResult();

        session.close();
        return student;
    }

    @Override
    public void updateMarks(int id, double marks) {
        Session session = StudentRepository.getSession();
        Transaction tx = session.beginTransaction();

        Student student = session.createQuery("from Student where id=:id", Student.class)
                .setParameter("id", id)
                .uniqueResult();
        if (student != null) {
            student.setMarks(marks);
        }

        tx.commit();
        session.close();
    }

    @Override
    public void delete(int id) {
        Session session = StudentRepository.getSession();
        Transaction tx = session.beginTransaction();

        Student student = session.createQuery("from Student where id=:id", Student.class)
                .setParameter("id", id)
                .uniqueResult();
        if (student != null) {
            session.remove(student);
        }

        tx.commit();
        session.close();
    }

    @Override
    public List<Student> sortByMarks() {
        Session session = StudentRepository.getSession();
        List<Student> list = session.createQuery("from Student order by marks", Student.class)
                .getResultList();
        session.close();
        return list;
    }

    @Override
    public List<Student> sortByAgeDesc() {
        Session session = StudentRepository.getSession();
        List<Student> list = session.createQuery("from Student order by age desc", Student.class)
                .getResultList();
        session.close();
        return list;
    }

    @Override
    public List<Student> filterByDept(String dept) {
        Session session = StudentRepository.getSession();
        List<Student> list = session.createQuery("from Student where dept=:d", Student.class)
                .setParameter("d", dept)
                .getResultList();
        session.close();
        return list;
    }

    @Override
    public List<String> nativeFetch() {
        Session session = StudentRepository.getSession();
        List<String> list = session.createNativeQuery("select name from Student")
                .getResultList();
        session.close();
        return list;
    }

    @Override
    public void nativeUpdateMarks(int id, double marks) {
        Session session = StudentRepository.getSession();
        Transaction tx = session.beginTransaction();

        Query query = session.createNativeQuery("update Student set marks=:m where id=:i");
        query.setParameter("m", marks);
        query.setParameter("i", id);

        query.executeUpdate();
        tx.commit();
        session.close();
    }
}
