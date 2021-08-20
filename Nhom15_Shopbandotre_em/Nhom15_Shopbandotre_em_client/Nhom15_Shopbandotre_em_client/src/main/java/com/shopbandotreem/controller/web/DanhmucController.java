/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopbandotreem.controller.web;


import com.shopbandotreem.entity.Categories;
import com.shopbandotreem.services.ProductService;
import javax.enterprise.context.Initialized;
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
public class DanhmucController {
    @Autowired
    private ProductService productService;
   @GetMapping("/danhmuc")
    public String listCategories(@RequestParam("categoriesId") int categoriesId,Model theModel) {
        // get persons from the service
        //Categories categories = categoriesService.getCategories(categoriesId);
        Categories theCategories = productService.getCategories(categoriesId);
        theModel.addAttribute("categories", theCategories);
        return null; 
    }
}
