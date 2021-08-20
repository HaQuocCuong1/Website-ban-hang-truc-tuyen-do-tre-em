/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopbandotreem.dao;

import com.shopbandotreem.entity.KhachHang;
import com.shopbandotreem.utils.SortUtils;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Dell_Latitude_7480
 */

@Repository
@EnableTransactionManagement
public class AdminDAOImpl implements AdminDAO{
    @Autowired
    private SessionFactory sessionFactory;
    private int status = 0;
    private int status2 = 0;
    
    @Transactional
    @Override
    public List<KhachHang> getKhachhangs() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<KhachHang> theQuery = currentSession.createQuery("from KhachHang order by ten", KhachHang.class);
        List<KhachHang> khachhangs = theQuery.getResultList();
        return khachhangs;
    }
    
    @Transactional
    @Override
    public List<KhachHang> getKhachhangs(int theSortField) {
        Session currentSession = sessionFactory.getCurrentSession();
        String theFieldName = null;
        switch (theSortField){
            case SortUtils.MAKH:
                theFieldName = "makh";
             case SortUtils.HOTEN:
                theFieldName = "ten";
            default:
                theFieldName = "ten";
        }
        
        String queryString;
        if(status == theSortField){
             if (status2 == 0) {
                queryString = "from KhachHang order by " + theFieldName + " DESC";
                status2=1;
            }else{
                queryString = "from KhachHang order by " + theFieldName + " ASC";
                status2=0;
            }
        }else{
            status = theSortField;
            queryString = "from KhachHang order by " + theFieldName + " ASC";
        }
        
        Query<KhachHang> theQuery = currentSession.createQuery(queryString, KhachHang.class);
        List<KhachHang> khachhangs = theQuery.getResultList();
        return khachhangs;
    }
    
    @Transactional
    @Override
    public void deleteKhachhang(String makh) {
        Session currentSession = sessionFactory.getCurrentSession();
        KhachHang tempkhachhang = currentSession.getReference(KhachHang.class, makh);
        currentSession.delete(tempkhachhang);
        
    }
    @Transactional
    @Override
    public List<KhachHang> searchKhachhangs(String theSearchName) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query theQuery = null;
        if(theSearchName != null && theSearchName.trim().length() > 0){
            theQuery = currentSession.createQuery("from KhachHang where lower(makh) like :theName or lower(ten) like :theName", KhachHang.class);
            theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");
        }else{
            theQuery = currentSession.createQuery("from KhachHang", KhachHang.class);
            
        }
        List<KhachHang> khachhangs = theQuery.getResultList();
        return khachhangs;
    }
}
