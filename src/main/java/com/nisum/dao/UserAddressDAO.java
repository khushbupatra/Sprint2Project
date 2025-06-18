package com.nisum.dao;

import com.nisum.model.UserAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserAddressDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserAddressDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addAddress(UserAddress userAddress) {
        String sql = "INSERT INTO UserAddresses (AddressID, UserID, FullName, Phone, AddressLine1, AddressLine2, City, State, Pincode, ZipCode, Country) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                userAddress.getAddressId(),
                userAddress.getUserId(),
                userAddress.getFullName(),
                userAddress.getPhone(),
                userAddress.getAddressLine1(),
                userAddress.getAddressLine2(),
                userAddress.getCity(),
                userAddress.getState(),
                userAddress.getPincode(),
                userAddress.getZipcode(),
                userAddress.getCountry());
    }

    public UserAddress getAddressById(Integer id) {
        String sql = "SELECT * FROM UserAddresses WHERE AddressID = ?";
        return jdbcTemplate.queryForObject(sql, new UserAddressRowMapper(), id);
    }

    public List<UserAddress> getAddressesByUserId(Integer userId) {
        String sql = "SELECT * FROM UserAddresses WHERE UserID = ?";
        return jdbcTemplate.query(sql, new UserAddressRowMapper(), userId);
    }

    public List<UserAddress> getAllAddresses() {
        String sql = "SELECT * FROM UserAddresses";
        return jdbcTemplate.query(sql, new UserAddressRowMapper());
    }

    public void updateAddress(UserAddress userAddress) {
        String sql = "UPDATE UserAddresses SET UserID = ?, FullName = ?, Phone = ?, AddressLine1 = ?, AddressLine2 = ?, City = ?, State = ?, Pincode = ?, ZipCode = ?, Country = ? " +
                "WHERE AddressID = ?";
        jdbcTemplate.update(sql,
                userAddress.getUserId(),
                userAddress.getFullName(),
                userAddress.getPhone(),
                userAddress.getAddressLine1(),
                userAddress.getAddressLine2(),
                userAddress.getCity(),
                userAddress.getState(),
                userAddress.getPincode(),
                userAddress.getZipcode(),
                userAddress.getCountry(),
                userAddress.getAddressId());
    }

    public void deleteAddress(Integer addressId) {
        String sql = "DELETE FROM UserAddresses WHERE AddressID = ?";
        jdbcTemplate.update(sql, addressId);
    }

    public void deleteAddressesByUserId(Integer userId) {
        String sql = "DELETE FROM UserAddresses WHERE UserID = ?";
        jdbcTemplate.update(sql, userId);
    }

    private static class UserAddressRowMapper implements RowMapper<UserAddress> {
        @Override
        public UserAddress mapRow(ResultSet rs, int rowNum) throws SQLException {
            UserAddress userAddress = new UserAddress();
            userAddress.setAddressId(rs.getInt("AddressID"));
            userAddress.setUserId(rs.getInt("UserID"));
            userAddress.setFullName(rs.getString("FullName"));
            userAddress.setPhone(rs.getString("Phone"));
            userAddress.setAddressLine1(rs.getString("AddressLine1"));
            userAddress.setAddressLine2(rs.getString("AddressLine2"));
            userAddress.setCity(rs.getString("City"));
            userAddress.setState(rs.getString("State"));
            userAddress.setPincode(rs.getString("Pincode"));
            userAddress.setZipcode(rs.getString("ZipCode"));
            userAddress.setCountry(rs.getString("Country"));
            return userAddress;
        }
    }
}