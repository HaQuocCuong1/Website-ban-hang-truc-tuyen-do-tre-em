/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopbandotreem.services;

import com.shopbandotreem.entity.OrderDetails;
import com.shopbandotreem.entity.Orders;
import com.shopbandotreem.entity.Product;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface OrderdetaiService {
    public OrderDetails getOrderDetails(int orderdetailId);
    public List<OrderDetails> getlistOrderDetails(int orderId);
    public Orders getOrders(int orderId);
    public Product getProduct(int productsId);
    public void saveOrderDetails(OrderDetails theOrderDetails, int orderId, int productsId);
    public void deleteOrderDetails(int orderDetails);
    public void updateOrderDetails(OrderDetails theOrderDetails, int orderId);
}
