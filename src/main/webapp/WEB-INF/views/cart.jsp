<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Your Shopping Cart</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            margin: 0;
            padding: 20px;
        }

        h1 {
            text-align: center;
            margin-bottom: 30px;
            font-size: 2rem;
            color: #333;
        }

        .cart-container {
            max-width: 900px;
            margin: auto;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 2px 8px rgba(0,0,0,0.1);
            padding: 20px;
            display: flex;
            gap: 20px;
        }

        .cart-image img {
            width: 140px;
            height: auto;
            border-radius: 4px;
        }

        .cart-details {
            flex: 1;
        }

        .cart-details h2 {
            margin: 0;
            font-size: 1.3rem;
            color: #222;
        }

        .cart-details p {
            margin: 5px 0;
        }

        .in-stock {
            color: green;
            font-weight: bold;
        }

        .price {
            color: red;
            font-weight: bold;
            font-size: 1.2rem;
        }

        .original-price {
            text-decoration: line-through;
            color: #777;
            margin-left: 10px;
        }

        .discount {
            color: green;
            font-weight: bold;
            margin-left: 10px;
        }

        .button-group {
            margin-top: 10px;
        }

        .button-group button {
            margin-right: 10px;
            padding: 6px 12px;
            border: none;
            background-color: #eee;
            cursor: pointer;
            border-radius: 4px;
        }

        .next-page-container {
            text-align: center;
            margin-top: 30px;
        }

        .next-page-container button {
            background-color: #ff007b;
            color: white;
            padding: 12px 28px;
            border: none;
            border-radius: 5px;
            font-size: 1rem;
            cursor: pointer;
        }

        select {
            padding: 4px 8px;
            font-size: 1rem;
            border-radius: 4px;
            border: 1px solid #ccc;
        }
    </style>
</head>
<body>

    <h1>Your Shopping Cart</h1>

    <div class="cart-container">
        <div class="cart-image">
            <img src="${pageContext.request.contextPath}/images/shirt.jpg" alt="Product Image">
        </div>
        <div class="cart-details">
            <h2>Men's Cotton Shirt</h2>
            <p>by FashionHub</p>

            <p><strong>Size:</strong>
                <select name="size">
                    <option value="XS">XS</option>
                    <option value="S">S</option>
                    <option value="M" selected>M</option>
                    <option value="L">L</option>
                    <option value="XL">XL</option>
                </select>
            </p>

            <p><strong>Color:</strong> Brown</p>
            <p><strong>Delivery by:</strong> Tomorrow</p>
            <p><strong>Quantity:</strong> <input type="number" value="2" min="1" max="10"></p>
            <p><strong>Status:</strong> <span class="in-stock">In Stock</span></p>
            <label><input type="checkbox"> This will be a gift</label>

            <div class="button-group">
                <button>Delete</button>
                <button>Save for Later</button>
                <button>See more like this</button>
            </div>

            <p class="price">₹799
                <span class="original-price">₹1299</span>
                <span class="discount">(38% OFF)</span>
            </p>
        </div>
    </div>

    <div class="next-page-container">
        <button onclick="window.location.href='${pageContext.request.contextPath}/user-address/select'">Next Page</button>
    </div>


    <script src="${pageContext.request.contextPath}/js/cart.js"></script>
</body>
</html>
