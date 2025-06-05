package com.nisum.dao;

import com.nisum.model.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class InitialCartItemDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public InitialCartItemDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<CartItem> getAllInitialCartItems() {

        return null;
    }


    private static class CartItemRowMapper implements RowMapper<CartItem> {
        @Override
        public CartItem mapRow(ResultSet rs, int rowNum) throws SQLException {
            CartItem cartItem = new CartItem();
            cartItem.setCartItemID(rs.getInt("CartItemID"));
            cartItem.setCartID(rs.getInt("CartID"));
            cartItem.setProductID(rs.getInt("ProductID"));
            cartItem.setSku(rs.getString("SKU"));
            cartItem.setQuantity(rs.getInt("Quantity"));
            cartItem.setUnitPrice(rs.getDouble("UnitPrice"));
            cartItem.setDiscount(rs.getDouble("Discount"));
            cartItem.setFinalPrice(rs.getDouble("FinalPrice"));
            return cartItem;
        }
    }

    public void addItems(CartItem cartItem) {
        String query = "INSERT INTO InitialCartItems (CartItemID, CartID, ProductID, SKU, Quantity, UnitPrice, Discount, FinalPrice) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(query,
                cartItem.getCartItemID(),
                cartItem.getCartID(),
                cartItem.getProductID(),
                cartItem.getSku(),
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

    public List<CartItem> getAllCartItems() {
        String query = "SELECT * FROM InitialCartItems";
        return jdbcTemplate.query(query, new CartItemRowMapper());
    }

    public void updateCartItem(CartItem cartItem) {
        String query = "UPDATE InitialCartItems SET CartID = ?, ProductID = ?, SKU = ?, Quantity = ?, UnitPrice = ?, Discount = ?, FinalPrice = ? WHERE CartItemID = ?";
        jdbcTemplate.update(query,
                cartItem.getCartID(),
                cartItem.getProductID(),
                cartItem.getSku(),
                cartItem.getQuantity(),
                cartItem.getUnitPrice(),
                cartItem.getDiscount(),
                cartItem.getFinalPrice(),
                cartItem.getCartItemID());
    }

    public void deleteCartItem(Integer cartItemID) {
        String query = "DELETE FROM InitialCartItems WHERE CartItemID = ?";
        jdbcTemplate.update(query, cartItemID);
    }

    public void deleteCartItembyCartID(Integer cartID) {
        String query = "DELETE FROM InitialCartItems WHERE CartID = ?";
        jdbcTemplate.update(query, cartID);
    }
}
