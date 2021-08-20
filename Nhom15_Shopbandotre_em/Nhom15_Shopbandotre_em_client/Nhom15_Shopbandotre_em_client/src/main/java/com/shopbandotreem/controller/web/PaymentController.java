/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopbandotreem.controller.web;

import com.shopbandotreem.entity.KhachHang;
import com.shopbandotreem.model.Cart;
import com.shopbandotreem.model.CartItem;
import com.shopbandotreem.model.CartManager;
import com.shopbandotreem.services.KhachHangService;
import com.shopbandotreem.services.OrderdetaiService;
import com.shopbandotreem.services.OrdersService;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ASUS
 */
@Controller
@RequestMapping("/payment")
public class PaymentController {
    @Autowired 
    private CartManager cartManager;
    @Autowired
    private KhachHangService khachhangservice;
    @GetMapping("/form")
    public String getPayment(Model themodel, HttpSession session)
    {
        Cart cart = cartManager.getCart(session);//Lay ve gio hang
        List<CartItem> listItem = cart.getItems();
        double total = cart.getTotal();
        themodel.addAttribute("listItem", listItem);
        themodel.addAttribute("total", total);
        String makh = String.valueOf(SecurityContextHolder.getContext().getAuthentication().getName());
        KhachHang thekhachhang = khachhangservice.getKhachHang(makh);
        themodel.addAttribute("khachhang", thekhachhang);
        return "payment";
    }
}
