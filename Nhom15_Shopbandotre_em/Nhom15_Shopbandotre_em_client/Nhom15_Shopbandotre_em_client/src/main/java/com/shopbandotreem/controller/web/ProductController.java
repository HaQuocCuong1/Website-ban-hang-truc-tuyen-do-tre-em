/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopbandotreem.controller.web;

import com.shopbandotreem.entity.Categories;
import com.shopbandotreem.entity.Product;
import com.shopbandotreem.services.CategoriesService;
import com.shopbandotreem.services.ProductService;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ASUS
 */
@Controller
@RequestMapping("/admin/quanlisanpham")
@MultipartConfig
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoriesService categoriesService;
    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute("productAttribute") Product theProducts, HttpServletRequest request, 
            @RequestParam("categoriesId") int categoriesId ,@RequestParam(value = "image", required = false) MultipartFile file) {
        // save the photo using our service
//        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
//        Path path = Paths.get(rootDirectory + fileDirectory + file.getOriginalFilename());
//        try {
//            file.transferTo(new File(path.toString()));
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new RuntimeException("File saving failed", e);
//        }
        theProducts.setThumbnail(saveFile(file));
        productService.saveProducts(theProducts, categoriesId);
        return "redirect:/admin/quanlisanpham/list?categoriesId="+categoriesId;
    }
    @PostMapping("/updateProduct")
    public String updateProduct(@ModelAttribute("productAttribute") Product theProducts,
            @RequestParam("categoriesId") int categoriesId)
    {
        // save the customer using our service
        productService.updateProducts(theProducts, categoriesId);	
        return "redirect:/admin/quanlisanpham/list?categoriesId="+categoriesId;
    }
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel, @RequestParam("categoriesId") int categoriesId) {
        // create model attribute to bind form data
        Product theProducts = new Product();
        theModel.addAttribute("productAttribute", theProducts);
        theModel.addAttribute("categoriesId", categoriesId);
        theModel.addAttribute("isUpdate", false);
        return "product-form";    }
    @GetMapping("/showFormForUpdate")
   public String showFormForUpdate( @RequestParam("categoriesId") int categoriesId,
           @RequestParam("productId") int productId,
           Model theModel) {
        // get the creditcard from our service
        Product theProducts = productService.getProducts(productId);
        // set creditcard as a model attribute to pre-populate the form
        theModel.addAttribute("productAttribute", theProducts);
         theModel.addAttribute("categoriesId", categoriesId);
        theModel.addAttribute("isUpdate", true);
        
        
        // send over to our form		
        return "product-form";    }  
      @GetMapping("/delete")
    public String deleteProduct(@RequestParam("categoriesId") int categoriesId, @RequestParam("productId") int productId) {

           
            productService.deleteProducts(productId);

            return "redirect:/admin/quanlisanpham/list?categoriesId="+categoriesId;
    }
    @GetMapping("/list")
    public String listCategories(@RequestParam("categoriesId") int categoriesId,Model theModel) {
        // get persons from the service
        Categories theCategories = categoriesService.getCategories(categoriesId);
        theModel.addAttribute("categories", theCategories);
        return "product-list"; 
    }
    private String saveFile(MultipartFile file)
    {
        String name = null;
        if (file != null && !file.isEmpty())
        {
            try {
                byte[] bytes =  file.getBytes();
                //String rootPath = System.getProperty("catalina.home");
                //File dir = new File(rootPath+File.separator+"/resources/img");
                File dir = new File("F:\\BaitaplonWWW_Quanlibandotreem\\Nhom15_Shopbandotre_em\\Nhom15_Shopbandotre_em_client\\Nhom15_Shopbandotre_em_client\\src\\main\\webapp\\resources\\img");
                if ( !dir.exists())
                {
                    dir.mkdir();
                }
                name = String.valueOf(new Date().getTime()+".jpg");
                File serverFile = new File(dir.getAbsoluteFile()+File.separator+name);
                System.out.println("=======Path img on server: "+ serverFile.getPath());
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();
            } catch (IOException ex) {
                System.out.println("======= Error Upload File: "+ ex.getMessage());
                
            }
            
        }else {
            System.out.println("======= File not Exists ");
        }
        return name;
    }
//    @GetMapping("/upfile")
//    public String showProduct()
//    {
//        return "uploadfile";
//    }
}
