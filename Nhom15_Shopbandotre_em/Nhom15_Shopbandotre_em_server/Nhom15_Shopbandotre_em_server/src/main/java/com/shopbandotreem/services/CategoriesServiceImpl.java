/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopbandotreem.services;

import com.shopbandotreem.dao.CategoriesDAO;
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
public class CategoriesServiceImpl implements CategoriesService{
    @Autowired
    private CategoriesDAO categoriesDAO;
    
    
    @Override
    @Transactional
    public Categories getCategories(int CategorieId) {
        return categoriesDAO.getCategories(CategorieId);
    }
    @Override
    @Transactional
    public List<Categories> getCategories() {
        return categoriesDAO.getCategories();
    }
    
    @Override
    @Transactional
    public Product getProducts(int categoriesId, int productId) {
        return categoriesDAO.getProducts(categoriesId, productId);
    }
    @Override
    @Transactional
    public List<Product> getProducts(int CategorieId) {
        return categoriesDAO.getProducts(CategorieId);
    }

    

    @Override
    @Transactional
    public void saveCategories(Categories theCategories) {
        categoriesDAO.saveCategories(theCategories);
    }


    @Override
    @Transactional
    public void deleteCategories(int CategorieId) {
        categoriesDAO.deleteCategories(CategorieId);
    }
}
