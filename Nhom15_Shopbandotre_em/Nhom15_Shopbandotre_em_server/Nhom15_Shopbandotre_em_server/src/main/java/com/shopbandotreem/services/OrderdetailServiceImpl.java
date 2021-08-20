/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopbandotreem.services;

import com.shopbandotreem.dao.OrderdetailDAO;
import com.shopbandotreem.entity.OrderDetails;
import com.shopbandotreem.entity.Orders;
import com.shopbandotreem.entity.Product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ASUS
 */
@Service
public class OrderdetailServiceImpl implements OrderdetaiService{
    @Autowired
    private OrderdetailDAO orderdetailDAO;

    @Override
    @Transactional
    public OrderDetails getOrderDetails(int orderdetailId) {
        return orderdetailDAO.getOrderDetails(orderdetailId);
    }

    @Override
    @Transactional
    public List<OrderDetails> getlistOrderDetails(int orderId) {
        return orderdetailDAO.getlistOrderDetails(orderId);
    }

    @Override
    @Transactional
    public Orders getOrders(int orderId) {
        return orderdetailDAO.getOrders(orderId);
    }

    @Override
    @Transactional
    public Product getProduct(int productsId) {
        return orderdetailDAO.getProduct(productsId);
    }

    @Override
    @Transactional
    public void saveOrderDetails(OrderDetails theOrderDetails, int orderId, int productsId) {
        orderdetailDAO.saveOrderDetails(theOrderDetails, orderId, productsId);
    }

    @Override
    @Transactional
    public void deleteOrderDetails(int orderDetails) {
        orderdetailDAO.deleteOrderDetails(orderDetails);
    }

    @Override
    @Transactional
    public void updateOrderDetails(OrderDetails theOrderDetails, int orderId) {
        orderdetailDAO.updateOrderDetails(theOrderDetails, orderId);
    }
}
