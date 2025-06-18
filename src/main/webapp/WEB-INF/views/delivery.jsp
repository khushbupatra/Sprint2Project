<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Select Delivery Address</title>
    <style>
        body {
            font-family: 'Segoe UI', Roboto, Arial, sans-serif;
            background-color: #f8f9fa;
            margin: 0;
            padding: 20px;
            color: #333;
            line-height: 1.6;
        }

        .container {
            max-width: 600px;
            margin: 30px auto;
            background: #fff;
            padding: 30px;
            border-radius: 16px;
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.08);
        }

        h2 {
            text-align: center;
            color: #2c3e50;
            margin-bottom: 25px;
            font-weight: 600;
        }

        .address-option {
            display: flex;
            align-items: center;
            padding: 15px;
            border: 1px solid #e0e0e0;
            border-radius: 12px;
            margin: 15px 0;
            transition: all 0.3s ease;
            background: #fff;
        }

        .address-option:hover {
            border-color: #4a90e2;
            box-shadow: 0 2px 10px rgba(74, 144, 226, 0.1);
        }

        .address-option input[type="radio"] {
            margin-right: 15px;
            transform: scale(1.2);
        }

        .address-details {
            flex: 1;
        }

        .address-details p {
            margin: 5px 0;
            color: #555;
        }

        .submit-btn {
            display: block;
            width: 100%;
            padding: 12px;
            background-color: #4a90e2;
            color: white;
            border: none;
            border-radius: 8px;
            font-size: 16px;
            font-weight: 500;
            cursor: pointer;
            transition: background-color 0.2s;
            margin-top: 20px;
        }

        .submit-btn:hover {
            background-color: #3a7bc8;
        }

        .add-new-btn {
            display: block;
            text-align: center;
            padding: 12px;
            background-color: #f1f1f1;
            color: #555;
            border: none;
            border-radius: 8px;
            font-size: 16px;
            font-weight: 500;
            cursor: pointer;
            transition: background-color 0.2s;
            margin-top: 10px;
            text-decoration: none;
        }

        .add-new-btn:hover {
            background-color: #e0e0e0;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Select a Delivery Address</h2>

        <form action="${pageContext.request.contextPath}/views/checkout.jsp" method="post">
            <div class="address-option">
                <input type="radio" name="address" value="Ravi Kumar" id="address1" checked>
                <div class="address-details">
                    <label for="address1">
                        <strong>Ravi Kumar</strong><br>
                        <p>123 Main Street, Apt 4B<br>
                        Bangalore, Karnataka 560001<br>
                        Phone: +91 9876543210</p>
                    </label>
                </div>
            </div>

            <div class="address-option">
                <input type="radio" name="address" value="Rashmi Kumari" id="address2">
                <div class="address-details">
                    <label for="address2">
                        <strong>Rashmi Kumari</strong><br>
                        <p>456 Oak Avenue, Floor 2<br>
                        Mumbai, Maharashtra 400001<br>
                        Phone: +91 8765432109</p>
                    </label>
                </div>
            </div>

            <button type="submit" class="submit-btn">Deliver to this address</button>
        </form>
            <button type="button" class="add-new-btn" onclick="toggleAddressForm()">+ Add New Address</button>

            <!-- Hidden Add Address Form -->
            <div id="newAddressForm" style="display:none;">
                <form action="${pageContext.request.contextPath}/views/checkout.jsp" method="post">
                    <input type="text" name="fullName" placeholder="Full Name" required style="width:100%; padding:10px; margin-bottom:10px; border-radius:6px; border:1px solid #ccc;">
                    <input type="text" name="addressLine" placeholder="Address Line" required style="width:100%; padding:10px; margin-bottom:10px; border-radius:6px; border:1px solid #ccc;">
                    <input type="text" name="city" placeholder="City" required style="width:100%; padding:10px; margin-bottom:10px; border-radius:6px; border:1px solid #ccc;">
                    <input type="text" name="state" placeholder="State" required style="width:100%; padding:10px; margin-bottom:10px; border-radius:6px; border:1px solid #ccc;">
                    <input type="text" name="pincode" placeholder="Pincode" required style="width:100%; padding:10px; margin-bottom:10px; border-radius:6px; border:1px solid #ccc;">
                    <input type="text" name="phone" placeholder="Phone Number" required style="width:100%; padding:10px; margin-bottom:10px; border-radius:6px; border:1px solid #ccc;">
                    <button type="submit" class="submit-btn">Save and Deliver Here</button>
                </form>
            </div>

    </div>
    <script>
        function toggleAddressForm() {
            var form = document.getElementById('newAddressForm');
            form.style.display = form.style.display === 'none' ? 'block' : 'none';
        }
    </script>

</body>
</html>