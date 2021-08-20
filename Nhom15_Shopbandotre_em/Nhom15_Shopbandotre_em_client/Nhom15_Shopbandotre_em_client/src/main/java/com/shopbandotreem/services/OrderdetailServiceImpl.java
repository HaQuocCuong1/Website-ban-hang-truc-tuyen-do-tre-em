/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopbandotreem.services;

import com.shopbandotreem.entity.OrderDetails;
import com.shopbandotreem.entity.Orders;
import com.shopbandotreem.entity.Product;
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
public class OrderdetailServiceImpl implements OrderdetaiService{
    private RestTemplate restTemplate;
    private String crmRestUrl;

    public OrderdetailServiceImpl(RestTemplate theRestTemplate, @Value("${orderdetails.rest.url}") String theUrl) {
        restTemplate = theRestTemplate;
        crmRestUrl = theUrl;
    }
    
    @Override
    public OrderDetails getOrderDetails(int orderdetailId) {
        OrderDetails theOrderDetails = 
        restTemplate.getForObject(crmRestUrl + "/" + orderdetailId, 
                                  OrderDetails.class);
        return theOrderDetails;
    }

    @Override
    public List<OrderDetails> getlistOrderDetails(int orderId) {
        ResponseEntity<List<OrderDetails>> responseEntity = 
        restTemplate.exchange(crmRestUrl+"/orders/"+orderId, HttpMethod.GET, null, 
        new ParameterizedTypeReference<List<OrderDetails>>() {});
        // get the list of customers from response
        List<OrderDetails> orderDetails = responseEntity.getBody();
        return orderDetails;
    }

    @Override
    public Orders getOrders(int orderId) {
        Orders theOrders = 
        restTemplate.getForObject(crmRestUrl + "/" + orderId, 
                                  Orders.class);
        return theOrders;
    }

    @Override
    public Product getProduct(int productsId) {
        Product theProducts = 
        restTemplate.getForObject(crmRestUrl + "/" + productsId, 
                                  Product.class);
        return theProducts;
    }

    @Override
    public void saveOrderDetails(OrderDetails theOrderDetails, int orderId, int productsId) {
        restTemplate.postForEntity(crmRestUrl+"/orders/"+orderId+"/product/"+productsId, theOrderDetails, String.class);
    }

    @Override
    public void deleteOrderDetails(int orderDetails) {
        restTemplate.delete(crmRestUrl + "/" + orderDetails);
    }

    @Override
    public void updateOrderDetails(OrderDetails theOrderDetails, int orderId) {
       restTemplate.put(crmRestUrl+"/orders/"+orderId, theOrderDetails);
    }
}
