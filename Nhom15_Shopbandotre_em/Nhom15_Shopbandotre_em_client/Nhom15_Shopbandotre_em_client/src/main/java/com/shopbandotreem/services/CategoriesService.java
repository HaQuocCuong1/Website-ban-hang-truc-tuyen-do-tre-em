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
public interface CategoriesService {
    public List<Categories> getCategories();
    public List<Product> getProducts(int CategorieId);
    public Product getProducts(int categoriesId, int productId);
    public void saveCategories(Categories theCategories);
    public Categories getCategories(int CategorieId);
    public void deleteCategories(int CategorieId);
}
