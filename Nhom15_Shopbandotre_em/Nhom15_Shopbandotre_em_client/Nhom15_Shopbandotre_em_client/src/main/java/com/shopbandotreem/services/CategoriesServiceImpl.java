/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopbandotreem.services;

import com.shopbandotreem.entity.Categories;
import com.shopbandotreem.entity.Product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author ASUS
 */
@Service
public class CategoriesServiceImpl implements CategoriesService{
   
    private RestTemplate restTemplate;
    private String crmRestUrl;

    @Autowired
    public CategoriesServiceImpl(RestTemplate theRestTemplate, @Value("${categorie.rest.url}") String theUrl) {
        restTemplate = theRestTemplate;
        crmRestUrl = theUrl;
    }
    
    @Override
    public Categories getCategories(int CategorieId) {
         Categories theCategories = 
        restTemplate.getForObject(crmRestUrl + "/" + CategorieId, 
                                  Categories.class);
        return theCategories;
    }
    @Override
    public List<Categories> getCategories() {
        ResponseEntity<List<Categories>> responseEntity = 
        restTemplate.exchange(crmRestUrl, HttpMethod.GET, null, 
        new ParameterizedTypeReference<List<Categories>>() {});
        // get the list of customers from response
        List<Categories> categories = responseEntity.getBody();
        return categories;
    }
    
    @Override
    public Product getProducts(int categoriesId, int productId) {
        Product theProducts = restTemplate.getForObject(crmRestUrl + "/"+categoriesId+"products"+productId, Product.class);
        return theProducts;
    }
    @Override
    public List<Product> getProducts(int CategorieId) {
        
        ResponseEntity<List<Product>> responseEntity = 
        restTemplate.exchange(crmRestUrl + "/"+CategorieId+"/products", HttpMethod.GET, null, 
        new ParameterizedTypeReference<List<Product>>() {});
        // get the list of customers from response
        List<Product> products = responseEntity.getBody();
        return products;
    }

    

    @Override
    public void saveCategories(Categories theCategories) {
        int categoriesId = theCategories.getId();
        // make REST call
        if (categoriesId == 0) {
            restTemplate.postForEntity(crmRestUrl, theCategories, String.class);			
        } else {
            // update Categories
            restTemplate.put(crmRestUrl, theCategories);}
    }


    @Override
    public void deleteCategories(int CategorieId) {
        restTemplate.delete(crmRestUrl + "/" + CategorieId);
    }
}
