/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopbandotreem.controller.web;

import com.shopbandotreem.entity.KhachHang;
import com.shopbandotreem.entity.OrderDetails;
import com.shopbandotreem.entity.Orders;
import com.shopbandotreem.model.Cart;
import com.shopbandotreem.model.CartItem;
import com.shopbandotreem.model.CartManager;
import com.shopbandotreem.services.KhachHangService;
import com.shopbandotreem.services.OrderdetaiService;
import com.shopbandotreem.services.OrdersService;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.context.SecurityContextHolder;
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
@RequestMapping("/hoadon")
public class OrderController {
    @Autowired 
    private CartManager cartManager;
    @Autowired
    private KhachHangService khachhangservice;
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private OrderdetaiService orderdetaiService;
    @GetMapping("/add")
    public String Ordersave(Model theModel, HttpSession session)
    {
        String makh = String.valueOf(SecurityContextHolder.getContext().getAuthentication().getName());
        Orders theorder = new Orders();
        theorder.setOrderDate(Date.valueOf(LocalDate.now()));
        theorder.setShippedDate(Date.valueOf(LocalDate.now()));
        ordersService.saveOrders(theorder, makh);
        Cart cart = cartManager.getCart(session);//Lay ve gio hang
        OrderDetails orderdetail = new OrderDetails();
        orderdetail.setQuantity(cart.getItemCount());
        orderdetail.setTotalAmmount(cart.getTotal());
        List<CartItem> listItem = cart.getItems();
        List<Orders> listorder = ordersService.getOrders();
        int orderId = 0;
        for (int i = 0; i < listorder.size(); i++)
        {
            orderId = listorder.get(i).getOrderID();
        }
        theorder.setOrderID(orderId);
        //List<Products> orderproduct = null;
        for (int i = 0; i < listItem.size(); i++)
        {
            orderdetaiService.saveOrderDetails(orderdetail, theorder.getOrderID(), listItem.get(i).getProduct().getId());
           // orderproduct.add(orderdetaiService.getProduct(listItem.get(i).getProduct().getId()));
        }
        theModel.addAttribute("listItem", listItem);
        theModel.addAttribute("order", theorder);
        theModel.addAttribute("orderdetail", orderdetail);
        cart.clear();
        return "order-list";
    }
}
