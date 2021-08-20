/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopbandotreem.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 *
 * @author MPH
 */
//Bộ khởi tạo Servlet Spring Mvc Dispatcher 
public class MySpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{
     @Override
    protected Class<?>[] getRootConfigClasses() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return null;
        }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          return  new Class[]{
              AppConfig.class
          };
    }

    @Override
    protected String[] getServletMappings() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           return new String[]{"/"};
    }
}
