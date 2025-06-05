package com.nisum.controller;

import com.google.gson.Gson;
import com.nisum.model.CartItem;
import com.nisum.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/getShoppingCart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @GetMapping
    public void getShoppingCart(HttpServletResponse response) throws IOException {
        List<CartItem> shoppingCart = shoppingCartService.getCartItemList();
        String json = new Gson().toJson(shoppingCart);
        response.setContentType("application/json");
        response.getWriter().write(json);
    }
}