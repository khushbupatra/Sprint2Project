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

        for (CartItem item : items) {
            Product product = productDAO.getProductById(item.getProductId());
            item.setProduct(product);
        }

        return items;
    }
    public void addItemToCart(int cartId, int productId, int quantity) {
        CartItem existingItem = cartItemDAO.findCartItemByProduct(cartId, productId);
        if (existingItem != null) {
            cartItemDAO.updateCartItemQuantity(existingItem.getCartItemId(), existingItem.getQuantity() + quantity);
        } else {
            CartItem newItem = new CartItem();
            newItem.setCartId(cartId);
            newItem.setProductId(productId);
            newItem.setQuantity(quantity);
            cartItemDAO.addItems(newItem);
        }
    }
    public void updateItemQuantity(int cartItemId, int quantity) {
        cartItemDAO.updateCartItemQuantity(cartItemId, quantity);
    }

    public void removeItemFromCart(int cartItemId) {
        cartItemDAO.deleteCartItem(cartItemId);
    }

    public void clearCart() {
        cartItemDAO.clearCart();
    }

    public double calculateCartTotal(int cartId) {
        List<CartItem> items = getCartItems(cartId);
        return items.stream()
                .mapToDouble(item -> {
                    Product product = item.getProduct();
                    if (product != null && product.getPrice() != 0.0 && item.getQuantity() != null) {
                        return product.getPrice() * item.getQuantity();
                    }
                    return 0.0;
                })
                .sum();
    }

    public List<CartItem> getCartItemList() {
        return cartItemDAO.getAllCartItems();
    }
}
