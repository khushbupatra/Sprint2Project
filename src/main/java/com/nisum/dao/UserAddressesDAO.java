package com.nisum.dao;

import com.nisum.model.UserAddresses;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserAddressesDAO {

    private final JdbcTemplate jdbcTemplate;

    // Constructor Injection of DataSource
    public UserAddressesDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void addAddresses(UserAddresses userAddresses) {
        String sql = "INSERT INTO UserAddresses VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                userAddresses.getAddressId(),
                userAddresses.getUserID(),
                userAddresses.getAddressLine1(),
                userAddresses.getAddressLine2(),
                userAddresses.getZipcode(),
                userAddresses.getState(),
                userAddresses.getCountry()
        );
    }

    public UserAddresses getAddressByAddressId(Integer id) {
        String sql = "SELECT * FROM UserAddresses WHERE AddressID = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new UserAddressesRowMapper());
    }

    public List<UserAddresses> getAddressByUserId(Integer id) {
        String sql = "SELECT * FROM UserAddresses WHERE UserID = ?";
        return jdbcTemplate.query(sql, new Object[]{id}, new UserAddressesRowMapper());
    }

    public List<UserAddresses> getAllAddresses() {
        String sql = "SELECT * FROM UserAddresses";
        return jdbcTemplate.query(sql, new UserAddressesRowMapper());
    }

    public void updateAddress(UserAddresses userAddresses) {
        String sql = "UPDATE UserAddresses SET UserID = ?, AddressLine1 = ?, AddressLine2 = ?, ZipCode = ?, State = ?, Country = ? WHERE AddressID = ?";
        jdbcTemplate.update(sql,
                userAddresses.getUserID(),
                userAddresses.getAddressLine1(),
                userAddresses.getAddressLine2(),
                userAddresses.getZipcode(),
                userAddresses.getState(),
                userAddresses.getCountry(),
                userAddresses.getAddressId()
        );
    }

    public void deleteAddress(Integer addressId) {
        String sql = "DELETE FROM UserAddresses WHERE AddressID = ?";
        jdbcTemplate.update(sql, addressId);
    }

    public void deleteAddressByUserID(Integer userID) {
        String sql = "DELETE FROM UserAddresses WHERE UserID = ?";
        jdbcTemplate.update(sql, userID);
    }

    // RowMapper class to map ResultSet to UserAddresses object
    private static class UserAddressesRowMapper implements RowMapper<UserAddresses> {
        @Override
        public UserAddresses mapRow(ResultSet rs, int rowNum) throws SQLException {
            UserAddresses userAddresses = new UserAddresses();
            userAddresses.setAddressId(rs.getInt("AddressID"));
            userAddresses.setUserID(rs.getInt("UserID"));
            userAddresses.setAddressLine1(rs.getString("AddressLine1"));
            userAddresses.setAddressLine2(rs.getString("AddressLine2"));
            userAddresses.setZipcode(rs.getString("ZipCode"));
            userAddresses.setState(rs.getString("State"));
            userAddresses.setCountry(rs.getString("Country"));
            return userAddresses;
        }
    }
}
