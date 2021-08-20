/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopbandotreem.dao;

import com.shopbandotreem.entity.KhachHang;
import com.shopbandotreem.entity.Orders;
import com.shopbandotreem.entity.Product;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ASUS
 */
@Repository
public class OrderDAOImpl implements OrderDAO{
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public Orders getOrders(int orderId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Orders theOrders = currentSession.get(Orders.class, orderId);
        return theOrders;
    }

    @Override
    public List<Orders> getOrders() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Orders> theQuery = 
                currentSession.createQuery("from Orders", Orders.class);
        List<Orders> orders = theQuery.getResultList();
            return orders;
    }

    @Override
    public KhachHang getKhachhang(String makh) {
        Session currentSession = sessionFactory.getCurrentSession();
        KhachHang theKhachHang = currentSession.get(KhachHang.class, makh);
        return theKhachHang;
    }

    @Override
    public void saveOrders(Orders theOrders, String makh) {
        Session currentSession = sessionFactory.getCurrentSession();
        KhachHang khachHangs = currentSession.get(KhachHang.class, makh);
        khachHangs.addOrder(theOrders);
        currentSession.saveOrUpdate(theOrders);
    }

    @Override
    public void deleteOrders(int orderId) {
        Session currentSession = sessionFactory.getCurrentSession();
            // delete object with primary key
        Orders  tempCOrderss = currentSession.get(Orders.class, orderId);
            currentSession.delete(tempCOrderss);
    }
    
}
