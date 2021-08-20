/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopbandotreem.controller.web;

import com.shopbandotreem.entity.OrderDetails;
import com.shopbandotreem.services.OrderdetaiService;
import com.shopbandotreem.services.OrdersService;
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
@RequestMapping("/admin/chitiethoadon")
public class OrderDetailsAdminController {
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private OrderdetaiService orderdetaiService;
    @GetMapping("/list")
    public String listOrderdetail(@RequestParam("orderId") int orderID, Model theModel) {
        List<OrderDetails> listOrderDetails = orderdetaiService.getlistOrderDetails(orderID);
        theModel.addAttribute("dshoadon", listOrderDetails);
        theModel.addAttribute("orderid", orderID);
        return "orderDetailsAdmin"; 
    }
    @GetMapping("/showForEdit")
    public String editquantity(@RequestParam("orderid") int orderID, @RequestParam("orderdetailId") int productId,Model theModel) {
        OrderDetails theOrderDetails = orderdetaiService.getOrderDetails(productId);
        // set creditcard as a model attribute to pre-populate the form
        theModel.addAttribute("orderDetailsAttribute", theOrderDetails);
         theModel.addAttribute("orderID", orderID);
        // send over to our form		
        return "edit-orderdetails";
    }
    @PostMapping("/updateOrderDetail")
    public String updateOrderDetails(@ModelAttribute("orderDetailAttribute") OrderDetails theOrderDetails,
            @RequestParam("orderid") int orderid)
    {
        // save the customer using our service
        orderdetaiService.updateOrderDetails(theOrderDetails, orderid);	
        return "redirect:/admin/chitiethoadon/list?orderId="+orderid;
    }
}
