/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopbandotreem.model;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class CartManager {
    private static final String SESSION_KEY_SHOPING_CART = "gioHang";
    //Phuong thuc lay ve gio hang
    public Cart getCart(HttpSession session)
    {
        Cart cart = (Cart) session.getAttribute(SESSION_KEY_SHOPING_CART);
        if (cart == null)//neu gio hang null
        {
            cart = new Cart();//tao moi
            setCart(session, cart);// thiet lap gio hang
        }
        return cart;
    }
    //Thiet lap 1 gio hang
    public void setCart(HttpSession session, Cart cart)
    {
        session.setAttribute(SESSION_KEY_SHOPING_CART, cart);
    }
    public void removeCart(HttpSession session)
    {
        session.removeAttribute(SESSION_KEY_SHOPING_CART);
    }
}
