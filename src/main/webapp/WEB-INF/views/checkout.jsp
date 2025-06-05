<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Checkout - Billing & Payment</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/checkout.css">
</head>
<body>
    <h1>Checkout - Billing & Payment</h1>

    <div class="section">
        <h3>Billing Address</h3>
        <div class="billing-address-box"></div>
    </div>

    <!-- Other sections same as original -->

    <div class="place-order">
        <button class="place-order-btn" onclick="window.location.href='${pageContext.request.contextPath}/confirmation'">Place Order</button>
    </div>

    <script src="${pageContext.request.contextPath}/js/checkout.js"></script>
</body>
</html>