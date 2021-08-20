/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopbandotreem.controller.web;

import com.shopbandotreem.entity.Categories;
import com.shopbandotreem.entity.Product;
import com.shopbandotreem.services.CategoriesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ASUS
 */
@Controller
@RequestMapping("/admin/loaisanpham")
public class LoaisanphamController {
    @Autowired
    private CategoriesService categoriesService;
    @PostMapping("/saveCategories")
    public String saveCategories(@ModelAttribute("categories") Categories theCategories) {
        // save the customer using our service
        List<Product> products =null;
        if(theCategories.getId()!= 0)
        {
            products= categoriesService.getProducts(theCategories.getId());
        }
        theCategories.setProducts(products);
        categoriesService.saveCategories(theCategories);	
        return "redirect:/admin/loaisanpham/list";
    }
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("categoriesId") int theId,
                    Model theModel) {
        Categories theCategories = categoriesService.getCategories(theId);	
        theModel.addAttribute("categories", theCategories);
       		
        return "loaisanpham-form";    
    }
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        // create model attribute to bind form data
        Categories theCategories = new Categories();
        theModel.addAttribute("categories", theCategories);
        //theModel.addAttribute("update", false);
        return "loaisanpham-form";    }  
    @GetMapping("/delete")
    public String deleteCategory(@RequestParam("categoriesId") int theId) {
            categoriesService.deleteCategories(theId);
            return "redirect:/admin/loaisanpham/list";
    }
    @GetMapping("/list")
    public String listCategories(Model theModel) {
        // get persons from the service
        List<Categories> theCategories = categoriesService.getCategories();
        theModel.addAttribute("categories", theCategories);
        return "loaisanpham-list"; }
}
