/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopbandotreem.services;


import com.shopbandotreem.entity.KhachHang;
import java.util.List;

/**
 *
 * @author Dell_Latitude_7480
 */
public interface AdminService {
    public List<KhachHang> getKhachHangs();
    public void deleteKhachhang(String makh);
    public List<KhachHang> searchKhachhangs(String theSearchName);
    public List<KhachHang> getKhachHangs(int theSortField) ;
}
