/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopbandotreem.rest;

import com.shopbandotreem.entity.OrderDetails;
import com.shopbandotreem.entity.Orders;
import com.shopbandotreem.services.OrderdetaiService;
import com.shopbandotreem.services.OrdersService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ASUS
 */
@RestController
@RequestMapping("/api")
public class OrderAdminController {
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private OrderdetaiService orderdetaiService;
    @GetMapping("/orders")
    public List<Orders> listOrders() {
        // get persons from the service
        List<Orders> theOrders = ordersService.getOrders();
        return theOrders; }
    @PostMapping("/orders/khachhangs/{makh}")
    public Orders saveOrders(@RequestBody Orders theOrders, 
            @PathVariable String makh ) {
        List<OrderDetails> lisOrderDetails = orderdetaiService.getlistOrderDetails(theOrders.getOrderID());
        theOrders.setOrderDetails(lisOrderDetails);
        ordersService.saveOrders(theOrders, makh);
        return theOrders;
    }
    @DeleteMapping("/orders/{orderId}")
    public String deleteOrder(@PathVariable int orderId ) {
        ordersService.deleteOrders(orderId);
        return "Delete order id="+orderId;
    }
    @GetMapping("/orders/{orderId}")
    public Orders getOrders(@PathVariable int orderId) {
            Orders theOrders = ordersService.getOrders(orderId);
            if (theOrders == null)
            {
                throw new NotFoundException("Orders not found - "+ orderId);
            }
            return theOrders;
    }
}
