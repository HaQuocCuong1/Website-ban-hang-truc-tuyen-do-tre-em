/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopbandotreem.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author ASUS
 */
@Entity
@Table(name = "OrderDetails")
public class OrderDetails implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderdetailId")
    private int orderdetailId;
    
    @Column(name = "quantity")
    private int quantity;
    
    @Column(name = "totalammount")
    private float totalAmmount;

    public int getOrderdetailId() {
        return orderdetailId;
    }

    public void setOrderdetailId(int orderdetailId) {
        this.orderdetailId = orderdetailId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getTotalAmmount() {
        return totalAmmount;
    }

    public void setTotalAmmount(float totalAmmount) {
        this.totalAmmount = totalAmmount;
    }

    

       
}
