/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopbandotreem.rest;

import com.shopbandotreem.dao.AdminDAO;
import com.shopbandotreem.entity.KhachHang;
import com.shopbandotreem.services.AdminService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ASUS
 */
@RestController
@RequestMapping("/api")
public class AdminCustomerController {
    @Autowired
    private AdminService adminService;
    @GetMapping("/customers")
    public List<KhachHang> listCutomers() {
        // get persons from the service
        List<KhachHang> theCutomers = adminService.getKhachHangs();
        return theCutomers; }
    @GetMapping("/customers/sort/{theSortField}")
    public List<KhachHang> listCutomers(@PathVariable int theSortField) {
        // get persons from the service
        List<KhachHang> theCutomers = adminService.getKhachHangs(theSortField);
        return theCutomers; }
    @DeleteMapping("/customers/{makh}")
    public String deleteCustomer(@PathVariable String makh) {
            adminService.deleteKhachhang(makh);
            return "Deleted Customer makh - " + makh;
    }
    @GetMapping("/customers/search/{theSearchName}")
    public List<KhachHang> listCutomers(@PathVariable String theSearchName) {
        // get persons from the service
        List<KhachHang> theCutomers = adminService.searchKhachhangs(theSearchName);
        return theCutomers; }
}
