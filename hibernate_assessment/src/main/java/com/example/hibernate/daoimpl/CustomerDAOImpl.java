package com.example.hibernate.daoimpl;

import com.example.hibernate.dao.CustomerDAO;
import com.example.hibernate.entity.Customer;
import com.example.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public String saveCustomer(Customer customer) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.persist(customer);

        tx.commit();
        session.close();

        return "Customer Saved";
    }

    @Override
    public String updateCustomer(Customer customer) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.merge(customer);

        tx.commit();
        session.close();

        return "Customer Updated";
    }

    @Override
    public String deleteCustomerById(int id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Customer c = session.get(Customer.class, id);

        if(c != null){
            session.remove(c);
        }

        tx.commit();
        session.close();

        return "Customer Deleted";
    }

    @Override
    public Customer getCustomerById(int id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Customer c = session.get(Customer.class, id);
        session.close();

        return c;
    }

    @Override
    public List<Customer> getAllCustomers() {

        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Customer> list =
                session.createQuery("from Customer", Customer.class).list();

        session.close();

        return list;
    }

    @Override
    public Customer getCustomerByEmail(String email) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Customer customer =
                session.createQuery(
                                "SELECT c FROM Customer c WHERE c.email = :email",
                                Customer.class)
                        .setParameter("email", email)
                        .uniqueResult();

        session.close();

        return customer;
    }
}