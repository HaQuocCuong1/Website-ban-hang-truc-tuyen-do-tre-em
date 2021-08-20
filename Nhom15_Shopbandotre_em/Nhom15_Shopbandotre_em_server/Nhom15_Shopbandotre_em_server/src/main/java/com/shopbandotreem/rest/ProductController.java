/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopbandotreem.rest;

import com.shopbandotreem.entity.Categories;
import com.shopbandotreem.entity.OrderDetails;
import com.shopbandotreem.entity.Product;
import com.shopbandotreem.services.OrderdetaiService;
import com.shopbandotreem.services.ProductService;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;

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
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ASUS
 */
@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderdetaiService orderdetaiService;
    @PostMapping("/products/categories/{categoriesId}")
    public Product saveProduct(@RequestBody Product theProducts, 
            @PathVariable int categoriesId) {
        theProducts.setId(0);
        List<OrderDetails> lisOrderDetails = orderdetaiService.getlistOrderDetails(theProducts.getId());
        theProducts.setOrderDetails(lisOrderDetails);
        productService.saveProducts(theProducts, categoriesId);
        return theProducts;
    }
    @PutMapping("/products/categories/{categoriesId}")
    public Product updateProduct(@RequestBody Product theProducts,
            @PathVariable int categoriesId)
    {
        // save the customer using our service
        productService.updateProducts(theProducts, categoriesId);	
        return theProducts;
    } 
    @DeleteMapping("/products/{productId}")
    public String deleteProduct(@PathVariable int productId) {

           
            productService.deleteProducts(productId);

            return "Deleted product id - " + productId;
    }
    @GetMapping("/products")
    public List<Product> listproduct() {
        // get persons from the service
        List<Product> listproduct = productService.getlistProducts();
        return listproduct; 
    }
    @GetMapping("/products/categories/{categorieId}")
    public List<Product> listproductForCategori(@PathVariable int categorieId) {
        // get persons from the service
        List<Product> listproduct = productService.getlistProductsForcategori(categorieId);
        return listproduct; 
    }
    @GetMapping("/products/{productId}")
    public Product getproduct(@PathVariable int productId) {
        // get persons from the service
        Product theproduct = productService.getProducts(productId);
        if (theproduct == null)
            {
                throw new NotFoundException("products not found - "+ productId);
            }
        return theproduct; 
    }
    @GetMapping("/products/{productId}/categories/{categoriesId}")
    public Product getproductForcategori(@PathVariable int productId, @PathVariable int categoriesId) {
        // get persons from the service
        Categories categories = productService.getCategories(categoriesId);
        Product theproduct = categories.getProduct(productId);
        if (theproduct == null)
            {
                throw new NotFoundException("products not found - "+ productId);
            }
        return theproduct; 
    }
}
