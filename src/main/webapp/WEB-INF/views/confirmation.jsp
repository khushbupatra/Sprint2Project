<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order Confirmation</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/confirmation.css">
</head>
<body>
    <div class="page style">
        <h1 class="main heading">Thank you for Placing Your Order!</h1>
        <p class="multithreading">Your order has been successfully placed.</p>

        <section id="orderDetails">
            <h2>Order Details</h2>
        </section>

        <!-- Other sections same as original -->

        <section id="checkout">
            <button onclick="window.location.href='${pageContext.request.contextPath}/orders'">View my Orders</button>
            <button onclick="RestartCart()">Continue Shopping</button>
        </section>
    </div>

    <script src="${pageContext.request.contextPath}/js/confirmation.js"></script>
</body>
</html>