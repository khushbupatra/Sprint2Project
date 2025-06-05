package com.nisum.controller;

import com.google.gson.Gson;
import com.nisum.dao.InitialCartItemDAO;
import com.nisum.model.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/getInitialCartItem")
public class InitialCartItemController {

    @Autowired
    private InitialCartItemDAO initialCartItemDAO;

    @GetMapping
    public void getInitialCartItems(HttpServletResponse response) throws IOException {
        List<CartItem> cartItems = initialCartItemDAO.getAllInitialCartItems();
        String json = new Gson().toJson(cartItems);
        response.setContentType("application/json");
        response.getWriter().write(json);
    }
}