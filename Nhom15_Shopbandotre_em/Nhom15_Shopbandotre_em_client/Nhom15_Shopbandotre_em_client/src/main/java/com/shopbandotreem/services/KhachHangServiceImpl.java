/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopbandotreem.services;

import com.shopbandotreem.entity.KhachHang;
import com.shopbandotreem.entity.Orders;
import com.shopbandotreem.user.CrmUser;
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
 * @author Dell_Latitude_7480
 */
@Service
public class KhachHangServiceImpl implements KhachHangService{
    private RestTemplate restTemplate;
    private String crmRestUrl;

    public KhachHangServiceImpl(RestTemplate theRestTemplate, @Value("${customer.rest.url}") String theUrl) {
        restTemplate = theRestTemplate;
        crmRestUrl = theUrl;
    }
    
    
    @Override
    public void savekhachhang(KhachHang khachhang){
        restTemplate.postForEntity(crmRestUrl, khachhang, String.class);			
    }
    
    @Override
     public List<KhachHang> getTaiKhoans() {
        ResponseEntity<List<KhachHang>> responseEntity = 
        restTemplate.exchange(crmRestUrl, HttpMethod.GET, null, 
        new ParameterizedTypeReference<List<KhachHang>>() {});
        // get the list of customers from response
        List<KhachHang> khachhangs = responseEntity.getBody();
        return khachhangs;
    }
     
    @Override
     public KhachHang getKhachHang(String makh) {
        KhachHang theKhachHang = 
        restTemplate.getForObject(crmRestUrl + "/" + makh, 
                                  KhachHang.class);
        return theKhachHang;
    }

    @Override
    public List<Orders> getOrders(String makh) {
        ResponseEntity<List<Orders>> responseEntity = 
        restTemplate.exchange(crmRestUrl+"/"+makh+"/orders", HttpMethod.GET, null, 
        new ParameterizedTypeReference<List<Orders>>() {});
        // get the list of customers from response
        List<Orders> categories = responseEntity.getBody();
        return categories;
    }

    @Override
    public Orders getOrders(String khachhangId, int orderId) {
        Orders theOrders = 
        restTemplate.getForObject(crmRestUrl + "/" + khachhangId+ "/orders/"+orderId, 
                                  Orders.class);
        return theOrders;
    }

}
