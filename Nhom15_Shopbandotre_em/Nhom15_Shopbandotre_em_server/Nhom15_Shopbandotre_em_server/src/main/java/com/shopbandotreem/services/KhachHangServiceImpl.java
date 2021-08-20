/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopbandotreem.services;

import com.shopbandotreem.dao.KhachHangDAO;
import com.shopbandotreem.entity.KhachHang;
import com.shopbandotreem.entity.Orders;
import com.shopbandotreem.user.CrmUser;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Dell_Latitude_7480
 */
@Service
public class KhachHangServiceImpl implements KhachHangService{
    @Autowired 
    private KhachHangDAO khachhangDAO;
    
    
    @Override
    @Transactional
    public void savekhachhang(KhachHang khachhang){
        khachhangDAO.savekhachhang(khachhang);
    }
    
    @Override
    @Transactional
     public List<KhachHang> getTaiKhoans() {
        return khachhangDAO.getKhachhangs();
    }
     
    @Override
    @Transactional
     public KhachHang getKhachHang(String makh) {
        return khachhangDAO.getKhachhang(makh);
    }

    @Override
    @Transactional
    public List<Orders> getOrders(String makh) {
        return khachhangDAO.getOrders(makh);
    }

    @Override
    @Transactional
    public Orders getOrders(String khachhangId, int orderId) {
        return khachhangDAO.getOrders(khachhangId, orderId);
    }

}
