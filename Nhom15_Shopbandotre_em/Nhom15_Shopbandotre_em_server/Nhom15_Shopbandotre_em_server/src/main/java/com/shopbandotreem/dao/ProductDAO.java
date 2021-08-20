/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopbandotreem.dao;

import com.shopbandotreem.entity.Categories;
import com.shopbandotreem.entity.Product;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface ProductDAO {
    public Product getProduct(int productsId);
    public Product getProductCart(long productsId);
    public List<Product> getlistProducts();
    public List<Product> getlistProductsForcategori(int categories);
    public Categories getCategories(int categoriesId);
    public void saveProducts(Product theproduct, int categorieId);
    public void updateProducts(Product theproduct, int categorieId);
    public void deleteProducts(int productsId);
}