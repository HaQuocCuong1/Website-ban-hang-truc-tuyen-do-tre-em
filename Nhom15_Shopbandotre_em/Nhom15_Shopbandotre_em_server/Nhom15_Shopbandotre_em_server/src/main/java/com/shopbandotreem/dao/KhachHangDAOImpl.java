 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopbandotreem.dao;

import com.shopbandotreem.entity.KhachHang;
import com.shopbandotreem.entity.Orders;
import com.shopbandotreem.user.CrmUser;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Dell_Latitude_7480
 */

@Repository
public class KhachHangDAOImpl implements KhachHangDAO{
    @Autowired
    private SessionFactory sessionFactory;
    
    
    @Override
    public KhachHang getKhachhang(String makh){
        Session currentSession = sessionFactory.getCurrentSession();
        KhachHang khachhang = currentSession.get(KhachHang.class, makh);
        return khachhang;
    }
    
    @Transactional
    @Override
    public List<KhachHang> getKhachhangs() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<KhachHang> theQuery = currentSession.createQuery("from KhachHang order by ten", KhachHang.class);
        List<KhachHang> khachhangs = theQuery.getResultList();
        return khachhangs;
    }
    
    @Override
    public void savekhachhang(KhachHang khachhang){
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(khachhang);
    }

    @Override
    public List<Orders> getOrders(String makh) {
        KhachHang theKhachHang = getKhachhang(makh);
            List<Orders> orders =theKhachHang.getOrders();
            return orders;
    }

    @Override
    public Orders getOrders(String khachhangId, int orderId) {
       KhachHang theKhachHang = getKhachhang(khachhangId);
          if(theKhachHang!=null)
             return theKhachHang.getOrder(orderId);
          else
            return null;
    }
}
