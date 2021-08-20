/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopbandotreem.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

/**
 *
 * @author MPH
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // add a reference to our security data source
    @Autowired
    private DataSource securityDataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        // use jdbc authentication ... oh yeah!!!
        auth.jdbcAuthentication().dataSource(securityDataSource);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

//** matches zero or more 'directories' in a path
        http.authorizeRequests()
                //* matches zero or more characters
                .antMatchers("/resources/css/**").permitAll()
                .antMatchers("/resources/bootstrap/**").permitAll()
                .antMatchers("/resources/jquery/**").permitAll()
                .antMatchers("/resources/fonts/**").permitAll()
                .antMatchers("/resources/js/register").permitAll()
                
                .antMatchers("/trangchu").permitAll()
                .antMatchers("/admin/**").hasAnyRole("ADMIN")
                .antMatchers("/payment/form").hasAnyRole("ADMIN", "EMPLOYEE")
                .antMatchers("/hoadon/add").hasAnyRole("ADMIN", "EMPLOYEE")
                .antMatchers("/admin/listkhachhang").hasAnyRole("MANAGER", "ADMIN")
                .antMatchers("/admin/searchkhachhang*").hasAnyRole("MANAGER", "ADMIN")
                .antMatchers("/taikhoan/showFormdangkytaikhoan").permitAll()
                .antMatchers("/taikhoan/dangkytaikhoan").permitAll()
                .antMatchers("/taikhoan/suathongtintaikhoan*").hasAnyRole("EMPLOYEE", "MANAGER", "ADMIN")
                .antMatchers("/taikhoan/savesuathongtinkhachhang*").hasAnyRole("EMPLOYEE", "MANAGER", "ADMIN")
                .antMatchers("/taikhoan/savesuapassword*").hasAnyRole("EMPLOYEE", "MANAGER", "ADMIN")
                //** matches zero or more 'directories' in a path
                //        .antMatchers("/taikhoan/**").hasRole("EMPLOYEE")
                //.anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/showMyLoginPage")
                .loginProcessingUrl("/authenticateTheUser")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/trangchu")
                .permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/access-denied");

    }

    @Bean
    public UserDetailsManager userDetailsManager() {

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();

        jdbcUserDetailsManager.setDataSource(securityDataSource);

        return jdbcUserDetailsManager;
    }
}
