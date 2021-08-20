/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopbandotreem.rest;

import com.shopbandotreem.entity.Categories;
import com.shopbandotreem.entity.Product;
import com.shopbandotreem.services.CategoriesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ASUS
 */
@RestController
@RequestMapping("/api")
public class LoaisanphamController {
    @Autowired
    private CategoriesService categoriesService;
    @PostMapping("/categories")
    public Categories saveCategories(@RequestBody Categories theCategories) {
        // save the customer using our service
        List<Product> products =null;
        if(theCategories.getId()!= 0)
        {
            products= categoriesService.getProducts(theCategories.getId());
        }
        theCategories.setProducts(products);
        theCategories.setId(0);
        categoriesService.saveCategories(theCategories);	
        return theCategories;
    }
    @GetMapping("/categories/{theId}")
    public Categories getCategories(@PathVariable int theId) {
            Categories theCategories = categoriesService.getCategories(theId);
            if (theCategories == null)
            {
                throw new NotFoundException("categorie not found - "+ theId);
            }
            return theCategories;
    }
    @DeleteMapping("/categories/{theId}")
    public String deleteCategory(@PathVariable int theId) {
            categoriesService.deleteCategories(theId);
            return "Deleted categories id - " + theId;
    }
    @PutMapping("/categories")
    public Categories updateCategories(@RequestBody Categories theCategories) {
            categoriesService.saveCategories(theCategories);
            return theCategories;
    }
    @GetMapping("/categories")
    public List<Categories> listCategories() {
        // get persons from the service
        List<Categories> theCategories = categoriesService.getCategories();
        return theCategories; }
    @GetMapping("/categories/{theId}/products")
    public List<Product> listProduct(@PathVariable int theId) {
        // get persons from the service
        List<Product> theProduct = categoriesService.getProducts(theId);
        return theProduct; }
}
