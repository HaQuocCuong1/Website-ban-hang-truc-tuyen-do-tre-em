/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopbandotreem.dao;

import com.shopbandotreem.entity.Categories;
import com.shopbandotreem.entity.Product;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ASUS
 */
@Repository
public class ProductDAOImpl implements ProductDAO{
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    @Transactional
    public Product getProductCart(long productsId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Product theProducts = currentSession.get(Product.class, productsId);
        return theProducts;
    }
    @Override
    @Transactional
    public Product getProduct(int productsId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Product theProducts = currentSession.get(Product.class, productsId);
        return theProducts;
    }
    @Override
    @Transactional
    public List<Product> getlistProducts() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Product> theQuery = 
                currentSession.createQuery("from Product order by name ", Product.class);
        List<Product> products = theQuery.getResultList();
            return products;
    }
    @Override
    @Transactional
    public Categories getCategories(int categoriesId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Categories theCategories = currentSession.get(Categories.class, categoriesId);
        return theCategories;
    }
    
    @Override
    @Transactional
    public void saveProducts(Product theproduct, int categorieId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Categories categories= currentSession.get(Categories.class, categorieId);
        categories.addProduct(theproduct);
        currentSession.saveOrUpdate(theproduct);
    }
    
    
    @Override
    @Transactional
    public void updateProducts(Product tempproduct, int categorieId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Categories categories = currentSession.get(Categories.class, categorieId);
        Product theProducts = categories.getProduct(tempproduct.getId());
        setValueProducts(theProducts, tempproduct);
         currentSession.saveOrUpdate(theProducts);
    }

    
    @Override
    @Transactional
    public void deleteProducts(int productsId) {
        Session currentSession = sessionFactory.getCurrentSession();
            // delete object with primary key
         Product tempCProducts = currentSession.get(Product.class, productsId);
            currentSession.delete(tempCProducts);
    }
    private void setValueProducts(Product theProducts, Product tempProducts)
    {
        theProducts.setProductName(tempProducts.getProductName());
        theProducts.setDescription(tempProducts.getDescription());
        theProducts.setQuantity(tempProducts.getQuantity());
        theProducts.setPrice(tempProducts.getPrice());
       
    }

    @Override
    @Transactional
    public List<Product> getlistProductsForcategori(int categoriesId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Product> theQuery = 
                currentSession.createQuery("from Product where categories_id="+categoriesId+" order by name ", Product.class);
        List<Product> products = theQuery.getResultList();
            return products; 
    }


}
