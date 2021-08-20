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
public class CategoriesDAOImpl implements CategoriesDAO{
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    @Transactional
    public Categories getCategories(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Categories theCategories = currentSession.get(Categories.class, theId);
        return theCategories;
    }
    @Override
    @Transactional
    public List<Categories> getCategories() {
        Session currentSession = sessionFactory.getCurrentSession();
            Query<Categories> theQuery = 
                currentSession.createQuery("from Categories order by categoryname", Categories.class);
            List<Categories> categories = theQuery.getResultList();
            return categories;
    }
    
    @Override
    @Transactional
    public List<Product> getProducts(int theCategoriesId) {
        Categories theCategories = getCategories(theCategoriesId);
            List<Product> products =theCategories.getProducts();
            return products;
    }
    
    @Override
    @Transactional
    public Product getProducts(int categoriesId, int productId) {
        Categories theCategories = getCategories(categoriesId);
          if(theCategories!=null)
             return theCategories.getProduct(productId);
          else
            return null;
    }
    
    @Override
    @Transactional
    public void saveCategories(Categories theCategories) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(theCategories);
    }
    
    @Override
    @Transactional
    public void deleteCategories(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
            Categories tempCategories = currentSession.get(Categories.class, theId);
            currentSession.delete(tempCategories);
    }
    
}
