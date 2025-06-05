package com.nisum.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.nisum.dao.CartItemDAO;
import com.nisum.dao.InitialCartItemDAO;
import com.nisum.model.CartItem;
import com.nisum.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

@Controller
@RequestMapping("/cart")
public class CartItemController {

    @Autowired
    private CartItemDAO cartItemDAO;

    @Autowired
    private InitialCartItemDAO initialCartItemDAO;

    @Autowired
    private CartItemService cartItemService;

    @GetMapping("/items")
    @ResponseBody
    public String getAllCartItems(HttpServletResponse response) throws IOException {
        ArrayList<CartItem> cartItemList = (ArrayList<CartItem>) cartItemDAO.getAllCartItems();
        String json = new Gson().toJson(cartItemList);
        response.setContentType("application/json");
        return json;
    }

    @PostMapping("/add")
    @ResponseBody
    public String addCartItem(@RequestBody String jsonBody, HttpServletResponse response) throws IOException {
        try {
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(jsonBody, JsonObject.class);

            Integer id = jsonObject.get("cartitemid").getAsInt();
            CartItem cartItem = initialCartItemDAO.getCartItemByCartItemID(id);
            cartItemDAO.addItems(cartItem);
            cartItemService.addCartItemToShoppingCart(cartItem);

            return "Success";
        } catch (RuntimeException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid JSON");
            return null;
        }
    }
}
