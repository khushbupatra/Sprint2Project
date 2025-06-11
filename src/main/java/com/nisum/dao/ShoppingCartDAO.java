package com.nisum.dao;

import com.nisum.model.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ShoppingCartDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ShoppingCartDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addShoppingCart(ShoppingCart shoppingCart) {
        String sql = "INSERT INTO ShoppingCart VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                shoppingCart.getCartID(),
                shoppingCart.getUserId(),
                shoppingCart.getCartTotal(),
                new java.sql.Date(shoppingCart.getCreatedDate().getTime()),
                new java.sql.Date(shoppingCart.getLastUpdatedDate().getTime())
        );
    }

    public ShoppingCart getShoppingCartByCartID(Integer id) {
        String sql = "SELECT * FROM ShoppingCart WHERE CartID = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new ShoppingCartRowMapper());
    }

    public ShoppingCart getShoppingCartByUserID(Integer id) {
        String sql = "SELECT * FROM ShoppingCart WHERE UserID = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new ShoppingCartRowMapper());
    }

    public List<ShoppingCart> getAllShoppingCart() {
        String sql = "SELECT * FROM ShoppingCart";
        return jdbcTemplate.query(sql, new ShoppingCartRowMapper());
    }

    public void updateShoppingCart(ShoppingCart shoppingCart) {
        String sql = "UPDATE ShoppingCart SET UserID = ?, CartTotal = ?, CreatedDate = ?, LastUpdatedDate = ? WHERE CartID = ?";
        jdbcTemplate.update(sql,
                shoppingCart.getUserId(),
                shoppingCart.getCartTotal(),
                new java.sql.Date(shoppingCart.getCreatedDate().getTime()),
                new java.sql.Date(shoppingCart.getLastUpdatedDate().getTime()),
                shoppingCart.getCartID());
    }

    public void deleteShoppingCart(Integer cartID) {
        String sql = "DELETE FROM ShoppingCart WHERE CartID = ?";
        jdbcTemplate.update(sql, cartID);
    }

    public void deleteCartItemByUserID(Integer userID) {
        String sql = "DELETE FROM ShoppingCart WHERE UserID = ?";
        jdbcTemplate.update(sql, userID);
    }

    public void deleteAllShoppingCartItems() {
        String sql = "TRUNCATE TABLE ShoppingCart";
        jdbcTemplate.execute(sql);
    }

    private static class ShoppingCartRowMapper implements RowMapper<ShoppingCart> {
        @Override
        public ShoppingCart mapRow(ResultSet rs, int rowNum) throws SQLException {
            ShoppingCart cart = new ShoppingCart();
            cart.setCartID(rs.getInt("CartID"));
            cart.setUserId(rs.getInt("UserID"));
            cart.setCartTotal(rs.getDouble("CartTotal"));
            cart.setCreatedDate(rs.getDate("CreatedDate"));
            cart.setLastUpdatedDate(rs.getDate("LastUpdatedDate"));
            return cart;
        }
    }
}
