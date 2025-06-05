<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Select Delivery Address</title>
    <link rel="stylesheet" href="styles.css" />
</head>
<body>
<div class="container">
    <h2>Select a Delivery Address</h2>

    <div class="address-card">
        <input type="radio" name="address" checked />
        <div class="address-info">
            <strong>Ravi Kumar</strong><br />
            101, Green View Apartments, Sector 22<br />
            Gurgaon, Haryana - 122016<br />
            Phone: 9876543210
        </div>
        <button class="deliver-btn">Deliver to this address</button>
    </div>

    <div class="address-card">
        <input type="radio" name="address" checked />
        <div class="address-info">
            <strong>Rashmi Kumari</strong><br />
            102, Alpha Apartments, Sector 12<br />
            Anand vihar, Delhi - 122016<br />
            Phone: 9876543210
        </div>
        <button class="deliver-btn">Deliver to this address</button>
    </div>

    <div class="buttons">
        <button class="secondary-btn">Show more addresses</button>
        <button class="primary-btn">Add a New Delivery Address</button>
    </div>
</div>

<script src="script.js"></script>
</body>
</html>