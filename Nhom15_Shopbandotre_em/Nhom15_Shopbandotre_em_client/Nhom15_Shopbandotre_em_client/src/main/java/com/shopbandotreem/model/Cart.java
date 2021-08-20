/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopbandotreem.model;

import com.shopbandotreem.entity.Product;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class Cart {
    private final List<CartItem> items;
    private float total;

    public Cart() {
        items = new ArrayList<CartItem>();
        total = 0;
    }
    public CartItem getItem(Product p)
    {
        for (CartItem item : items)
        {
            if (item.getProduct().getId() == p.getId())
            {
                return item;
            }
        }
        return null;
    }
    public List<CartItem> getItems()
    {
        return items;
    }
    public int getItemCount()
    {
        return items.size();
    }
    //Them 1 item
    public void addItem(CartItem item)
    {
        addItem(item.getProduct(), item.getQuantity());
    }
    public void updateItem(Product p, int quan)
    {
        CartItem item = getItem(p);
        if (item != null)
        {
            item.setQuantity(quan);
        }
    }
    // Them 1 Item co so luong cho truoc
    public void addItem(Product p, int quantity)
    {
        CartItem item = getItem(p);
        if (item != null)
        {
            item.setQuantity(item.getQuantity()+quantity);//so luong cu + so luong moi
        }else {//chua ton tai san pham
            item = new CartItem(p);
            item.setQuantity(quantity);
            items.add(item);
        }
    }
    public void removeItem(Product p)
    {
        CartItem item = getItem(p);
        if (item != null)
        {
            items.remove(item);
        }
    }
    //Xoa toan bo gio hang
    public void clear()
    {
        items.clear();
        total = 0;
    }
    //kiem tra rong
    public boolean isEmty()
    {
        return items.isEmpty();
    }
    //Lay tong tien
    public float getTotal()
    {
        total = 0;
        for ( CartItem item : items)
        {
            total += item.getSubTotal();
        }
        return total;
    }
}
