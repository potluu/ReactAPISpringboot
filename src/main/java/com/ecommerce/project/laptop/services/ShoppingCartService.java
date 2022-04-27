package com.ecommerce.project.laptop.services;


import com.ecommerce.project.laptop.entitty.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {
    public List<ShoppingCart> getALlShoppingCart();

    public ShoppingCart getShoppingCartById(long id);

    public boolean deleteById(long id);

    public ShoppingCart saveShoppingCart(ShoppingCart ShoppingCart);

    public ShoppingCart updateShoppingCart(ShoppingCart ShoppingCart);

}
