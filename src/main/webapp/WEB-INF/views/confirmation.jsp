<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Thank You Page</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Confirmation.css">
</head>
<body>
<div class="page style">
    <h1 class="main heading">Thank you for Placing Your Order!</h1>
    <p class="mainheadingtext">Your order has been successfully placed. You will receive a confirmation email shortly.</p>

    <section id="order details">
        <h2>Order Details</h2>
    </section>

    <section id="middle">
        <h2>Delivery instructions</h2>
        <div class="instructions">
            <p>Please ensure someone is available at the address to receive the delivery. You can track your shipment from your account.</p>
        </div>

        <h2>Rewards Earned</h2>
        <div class="rewards">
            <p>You have earned 150 reward points on this order! Redeem them on your next purchase.</p>
        </div>

        <h2>Email Confirmation</h2>
        <div class="email-confirmation">
            <p>A confirmation email has been sent to ravi.kumar@example with all the order details.</p>
        </div>
    </section>

    <section id="checkout">
        <button>View my Orders</button>
        <button onclick="RestartCart()">Confirm Shopping</button>
    </section>
</div>
<script src="${pageContext.request.contextPath}/js/confirmation.js"></script>
</body>
</html>
