/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopbandotreem.entity;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Nationalized;

/**
 *
 * @author Dell_Latitude_7480
 */
public class KhachHang implements Serializable {

   
    private String makh;

    
    private String ho;

    
    private String ten;

   
    private String sdt;
   
    private String email;

    
    private String gioitinh;
     
     
    private Date ngaysinh;
     
    private String diachi;
      
    private List<Orders> orders;

   

    

    public KhachHang() {
    }

   

   

    public KhachHang(String makh, String ho, String ten, String sdt, String email, String gioitinh, Date ngaysinh, String diachi) {
        this.makh = makh;
        this.ho = ho;
        this.ten = ten;
        this.sdt = sdt;
        this.email = email;
        this.gioitinh = gioitinh;
        this.ngaysinh = ngaysinh;
        this.diachi = diachi;
    }
    
    public String getMakh() {
        return makh;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }
    
    public List<Orders> getOrders() {
        return orders;
    }
    public Orders getOrder(int orderId)
    {
          if(orders!=null)
          {
             for(Orders theOrder : orders)
                 if(theOrder.getOrderID()== orderId)
                     return theOrder;
           }
          return null;
    }
    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }
    public void addOrder(Orders theOrder) {
        if (orders == null) {
            orders = new ArrayList<>(); }
        orders.add(theOrder);}
   

    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.makh);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final KhachHang other = (KhachHang) obj;
        if (!Objects.equals(this.makh, other.makh)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
}
