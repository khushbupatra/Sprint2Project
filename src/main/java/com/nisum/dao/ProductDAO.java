package com.nisum.dao;

import com.nisum.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class ProductDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Product getProductById(int productId) {
        String sql = "SELECT * FROM Products WHERE ProductID = ?";
        return jdbcTemplate.queryForObject(sql, new ProductRowMapper(), productId);
    }

    private static class ProductRowMapper implements RowMapper<Product> {
        @Override
        public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
            Product product = new Product();
            product.setProductID(rs.getInt("ProductID"));
            product.setName(rs.getString("Name"));
            product.setDescription(rs.getString("Description"));
            product.setPrice(rs.getDouble("Price"));
            return product;
        }
    }

}