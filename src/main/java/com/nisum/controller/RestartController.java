package com.nisum.controller;

import com.nisum.dao.CartItemDAO;
import com.nisum.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/Restart")
public class RestartController {

    @Autowired
    private CartItemDAO cartItemDAO;

    @Autowired
    private ShoppingCartService shoppingCartService;

    @GetMapping
    public void restart(HttpServletResponse response) throws IOException {
        cartItemDAO.clearCart();
        shoppingCartService.clearCart();
        response.setContentType("text/plain");
        response.getWriter().write("Restarted Successfully");
    }
}