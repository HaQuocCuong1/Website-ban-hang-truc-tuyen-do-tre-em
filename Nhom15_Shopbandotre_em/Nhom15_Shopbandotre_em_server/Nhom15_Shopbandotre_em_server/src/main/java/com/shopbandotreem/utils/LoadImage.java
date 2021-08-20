/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopbandotreem.utils;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.nio.file.Files;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ASUS
 */
@WebServlet(urlPatterns = {"/image/*"})
public class LoadImage extends HttpServlet {
    private String imagePath;

    @Override
    public void init() throws ServletException {
        //imagePath = System.getProperty("catalina.home")+File.separator+"assets/user/img";
        imagePath = "G:\\Web\\LaptrinhWWW_Shopbandotreem\\BaitaplonWWW_Quanlibandotreem\\Nhom15_Shopbandotre_em\\Nhom15_Shopbandotre_em_client\\Nhom15_Shopbandotre_em_client\\src\\main\\webapp\\resources\\img";
    }
    

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String requestedImage = request.getPathInfo();
        if (requestedImage == null)
        {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        File image = new File(imagePath, URLDecoder.decode(requestedImage,"UTF-8"));
        //kiem tra file co ton  khong
        if (!image.exists())
        {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
         //Get content type filename
         String contentType = getServletContext().getMimeType(image.getName());
         //check file co thuc su la anh ko
         if (contentType == null || !contentType.startsWith("image")){
             response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
         }
         response.reset();
         response.setContentType(contentType);
         response.setHeader("Content-Length", String.valueOf(image.length()));
         Files.copy(image.toPath(), response.getOutputStream());
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
    }
  

}
