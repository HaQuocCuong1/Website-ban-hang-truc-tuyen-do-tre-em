/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopbandotreem.config;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
/**
 *
 * @author MPH
 */
@Configuration
// Cung cấp hỗ trợ tương tự như <mvc: annotation-driven /> trong XML
@EnableWebMvc
@ComponentScan("com.shopbandotreem")
@PropertySource({"classpath:security-persistence-mssql.properties","classpath:application.properties" })
public class AppConfig implements WebMvcConfigurer{
   @Autowired
    private Environment env;
    private Logger logger = Logger.getLogger(getClass().getName());
    // định nghĩa 1 bean cho ViewResolver
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry
      .addResourceHandler("/resources/**")
      .addResourceLocations("/resources/"); 
    }
    
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new 
        InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;}
    private Properties getHibernateProperties() {

            // set hibernate properties
            Properties props = new Properties();

            props.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
            props.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));

            return props;				
    }

    // define a bean for our security datasource

    @Bean
    public DataSource securityDataSource() {

        // create connection pool
        ComboPooledDataSource securityDataSource = new ComboPooledDataSource();
        // set the jdbc driver class
        try {
                securityDataSource.setDriverClass(env.getProperty("security.jdbc.driver"));
        } catch (PropertyVetoException exc) {
                throw new RuntimeException(exc);
        }
        // log the connection props
        // for sanity's sake, log this info
        // just to make sure we are REALLY reading data from properties file
        logger.info(">>> security.jdbc.url=" + env.getProperty("security.jdbc.url"));
        logger.info(">>> security.jdbc.user=" + env.getProperty("security.jdbc.user"));
        // set database connection props
        securityDataSource.setJdbcUrl(env.getProperty("security.jdbc.url"));
        securityDataSource.setUser(env.getProperty("security.jdbc.user"));
        securityDataSource.setPassword(env.getProperty("security.jdbc.password"));
        // set connection pool props
        securityDataSource.setInitialPoolSize(
                        getIntProperty("security.connection.pool.initialPoolSize"));
        
        securityDataSource.setMinPoolSize(
                        getIntProperty("security.connection.pool.minPoolSize"));

        securityDataSource.setMaxPoolSize(
                        getIntProperty("security.connection.pool.maxPoolSize"));

        securityDataSource.setMaxIdleTime(
                        getIntProperty("security.connection.pool.maxIdleTime"));

        return securityDataSource;
    }
    
    // need a helper method 
    // read environment property and convert to int
private int getIntProperty(String propName) {
    String propVal = env.getProperty(propName);
    // now convert to int
    int intPropVal = Integer.parseInt(propVal);
    return intPropVal;
}

    @Bean
    public RestTemplate restTemplate() {
            return new RestTemplate();
    }
    @Bean(name="multipartResolver")
    public CommonsMultipartResolver getResolver() {
        CommonsMultipartResolver resover = new CommonsMultipartResolver();
        resover.setMaxUploadSizePerFile(1500000);
        return resover;
    }
}
