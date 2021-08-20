/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopbandotreem.services;

import com.shopbandotreem.entity.KhachHang;
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
public class AdminServiceImpl implements AdminService{
    private RestTemplate restTemplate;
    private String crmRestUrl;

    public AdminServiceImpl(RestTemplate theRestTemplate, @Value("${customer.rest.url}") String theUrl) {
        restTemplate = theRestTemplate;
        crmRestUrl = theUrl;
    }
    
    @Override
    public List<KhachHang> getKhachHangs() {
       ResponseEntity<List<KhachHang>> responseEntity = 
       restTemplate.exchange(crmRestUrl, HttpMethod.GET, null, 
       new ParameterizedTypeReference<List<KhachHang>>() {});
       // get the list of customers from response
       List<KhachHang> khachHangs = responseEntity.getBody();
       return khachHangs;
   }
     
    @Override
     public List<KhachHang> getKhachHangs(int theSortField) {
        ResponseEntity<List<KhachHang>> responseEntity = 
       restTemplate.exchange(crmRestUrl+"/sort/"+theSortField, HttpMethod.GET, null, 
       new ParameterizedTypeReference<List<KhachHang>>() {});
       // get the list of customers from response
       List<KhachHang> khachHangs = responseEntity.getBody();
       return khachHangs;
    }
     
     @Override
     public void deleteKhachhang(String makh) {
         restTemplate.delete(crmRestUrl + "/" + makh);
    }
     
    @Override
     public List<KhachHang> searchKhachhangs(String theSearchName) {
        ResponseEntity<List<KhachHang>> responseEntity = 
       restTemplate.exchange(crmRestUrl+"/search/"+theSearchName, HttpMethod.GET, null, 
       new ParameterizedTypeReference<List<KhachHang>>() {});
       // get the list of customers from response
       List<KhachHang> khachHangs = responseEntity.getBody();
       return khachHangs;
    }
}
