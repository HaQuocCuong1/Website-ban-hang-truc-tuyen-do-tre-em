/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopbandotreem.services;

import com.shopbandotreem.entity.KhachHang;
import com.shopbandotreem.entity.Orders;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface OrdersService {
    public Orders getOrders(int orderId);
    public List<Orders> getOrders();
    public KhachHang getKhachhang(String makh);
    public void saveOrders(Orders theOrders, String makh);
    public void deleteOrders(int orderId);
}
