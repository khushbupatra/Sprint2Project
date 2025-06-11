package com.nisum.dao;

import com.nisum.model.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CartItemDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CartItemDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addItems(CartItem cartItem) {
        String sql = "INSERT INTO cart_items (cart_id, product_id, quantity) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql,
                cartItem.getCartId(),
                cartItem.getProductId(),
                cartItem.getQuantity());
    }

    public List<CartItem> getAllCartItems() {
        String sql = "SELECT cart_item_id AS cartItemId, cart_id AS cartId, product_id AS productId, quantity FROM cart_items";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(CartItem.class));
    }

    public List<CartItem> getCartItemsByCartID(int cartId) {
        String sql = "SELECT cart_item_id AS cartItemId, cart_id AS cartId, product_id AS productId, quantity FROM cart_items WHERE cart_id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(CartItem.class), cartId);
    }

    public CartItem findCartItemByProduct(int cartId, int productId) {
        String sql = "SELECT cart_item_id AS cartItemId, cart_id AS cartId, product_id AS productId, quantity FROM cart_items WHERE cart_id = ? AND product_id = ?";
        List<CartItem> items = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(CartItem.class), cartId, productId);
        return items.isEmpty() ? null : items.get(0);
    }

    public void updateCartItemQuantity(Integer cartItemID, int quantity) {
        String sql = "UPDATE cart_items SET quantity = ? WHERE cart_item_id = ?";
        jdbcTemplate.update(sql, quantity, cartItemID);
    }

    public void deleteCartItem(int cartItemId) {
        String sql = "DELETE FROM cart_items WHERE cart_item_id = ?";
        jdbcTemplate.update(sql, cartItemId);
    }

    public void deleteCartItembyCartID(Object cartId) {
        String sql = "DELETE FROM cart_items WHERE cart_id = ?";
        jdbcTemplate.update(sql, cartId);
    }

    public void clearCart() {
        String sql = "DELETE FROM cart_items";
        jdbcTemplate.update(sql);
    }
}
