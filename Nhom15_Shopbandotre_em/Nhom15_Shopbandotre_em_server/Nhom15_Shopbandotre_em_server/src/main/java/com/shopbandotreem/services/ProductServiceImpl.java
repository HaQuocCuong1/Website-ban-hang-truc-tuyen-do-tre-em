/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopbandotreem.services;

import com.shopbandotreem.dao.ProductDAO;
import com.shopbandotreem.entity.Categories;
import com.shopbandotreem.entity.Product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ASUS
 */
@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductDAO productDAO;
    
    
    @Override
    @Transactional
    public Product getProductCart(long productId) {
        return productDAO.getProductCart(productId);
    }
    @Override
    @Transactional
    public List<Product> getlistProducts() {
        return productDAO.getlistProducts();
    }
    @Override
    @Transactional
    public Categories getCategories(int categoriesId) {
        return productDAO.getCategories(categoriesId);
    }
    @Override
    @Transactional
    public Product getProducts(int theId) {
        return productDAO.getProduct(theId);
    }

    @Override
    @Transactional
    public void saveProducts(Product theProducts, int categoriesId) {
        productDAO.saveProducts(theProducts, categoriesId);
    }

    @Override
    @Transactional
    public void updateProducts(Product theProducts, int categories) {
        productDAO.updateProducts(theProducts, categories );
    }

    @Override
    @Transactional
    public void deleteProducts(int theId) {
        productDAO.deleteProducts(theId);
    }

    @Override
    @Transactional
    public List<Product> getlistProductsForcategori(int categories) {
        return productDAO.getlistProductsForcategori(categories);
    }
    
}
