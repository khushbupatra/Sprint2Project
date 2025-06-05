<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOC TYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Your Shopping Cart</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/cart.css">
</head>
<body>
    <h1>Your Shopping Cart</h1>
    <div id="cartItems"></div>
    <div id="totalPrice"></div>

    <div class="next-page-container">
        <button onclick="window.location.href='${pageContext.request.contextPath}/address/select'">Proceed to Address</button>
    </div>

    <script src="${pageContext.request.contextPath}/js/cart.js"></script>
</body>
</html>