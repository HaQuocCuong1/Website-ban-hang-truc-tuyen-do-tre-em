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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ASUS
 */
@Entity
@Table(name = "Categories")
public class Categories implements Serializable{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "categoryname")
    private String categoryName;
    @OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="categories_id")
    private List<Product> products;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Product> getProducts() {
        return products;
    }
    public Product getProduct(int productId)
    {
          if(products!=null)
          {
             for(Product theProduct:products)
                 if(theProduct.getId()== productId)
                     return theProduct;
           }
          return null;
    }
    public void setProducts(List<Product> products) {
        this.products = products;
    }
    public void addProduct(Product theProduct) {
        if (products == null) {
            products = new ArrayList<>(); }
        products.add(theProduct);}
}
