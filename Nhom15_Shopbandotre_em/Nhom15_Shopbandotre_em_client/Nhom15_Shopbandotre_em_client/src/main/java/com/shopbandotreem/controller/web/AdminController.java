/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopbandotreem.controller.web;

import com.shopbandotreem.entity.KhachHang;
import com.shopbandotreem.services.AdminService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.UserDetailsManager;
/**
 *
 * @author Dell_Latitude_7480
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    
    private AdminService adminService;
    
    @Autowired
    private UserDetailsManager userDetailsManager;
    
    @GetMapping("/listkhachhang")
    public String listKhachhangs(Model theModel, @RequestParam(required=false, name = "sort") String sort){
        List<KhachHang> theKhachhangs=null;
        if(sort != null){
            int theSortField = Integer.parseInt(sort);
            theKhachhangs = adminService.getKhachHangs(theSortField);
        }else{
             theKhachhangs = adminService.getKhachHangs();
        }
       
        theModel.addAttribute("khachhangs", theKhachhangs); 
        return "giaodienquanlytaikhoan";
    }
    
    @GetMapping("/deletekhachhang")
    public String deletekhachhang(@RequestParam("makh") String makh){
      
        userDetailsManager.deleteUser(makh);
        adminService.deleteKhachhang(makh);
        return "redirect:/admin/listkhachhang";
    }
    
    @GetMapping("/searchkhachhang")
    public String searchPersons(@RequestParam("theSearchName") String theSearchName,
            Model theModel) {
        // search customers from the service
        List<KhachHang> theKhachhangs = adminService.searchKhachhangs(theSearchName);

        // add the customers to the model
        theModel.addAttribute("khachhangs", theKhachhangs);
        return "giaodienquanlytaikhoan";
    }
    
}
