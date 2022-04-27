package com.ecommerce.project.laptop.services;

import com.ecommerce.project.laptop.entitty.ShoppingCart;
import com.ecommerce.project.laptop.reponsitory.ShoppingReponsirory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingReponsirory shopResp;
    @Override
    public List<ShoppingCart> getALlShoppingCart() {
        return shopResp.findAll();
    }

    @Override
    public ShoppingCart getShoppingCartById(long id) {
        return shopResp.findById(id).orElse(null);
    }

    @Override
    public boolean deleteById(long id) {
        if(shopResp.existsById(id)){
            shopResp.deleteById(id);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public ShoppingCart saveShoppingCart(ShoppingCart shoppingCart) {
        return shopResp.save(shoppingCart);
    }

    @Override
    public ShoppingCart updateShoppingCart(ShoppingCart shoppingCart) {
        return null;
    }
}
