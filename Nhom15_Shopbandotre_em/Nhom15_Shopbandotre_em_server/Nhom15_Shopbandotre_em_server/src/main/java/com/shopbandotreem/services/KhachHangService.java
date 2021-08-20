/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopbandotreem.services;

import com.shopbandotreem.entity.KhachHang;
import com.shopbandotreem.entity.Orders;
import com.shopbandotreem.user.CrmUser;
import java.util.List;

/**
 *
 * @author Dell_Latitude_7480
 */
public interface KhachHangService {
    public void savekhachhang(KhachHang khachhang);
    public List<KhachHang> getTaiKhoans();
    public KhachHang getKhachHang(String makh);
    public List<Orders> getOrders(String makh);
    public Orders getOrders(String khachhangId, int orderId);
}
