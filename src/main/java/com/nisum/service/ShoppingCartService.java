package com.nisum.service;

import com.nisum.dao.CartItemDAO;
import com.nisum.dao.ProductDAO;
import com.nisum.model.CartItem;
import com.nisum.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class ShoppingCartService {

    @Autowired
    private CartItemDAO cartItemDAO;

    @Autowired
    private ProductDAO productDAO;

    public List<CartItem> getCartItems(int cartId) {
        List<CartItem> items = cartItemDAO.getCartItemsByCartID(cartId);
        // Populate product details for each cart item
        items.forEach(item -> {
            Product product = productDAO.getProductById(item.getProductID());
            item.setProduct(product);
        });
        return items;
    }

    public void addItemToCart(int cartId, int productId, int quantity) {
        // Check if product already exists in cart
        CartItem existingItem = cartItemDAO.findCartItemByProduct(cartId, productId);
        if (existingItem != null) {
            // Update quantity if item exists
            cartItemDAO.updateCartItemQuantity(existingItem.getCartItemID(),
                    existingItem.getQuantity() + quantity);
        } else {
            // Add new item if it doesn't exist
            Product product = productDAO.getProductById(productId);
            CartItem newItem = new CartItem();
            newItem.setCartID(cartId);
            newItem.setProductID(productId);
            newItem.setQuantity(quantity);
            newItem.setUnitPrice(product.getPrice());
            // You might want to calculate discount and final price here
            newItem.setFinalPrice(product.getPrice() * quantity);
            cartItemDAO.addItemToCart(newItem);
        }
    }

    public void updateItemQuantity(int cartItemId, int quantity) {
        cartItemDAO.updateCartItemQuantity(cartItemId, quantity);
    }

    public void removeItemFromCart(int cartItemId) {
        cartItemDAO.deleteCartItem(cartItemId);
    }

    public void clearCart(int cartId) {
        cartItemDAO.deleteCartItembyCartID(cartId);
    }

    public double calculateCartTotal(int cartId) {
        List<CartItem> items = getCartItems(cartId);
        return items.stream()
                .mapToDouble(item -> item.getFinalPrice())
                .sum();
    }
}