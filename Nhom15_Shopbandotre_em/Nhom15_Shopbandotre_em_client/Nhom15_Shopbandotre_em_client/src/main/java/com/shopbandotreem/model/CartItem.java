/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopbandotreem.model;

import com.shopbandotreem.entity.Product;

/**
 *
 * @author ASUS
 */
public class CartItem {
    private final Product product;
    private int quantity;
    private double subTotal;
    
    public CartItem(Product product) {
        this.product = product;
        this.quantity = 1;
        this.subTotal = product.getPrice();
    }
    
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSubTotal() {
        subTotal = product.getPrice() * quantity;
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }
    public Product getProduct()
    {
        return product;
    }
    
}
