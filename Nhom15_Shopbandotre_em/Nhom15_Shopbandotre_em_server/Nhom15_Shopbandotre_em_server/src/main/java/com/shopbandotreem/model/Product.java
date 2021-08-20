/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopbandotreem.model;

/**
 *
 * @author ASUS
 */
public class Product {
    private int id;
    private String name;
    private String description;
    private String title;
    private double price;
    private String img;

    public Product() {
    }
    public Product(String name, String description, String title, double price, String img) {
        this.name = name;
        this.description = description;
        this.title = title;
        this.price = price;
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + ", img=" + img + '}';
    }
    
}
