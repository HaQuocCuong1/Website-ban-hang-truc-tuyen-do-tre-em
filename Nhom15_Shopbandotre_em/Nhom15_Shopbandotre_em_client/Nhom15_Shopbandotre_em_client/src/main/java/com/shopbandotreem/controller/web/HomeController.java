/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopbandotreem.controller.web;

import com.shopbandotreem.entity.Categories;
import com.shopbandotreem.entity.KhachHang;
import com.shopbandotreem.entity.Product;
import com.shopbandotreem.services.CategoriesService;
import com.shopbandotreem.services.KhachHangService;
import com.shopbandotreem.services.ProductService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ASUS
 */
@Controller
public class HomeController {
    @Autowired
    private KhachHangService khachhangservice;
    @Autowired
    private CategoriesService categoriesService;
    @Autowired
    private ProductService productService;
    @GetMapping("/giohang")
    public String showCart()
    {
        return "giohang";
    }
    @GetMapping("/trangchu")
    public String listCategories(Model theModel) {
        // get persons from the service
        List<Categories> theCategories = categoriesService.getCategories();
        theModel.addAttribute("categories1", theCategories);
        List<Product> theProduct = productService.getlistProductsForcategori(18);
        theModel.addAttribute("listproducts", theProduct);
        String makh = String.valueOf(SecurityContextHolder.getContext().getAuthentication().getName());
        if (makh.equals("anonymousUser"))
        {
            theModel.addAttribute("khachhang", "");
        }else {
            theModel.addAttribute("khachhang", makh);
        }
        return "trangchu"; }
    @GetMapping("/product/list")
    public String listCategories(@RequestParam("categoriesId") int categoriesId,Model theModel) {
        // get persons from the service

        List<Categories> theCategories1 = categoriesService.getCategories();
        theModel.addAttribute("categories1", theCategories1);
//        Categories theCategories2 = productService.getCategories(categoriesId);
//        theModel.addAttribute("categories2", theCategories2);
        List<Product> theProduct = productService.getlistProductsForcategori(categoriesId);
        theModel.addAttribute("listproducts", theProduct);
        return "trangchu"; 
    }
}
