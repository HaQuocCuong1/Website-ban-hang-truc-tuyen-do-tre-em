/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopbandotreem.services;

import com.shopbandotreem.dao.OrderDAO;
import com.shopbandotreem.entity.KhachHang;
import com.shopbandotreem.entity.Orders;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ASUS
 */
@Service
public class OrdersServiceImpl implements OrdersService{
    @Autowired
    private OrderDAO orderDao;
    
    @Override
    @Transactional
    public Orders getOrders(int orderId) {
        return orderDao.getOrders(orderId);
    }

    @Override
    @Transactional
    public List<Orders> getOrders() {
        return orderDao.getOrders();
    }

    @Override
    @Transactional
    public KhachHang getKhachhang(String makh) {
        return orderDao.getKhachhang(makh);
    }

    @Override
    @Transactional
    public void saveOrders(Orders theOrders, String makh) {
        orderDao.saveOrders(theOrders, makh);
    }

    @Override
    @Transactional
    public void deleteOrders(int orderId) {
        orderDao.deleteOrders(orderId);
    }
    
}
