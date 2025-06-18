package com.nisum.controller;

import com.nisum.dao.UserAddressDAO;
import com.nisum.model.UserAddress;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/select")
    public String showDeliveryPage() {
        return "delivery"; // resolves to /WEB-INF/views/delivery.jsp
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

    @PostMapping("/save")
    @ResponseBody
    public ResponseEntity<?> saveAddress(@RequestParam Map<String, String> addressData,
                                         HttpSession session) {
        try {
            UserAddress userAddress = new UserAddress();
            userAddress.setFullName(addressData.get("fullName"));
            userAddress.setPhone(addressData.get("phone"));
            userAddress.setAddressLine1(addressData.get("address1"));
            userAddress.setAddressLine2(addressData.get("address2"));
            userAddress.setCity(addressData.get("city"));
            userAddress.setState(addressData.get("state"));
            userAddress.setPincode(addressData.get("pincode"));

            // Get user ID from session (you need to set this during login)
            Integer userId = (Integer) session.getAttribute("userId");
            if (userId == null) {
                return ResponseEntity.badRequest().body("User not logged in");
            }
            userAddress.setUserId(userId);

            userAddressDAO.addAddress(userAddress);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error saving address: " + e.getMessage());
        }
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