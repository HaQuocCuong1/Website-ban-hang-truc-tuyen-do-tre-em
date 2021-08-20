/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopbandotreem.services;

import com.shopbandotreem.entity.KhachHang;
import com.shopbandotreem.entity.Orders;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author ASUS
 */
@Service
public class OrdersServiceImpl implements OrdersService{
    private RestTemplate restTemplate;
    private String crmRestUrl;

    public OrdersServiceImpl(RestTemplate theRestTemplate, @Value("${orders.rest.url}") String theUrl) {
        restTemplate = theRestTemplate;
        crmRestUrl = theUrl;
    }
    
    
    
    @Override
    public Orders getOrders(int orderId) {
        Orders theOrders = 
        restTemplate.getForObject(crmRestUrl + "/" + orderId, 
                                  Orders.class);
        return theOrders;
    }

    @Override
    public List<Orders> getOrders() {
        ResponseEntity<List<Orders>> responseEntity = 
        restTemplate.exchange(crmRestUrl, HttpMethod.GET, null, 
        new ParameterizedTypeReference<List<Orders>>() {});
        // get the list of customers from response
        List<Orders> orders = responseEntity.getBody();
        return orders;
    }

    @Override
    public KhachHang getKhachhang(String makh) {
        KhachHang theKhachHang = 
        restTemplate.getForObject(crmRestUrl + "/" + makh, 
                                  KhachHang.class);
        return theKhachHang;
    }

    @Override
    public void saveOrders(Orders theOrders, String makh) {
        restTemplate.postForEntity(crmRestUrl+"/khachhangs/"+makh, theOrders, String.class);
    }

    @Override
    @Transactional
    public void deleteOrders(int orderId) {
        restTemplate.delete(crmRestUrl + "/" + orderId);
    }
    
}
