package com.example.hibernate.daoimpl;

import com.example.hibernate.dao.OrderDAO;
import com.example.hibernate.entity.Order;
import com.example.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OrderDAOImpl implements OrderDAO {

    @Override
    public String saveOrder(Order order) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.persist(order);

        tx.commit();
        session.close();

        return "Order Saved";
    }

    @Override
    public String updateOrder(Order order) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.merge(order);

        tx.commit();
        session.close();

        return "Order Updated";
    }

    @Override
    public String deleteOrderById(int id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Order order = session.get(Order.class, id);

        if(order != null){
            session.remove(order);
        }

        tx.commit();
        session.close();

        return "Order Deleted";
    }

    @Override
    public Order getOrderById(int id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Order order = session.get(Order.class, id);
        session.close();

        return order;
    }
}