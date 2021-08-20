/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopbandotreem.dao;

import com.shopbandotreem.entity.KhachHang;
import java.util.List;

/**
 *
 * @author Dell_Latitude_7480
 */
public interface AdminDAO {
     public List<KhachHang> getKhachhangs();
     public void deleteKhachhang(String makh);
     public List<KhachHang> searchKhachhangs(String theSearchName);
      public List<KhachHang> getKhachhangs(int theSortField);
}
