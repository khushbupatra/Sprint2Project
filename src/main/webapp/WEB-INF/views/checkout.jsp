<%@ page contentType="text/html;charset=UTF-8" %>
<!DOC TYPE html>
<html>
<head>
    <title>Checkout</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/checkout.css">
</head>
<body>

<h1>Checkout - Billing & Payment</h1>

<div class="section">
    <h3>Billing Address</h3>
    <div class="billing-address-box"></div>
</div>

<div class="section">
    <h3>Enter Promo Code</h3>
    <div class="promo-code">
        <input type="text" placeholder="Enter promo code">
        <button class="apply-btn">Apply</button>
    </div>
</div>

<div class="section">
    <h3>Select Payment Method</h3>
    <div class="payment-method-box">
        <label><input type="radio" name="payment"> Credit/Debit Card</label><br>
        <label><input type="radio" name="payment"> Wallet Rewards</label><br>
        <label><input type="radio" name="payment"> Net Banking</label><br>
        <label><input type="radio" name="payment"> UPI & Other Apps</label><br>
        <label><input type="radio" name="payment"> EMI (Easy Installments)</label><br>
        <label><input type="radio" name="payment"> Cash on Delivery</label>
    </div>
</div>

<div class="place-order">
    <button class="place-order-btn" onclick="window.location.href='orderConfirmation.jsp'">Deliver to this address</button>
</div>

<script src="${pageContext.request.contextPath}/js/checkout.js"></script>
</body>
</html>
