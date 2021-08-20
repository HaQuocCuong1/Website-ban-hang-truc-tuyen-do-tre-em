/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopbandotreem.controller.web;

import com.shopbandotreem.entity.Orders;
import com.shopbandotreem.services.OrdersService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ASUS
 */
@Controller
@RequestMapping("/admin/hoadon")
public class OrderAdminController {
    @Autowired
    private OrdersService ordersService;
    @GetMapping("/list")
    public String listCategories(Model theModel) {
        // get persons from the service
        List<Orders> theOrders = ordersService.getOrders();
        theModel.addAttribute("orders", theOrders);
        return "orderadmin-list"; }
}
