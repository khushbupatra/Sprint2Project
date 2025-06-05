package com.nisum.controller;

import com.google.gson.Gson;
import com.nisum.dao.UserAddressDAO;
import com.nisum.model.UserAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/UserAddress")
public class UserAddressController {

    @Autowired
    private UserAddressDAO userAddressDAO;

    @GetMapping
    public void getUserAddresses(HttpServletResponse response) throws IOException {
        List<UserAddress> userAddresses = userAddressDAO.getAllUserAddresses();
        String json = new Gson().toJson(userAddresses);
        response.setContentType("application/json");
        response.getWriter().write(json);
    }
}