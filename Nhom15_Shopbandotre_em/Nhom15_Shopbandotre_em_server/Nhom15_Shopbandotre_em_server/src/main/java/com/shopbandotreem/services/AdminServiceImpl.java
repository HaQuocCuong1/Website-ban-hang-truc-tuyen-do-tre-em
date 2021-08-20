/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopbandotreem.services;

import com.shopbandotreem.dao.AdminDAO;
import com.shopbandotreem.entity.KhachHang;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Dell_Latitude_7480
 */
@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    private AdminDAO adminDAO;
    
    @Override
    @Transactional
     public List<KhachHang> getKhachHangs() {
        return adminDAO.getKhachhangs();
    }
     
     @Override
    @Transactional
     public List<KhachHang> getKhachHangs(int theSortField) {
        return adminDAO.getKhachhangs(theSortField);
    }
     
     @Override
    @Transactional
     public void deleteKhachhang(String makh) {
         adminDAO.deleteKhachhang(makh);
    }
     
    @Override
    @Transactional
     public List<KhachHang> searchKhachhangs(String theSearchName) {
        return adminDAO.searchKhachhangs(theSearchName);
    }
}
