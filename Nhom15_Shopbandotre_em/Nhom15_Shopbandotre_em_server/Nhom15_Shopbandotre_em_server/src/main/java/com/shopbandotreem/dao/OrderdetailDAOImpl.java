/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopbandotreem.dao;

import com.shopbandotreem.entity.OrderDetails;
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
public class OrderdetailDAOImpl implements OrderdetailDAO{
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public OrderDetails getOrderDetails(int orderdetailId) {
         Session currentSession = sessionFactory.getCurrentSession();
        OrderDetails theOrderDetails = currentSession.get(OrderDetails.class, orderdetailId);
        return theOrderDetails;
    }
    @Override
    public List<OrderDetails> getlistOrderDetails(int orderId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Orders orders = currentSession.get(Orders.class, orderId);
        Query<OrderDetails> theQuery = 
                currentSession.createQuery("from OrderDetails where order_id="+orderId, OrderDetails.class);
        List<OrderDetails> orderDetails = theQuery.getResultList();
            return orderDetails;
    }

    @Override
    public Orders getOrders(int orderId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Orders theOrders = currentSession.get(Orders.class, orderId);
        return theOrders;
    }

    @Override
    public Product getProduct(int productsId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Product theProducts = currentSession.get(Product.class, productsId);
        return theProducts;
    }

    @Override
    public void saveOrderDetails(OrderDetails theOrderDetails, int orderId, int productsId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Orders orders = currentSession.get(Orders.class, orderId);
        Product theProducts = currentSession.get(Product.class, productsId);
        orders.addOrdertail(theOrderDetails);
        theProducts.addOrdertail(theOrderDetails);
        currentSession.saveOrUpdate(theOrderDetails);
    }

    @Override
    public void deleteOrderDetails(int orderDetails) {
        Session currentSession = sessionFactory.getCurrentSession();
            // delete object with primary key
        OrderDetails  tempCOrderDetails = currentSession.get(OrderDetails.class, orderDetails);
            currentSession.delete(tempCOrderDetails);
    }

    @Override
    public void updateOrderDetails(OrderDetails tempOrderDetails, int orderId) {
         Session currentSession = sessionFactory.getCurrentSession();
        Orders orders = currentSession.get(Orders.class, orderId);
        OrderDetails theOrderDetails = orders.getOrderdetail(tempOrderDetails.getOrderdetailId());
        setValueOrderDetails(theOrderDetails, tempOrderDetails);
         currentSession.saveOrUpdate(theOrderDetails);
        
    }
    private void setValueOrderDetails(OrderDetails theOrderDetails, OrderDetails tempOrderDetails)
    {
        theOrderDetails.setQuantity(tempOrderDetails.getQuantity());
        theOrderDetails.setTotalAmmount(tempOrderDetails.getTotalAmmount());
       
    }
}
