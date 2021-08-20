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
public class ProductServiceImpl implements ProductService{
    private RestTemplate restTemplate;
    private String crmRestUrl;

    public ProductServiceImpl(RestTemplate theRestTemplate, @Value("${products.rest.url}") String theUrl) {
        restTemplate = theRestTemplate;
        crmRestUrl = theUrl;
    }
    
    
    @Override
    public Product getProductCart(long productId) {
        Product theProducts = 
        restTemplate.getForObject(crmRestUrl + "/" + productId, 
                                  Product.class);
        return theProducts;
    }
    @Override 
    public List<Product> getlistProducts() {
        ResponseEntity<List<Product>> responseEntity = 
        restTemplate.exchange(crmRestUrl, HttpMethod.GET, null, 
        new ParameterizedTypeReference<List<Product>>() {});
        // get the list of customers from response
        List<Product> products = responseEntity.getBody();
        return products;
    }
    @Override
    public Categories getCategories(int categoriesId) {
        Categories theCategories = 
        restTemplate.getForObject(crmRestUrl + "/" + categoriesId, 
                                  Categories.class);
        return theCategories;
    }
    @Override
    public Product getProducts(int theId) {
        Product theProducts = 
        restTemplate.getForObject(crmRestUrl + "/" + theId, 
                                  Product.class);
        return theProducts;
    }

    @Override
    public void saveProducts(Product theProducts, int categoriesId) {
         int productId = theProducts.getId();
        // make REST call
        if (productId == 0) {
            restTemplate.postForEntity(crmRestUrl+"/categories/"+categoriesId, theProducts, String.class);			
        } else {
            // update Categories
            restTemplate.put(crmRestUrl+"/categories/"+categoriesId, theProducts);}
    }

    @Override
    public void updateProducts(Product theProducts, int categories) {
        restTemplate.put(crmRestUrl+"/categories/"+categories, theProducts);
    }

    @Override
    public void deleteProducts(int theId) {
        restTemplate.delete(crmRestUrl + "/" + theId);
    }

    @Override
    public List<Product> getlistProductsForcategori(int categories) {
        ResponseEntity<List<Product>> responseEntity = 
        restTemplate.exchange(crmRestUrl+"/categories/"+categories, HttpMethod.GET, null, 
        new ParameterizedTypeReference<List<Product>>() {});
        // get the list of customers from response
        List<Product> products = responseEntity.getBody();
        return products;
    }
    
}
