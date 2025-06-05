package com.nisum.controller;

import com.nisum.dao.UserAddressDAO;
import com.nisum.model.UserAddress;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/user-address")
public class UserAddressController {

    @Autowired
    private UserAddressDAO userAddressDAO;

    @GetMapping
    public void getAllAddresses(HttpServletResponse response) throws IOException {
        List<UserAddress> addresses = userAddressDAO.getAllAddresses();
        sendAsJson(response, addresses);
    }

    @GetMapping("/user/{userId}")
    public void getAddressesByUserId(@PathVariable Integer userId,
                                     HttpServletResponse response) throws IOException {
        List<UserAddress> addresses = userAddressDAO.getAddressesByUserId(userId);
        sendAsJson(response, addresses);
    }

    @GetMapping("/{addressId}")
    public void getAddressById(@PathVariable Integer addressId,
                               HttpServletResponse response) throws IOException {
        UserAddress address = userAddressDAO.getAddressById(addressId);
        sendAsJson(response, address);
    }

    @PostMapping
    public void addAddress(@RequestBody UserAddress userAddress,
                           HttpServletResponse response) throws IOException {
        userAddressDAO.addAddress(userAddress);
        response.setStatus(HttpServletResponse.SC_CREATED);
    }

    @PutMapping("/{addressId}")
    public void updateAddress(@PathVariable Integer addressId,
                              @RequestBody UserAddress userAddress,
                              HttpServletResponse response) throws IOException {
        userAddress.setAddressId(addressId);
        userAddressDAO.updateAddress(userAddress);
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @DeleteMapping("/{addressId}")
    public void deleteAddress(@PathVariable Integer addressId,
                              HttpServletResponse response) {
        userAddressDAO.deleteAddress(addressId);
        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }

    private void sendAsJson(HttpServletResponse response, Object obj) throws IOException {
        response.setContentType("application/json");
        response.getWriter().write(new Gson().toJson(obj));
    }
}