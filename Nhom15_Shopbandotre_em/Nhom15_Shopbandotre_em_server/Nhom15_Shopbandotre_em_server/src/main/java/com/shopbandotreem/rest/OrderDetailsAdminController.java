/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopbandotreem.rest;

import com.shopbandotreem.entity.OrderDetails;
import com.shopbandotreem.entity.Orders;
import com.shopbandotreem.entity.Product;
import com.shopbandotreem.services.OrderdetaiService;
import com.shopbandotreem.services.OrdersService;
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
public class OrderDetailsAdminController {
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private OrderdetaiService orderdetaiService;
    @GetMapping("/orderdetails/orders/{orderId}")
    public List<OrderDetails> listOrderdetail(@PathVariable int orderId) {
        List<OrderDetails> listOrderDetails = orderdetaiService.getlistOrderDetails(orderId);
        return listOrderDetails; 
    }
    @PutMapping("/orderdetails/orders/{orderid}")
    public OrderDetails updateOrderDetails(@RequestBody OrderDetails theOrderDetails,
            @PathVariable int orderid)
    {
        // save the customer using our service
        orderdetaiService.updateOrderDetails(theOrderDetails, orderid);	
        return theOrderDetails;
    }
    @PostMapping("/orderdetails/orders/{orderId}/product/{productId}")
    public OrderDetails saveOrderDetail(@RequestBody OrderDetails theOrderDetails, 
            @PathVariable int orderId ,@PathVariable int productId) {
        orderdetaiService.saveOrderDetails(theOrderDetails, orderId, productId);
        return theOrderDetails;
    }
    @DeleteMapping("orderdetails/{orderdetailId}")
    public String deleteOrderDetail(@PathVariable int orderdetailId) {

           
            orderdetaiService.deleteOrderDetails(orderdetailId);

            return "Deleted orderdetail id - " + orderdetailId;
    }
    @GetMapping("/orderdetails/{orderdetailId}")
    public OrderDetails getOrderDetail(@PathVariable int orderdetailId) {
        // get persons from the service
        OrderDetails theOrderDetails = orderdetaiService.getOrderDetails(orderdetailId);
        if (theOrderDetails == null)
            {
                throw new NotFoundException("OrderDetails not found - "+ orderdetailId);
            }
        return theOrderDetails; 
    }
}
