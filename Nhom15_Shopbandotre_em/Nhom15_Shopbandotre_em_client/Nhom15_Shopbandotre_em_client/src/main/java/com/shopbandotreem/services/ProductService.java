/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopbandotreem.services;

import com.shopbandotreem.entity.Categories;
import com.shopbandotreem.entity.Product;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface ProductService {
    public Product getProducts(int theId);
    public Product getProductCart(long productsId);
    public Categories getCategories(int categoriesId);
    public List<Product> getlistProductsForcategori(int categories);
    public List<Product> getlistProducts();
    public void saveProducts(Product theProducts, int categoriesId);
    public void updateProducts(Product theProducts,  int categoriesId);
    public void deleteProducts(int theId);
    
}
