//package com.nisum.controller;
//
//import com.nisum.model.Cart;
//import com.nisum.model.UserAddress;
//import com.nisum.service.CartService;
//import com.nisum.service.UserAddressService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.security.Principal;
//import java.util.List;
//
//@Controller
//@RequestMapping("/checkout")
//public class CheckoutController {
//
//    @Autowired
//    private CartService cartService;
//
//    @Autowired
//    private UserAddressService userAddressService;
//
//    @GetMapping
//    public String showCheckoutPage(Model model, Principal principal) {
//        // Get current user's cart
//        Cart cart = cartService.getUserCart(principal.getName());
//
//        // Get user's addresses
//        List<UserAddress> addresses = userAddressService.getUserAddresses(principal.getName());
//
//        // Calculate order totals
//        double subtotal = cart.getTotalPrice();
//        double tax = subtotal * 0.18; // 18% tax
//        double shipping = 49.00;
//        double total = subtotal + tax + shipping;
//
//        // Add attributes to model
//        model.addAttribute("cart", cart);
//        model.addAttribute("addresses", addresses);
//        model.addAttribute("subtotal", subtotal);
//        model.addAttribute("tax", tax);
//        model.addAttribute("shipping", shipping);
//        model.addAttribute("total", total);
//
//        return "checkout";
//    }
//
//    @PostMapping("/process")
//    public String processCheckout(
//            @RequestParam("addressId") Long addressId,
//            @RequestParam(value = "promo", required = false) String promoCode,
//            @RequestParam("payment") String paymentMethod,
//            Principal principal) {
////
////        // Process the order
////        cartService.checkoutCart(principal.getName(), addressId, paymentMethod, promoCode);
//
//        return "redirect:/confirmation";
//    }
//}