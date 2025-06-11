package com.nisum.dao;

import com.nisum.model.CartItem;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class InitialCartItemDAO {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<CartItem> getAllInitialCartItems() {
        String query = "SELECT * FROM InitialCartItems";
        return jdbcTemplate.query(query, new CartItemRowMapper());
    }

    public void addItems(CartItem cartItem) {
        String query = "INSERT INTO InitialCartItems (CartItemID, CartID, ProductID, Quantity, UnitPrice, Discount, FinalPrice) VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(query,
                cartItem.getCartItemId(),
                cartItem.getCartId(),
                cartItem.getProductId(),
                cartItem.getQuantity(),
                cartItem.getUnitPrice(),
                cartItem.getDiscount(),
                cartItem.getFinalPrice());
    }

    public CartItem getCartItemByCartItemID(Integer id) {
        String query = "SELECT * FROM InitialCartItems WHERE CartItemID = ?";
        List<CartItem> items = jdbcTemplate.query(query, new CartItemRowMapper(), id);
        return items.isEmpty() ? null : items.get(0);
    }

    public List<CartItem> getCartItemsByCartID(Integer id) {
        String query = "SELECT * FROM InitialCartItems WHERE CartID = ?";
        return jdbcTemplate.query(query, new CartItemRowMapper(), id);
    }

    public void updateCartItem(CartItem cartItem) {
        String query = "UPDATE InitialCartItems SET CartID = ?, ProductID = ?, Quantity = ?, UnitPrice = ?, Discount = ?, FinalPrice = ? WHERE CartItemID = ?";
        jdbcTemplate.update(query,
                cartItem.getCartId(),
                cartItem.getProductId(),
                cartItem.getQuantity(),
                cartItem.getUnitPrice(),
                cartItem.getDiscount(),
                cartItem.getFinalPrice(),
                cartItem.getCartItemId());
    }

    public void deleteCartItem(Integer cartItemID) {
        String query = "DELETE FROM InitialCartItems WHERE CartItemID = ?";
        jdbcTemplate.update(query, cartItemID);
    }

    public void deleteCartItembyCartID(Integer cartID) {
        String query = "DELETE FROM InitialCartItems WHERE CartID = ?";
        jdbcTemplate.update(query, cartID);
    }

    public void clearCart() {
        String query = "TRUNCATE TABLE InitialCartItems";
        jdbcTemplate.execute(query);
    }

    private static class CartItemRowMapper implements RowMapper<CartItem> {
        @Override
        public CartItem mapRow(ResultSet rs, int rowNum) throws SQLException {
            CartItem cartItem = new CartItem();
            cartItem.setCartItemId(rs.getInt("CartItemID"));
            cartItem.setCartId(rs.getInt("CartID"));
            cartItem.setProductId(rs.getInt("ProductID"));
            cartItem.setQuantity(rs.getInt("Quantity"));
            cartItem.setUnitPrice(rs.getDouble("UnitPrice"));
            cartItem.setDiscount(rs.getDouble("Discount"));
            cartItem.setFinalPrice(rs.getDouble("FinalPrice"));
            return cartItem;
        }
    }
}
