/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopbandotreem.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ASUS
 */

public class Orders implements Serializable{
    
    private int orderID;
    
   
    private Date orderDate;
    
   
    private Date shippedDate;
    
    
    private List<OrderDetails> listorderDetails;
    

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(Date shippedDate) {
        this.shippedDate = shippedDate;
    }

    public List<OrderDetails> getOrderDetails() {
        return listorderDetails;
    }
    public OrderDetails getOrderdetail(int orderdetailsId)
    {
          if(listorderDetails!=null)
          {
             for(OrderDetails theOrderdetails : listorderDetails)
                 if(theOrderdetails.getOrderdetailId()== orderdetailsId)
                     return theOrderdetails;
           }
          return null;
    }
    public void setOrderDetails(List<OrderDetails> OrderDetails) {
        this.listorderDetails = OrderDetails;
    }
    public void addOrdertail(OrderDetails theOrderdetail) {
        if (listorderDetails == null) {
            listorderDetails = new ArrayList<>(); }
        listorderDetails.add(theOrderdetail);}
    
    
}
