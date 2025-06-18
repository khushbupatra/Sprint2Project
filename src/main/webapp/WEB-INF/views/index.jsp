<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome to Shopping App</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg,#e66465, #9198e5);
            height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .welcome-container {
            text-align: center;
            background-color: white;
            padding: 40px 60px;
            border-radius: 15px;
            box-shadow: 0 10px 25px rgba(0, 0, 0, 0.2);
            max-width: 600px;
        }

        .shop-title {
            font-size: 2.5rem;
            color: #333;
            margin-bottom: 10px;
        }

        .shop-subtitle {
            font-size: 1.2rem;
            color: #666;
            margin-bottom: 30px;
        }

        .shop-button {
            display: inline-block;
            background-color: #ff007b;
            color: white;
            padding: 12px 24px;
            font-size: 1rem;
            text-decoration: none;
            border-radius: 8px;
            transition: background-color 0.3s ease, transform 0.2s ease;
        }

        .shop-button:hover {
            background-color: #d60069;
            transform: scale(1.05);
        }

        .shop-button:active {
            transform: scale(0.98);
        }

        .emoji {
            font-size: 1.2rem;
            margin-right: 8px;
        }
    </style>
</head>
<body>
    <div class="welcome-container">
        <h1 class="shop-title">Welcome, User!</h1>
        <p class="shop-subtitle">Your one-stop shop for everything you love</p>
        <a class="shop-button" href="${pageContext.request.contextPath}/cart/view">
            <span class="emoji">🛒</span> Go to Cart
        </a>
    </div>
</body>
</html>
