/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopbandotreem.controller.web;

import com.shopbandotreem.entity.Product;
import com.shopbandotreem.services.CategoriesService;
import com.shopbandotreem.services.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ASUS
 */
@Controller
public class ProductDetailController{
    @Autowired
    private CategoriesService categoriesService;
    @Autowired
    private ProductService productService;
    @GetMapping("/product/chitiet")
    public String listCategories(
           @RequestParam("productId") int productId,
           Model theModel) {
        Product theProducts = productService.getProducts(productId);
        // set creditcard as a model attribute to pre-populate the form
        theModel.addAttribute("product", theProducts);
        // get persons from the service
        return "productDetail"; 
    }
}
