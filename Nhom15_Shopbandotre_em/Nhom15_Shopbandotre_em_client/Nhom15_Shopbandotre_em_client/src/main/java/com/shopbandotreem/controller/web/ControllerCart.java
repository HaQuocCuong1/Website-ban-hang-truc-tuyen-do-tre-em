/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopbandotreem.controller.web;

import com.shopbandotreem.entity.Product;
import com.shopbandotreem.model.Cart;
import com.shopbandotreem.model.CartItem;
import com.shopbandotreem.model.CartManager;
import com.shopbandotreem.services.CategoriesService;
import com.shopbandotreem.services.ProductService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ASUS
 */
@Controller
@RequestMapping("/cart")
public class ControllerCart {
    @Autowired
    private ProductService productService;
    @Autowired 
    private CartManager cartManager;
    private Cart cart;
    @GetMapping("/add")
    public String viewAdd(HttpSession session, @RequestParam("productId") int productId, @RequestParam(value = "qty", required = false, defaultValue = "1") int qty)
    {
        Product product = productService.getProducts(productId);
        Cart cart = cartManager.getCart(session);//Lay ve gio hang
        cart.addItem(product, qty);//Them san pham vao gio hang
        return "redirect:/cart/list";
    }
    @GetMapping("/addItem")
    public String viewItem(HttpSession session, @RequestParam("productId") int productId)
    {
        Product product = productService.getProducts(productId);
        Cart cart = cartManager.getCart(session);//Lay ve gio hang
        CartItem cartItem = new CartItem(product);
        cart.addItem(cartItem);//Them san pham vao gio hang
        return "redirect:/cart/list";
    }
    @GetMapping("/list")
    public String listCard(HttpSession session,Model theModel)
    {
        Cart cart = cartManager.getCart(session);//Lay ve gio hang
        List<CartItem> listItem = cart.getItems();
        double total = cart.getTotal();
        theModel.addAttribute("listItem", listItem);
        theModel.addAttribute("total", total);
        return "giohang";
    }
    @GetMapping("/update")
    public String viewUpdate(HttpSession session, @RequestParam("productId") int productId, @RequestParam("qty") int qty, Model theModel) {
        Product product = productService.getProducts(productId);
        Cart cart = new Cart();//lay ve gio hang
        cart.updateItem(product, qty);
        return "redirect:/cart/list";
    }
    @GetMapping("/remove")
    public String viewRemove(HttpSession session, @RequestParam("productId") int productId) {
        Product product = productService.getProducts(productId);
        Cart cart = cartManager.getCart(session);//lay ve gio hang
        cart.removeItem(product);
        return "redirect:/cart/list";
    }
}
