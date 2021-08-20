/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopbandotreem.rest;

import com.shopbandotreem.entity.Categories;
import com.shopbandotreem.entity.KhachHang;
import com.shopbandotreem.entity.Orders;
import com.shopbandotreem.services.AdminService;
import com.shopbandotreem.services.KhachHangService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ASUS
 */
@RestController
@RequestMapping("/api")
public class CustomerController {
    @Autowired
    private KhachHangService khachHangService;
    @Autowired
    private AdminService adminService;
    @PostMapping("/customers")
    public KhachHang saveCategories(@RequestBody KhachHang theKhachHang) {
        // save the customer using our service
        List<Orders> orders =null;
        orders = khachHangService.getOrders(theKhachHang.getMakh());
        theKhachHang.setOrders(orders);
        khachHangService.savekhachhang(theKhachHang);	
        return theKhachHang;
    }
    @GetMapping("/customers/{makh}")
    public KhachHang getCustomer(@PathVariable String makh) {
            KhachHang theKhachHang = khachHangService.getKhachHang(makh);
            if (theKhachHang == null)
            {
                throw new NotFoundException("customers not found - "+ makh);
            }
            return theKhachHang;
    }
    @GetMapping("/customers/{makh}/orders/{orderId}")
    public Orders getCustomer(@PathVariable String makh, @PathVariable int orderId) {
            Orders  theOrders = khachHangService.getOrders(makh, orderId);
            if (theOrders == null)
            {
                throw new NotFoundException("customers not found - "+ makh);
            }
            return theOrders;
    }
    @GetMapping("/customers/{makh}/orders")
    public List<Orders> listOrder(@PathVariable String makh) {
        // get persons from the service
        List<Orders> theOrders = khachHangService.getOrders(makh);
        return theOrders; }
}
