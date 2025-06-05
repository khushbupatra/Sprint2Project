package com.nisum.service;

import com.nisum.dao.CartItemDAO;
import com.nisum.model.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ShoppingCartService {

    @Autowired
    private CartItemDAO cartItemDAO;

    public List<CartItem> getCartItemList() {
        return cartItemDAO.getAllCartItems();
    }

    public void clearCart() {
        cartItemDAO.clearCart();
    }
}