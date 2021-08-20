/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopbandotreem.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ASUS
 */

public class Product implements Serializable{
    
    private int id;
    
    private String productName;
    
    private String description;
    
    private int quantity;
    
    private double price;
    
    private String thumbnail;
    
    private List<OrderDetails> orderDetailist;
            
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public List<OrderDetails> getOrderDetails() {
        return orderDetailist;
    }
    public OrderDetails getOrderdetail(int orderdetailsId)
    {
          if(orderDetailist!=null)
          {
             for(OrderDetails theOrderdetails : orderDetailist)
                 if(theOrderdetails.getOrderdetailId()== orderdetailsId)
                     return theOrderdetails;
           }
          return null;
    }
    public void setOrderDetails(List<OrderDetails> OrderDetails) {
        this.orderDetailist = OrderDetails;
    }
    public void addOrdertail(OrderDetails theOrderdetail) {
        if (orderDetailist == null) {
            orderDetailist = new ArrayList<>(); }
        orderDetailist.add(theOrderdetail);}
   

   
    
    
    
}
