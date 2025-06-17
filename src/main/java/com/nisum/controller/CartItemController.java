package com.nisum.controller;

import com.google.gson.Gson;
import com.nisum.dao.CartItemDAO;
import com.nisum.dao.InitialCartItemDAO;
import com.nisum.model.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartItemController {

    @Autowired
    private CartItemDAO cartItemDAO;

    @Autowired
    private InitialCartItemDAO initialCartItemDAO;

    @Autowired
    private Gson gson;

    @GetMapping("/view")
    public String showCartPage() {
        return "cart"; // resolves to /WEB-INF/views/cart.jsp
    }

    @GetMapping("/api")
    public void getAllCartItems(HttpServletResponse response) throws IOException {
        List<CartItem> cartItems = cartItemDAO.getAllCartItems();
        response.setContentType("application/json");
        response.getWriter().write(gson.toJson(cartItems));
    }

    @PostMapping("/add")
    public void addCartItem(@RequestBody String cartItemJson, HttpServletResponse response) throws IOException {
        try {
            CartItem cartItem = gson.fromJson(cartItemJson, CartItem.class);
            cartItemDAO.addItems(cartItem);
            response.getWriter().write("Success");
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid request");
        }
    }
}
