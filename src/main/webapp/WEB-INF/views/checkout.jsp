<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
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
            border-bottom: 1px solid #eee;
            padding-bottom: 15px;
        }

        .billing-address {
            background-color: #f5f5f5;
            padding: 15px;
            border-radius: 8px;
            margin-bottom: 20px;
        }

        .form-group {
            margin-bottom: 20px;
        }

        .form-group label {
            display: block;
            margin-bottom: 8px;
            font-weight: 500;
        }

        .promo-container {
            display: flex;
            gap: 10px;
            margin-bottom: 20px;
        }

        .promo-container input {
            flex: 1;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 8px;
        }

        .promo-container button {
            padding: 10px 15px;
            background-color: #e3f2fd;
            color: #1565c0;
            border: none;
            border-radius: 8px;
            cursor: pointer;
            transition: background-color 0.2s;
        }

        .promo-container button:hover {
            background-color: #bbdefb;
        }

        .payment-option {
            display: flex;
            align-items: center;
            padding: 12px;
            border: 1px solid #e0e0e0;
            border-radius: 8px;
            margin-bottom: 10px;
            transition: all 0.3s ease;
        }

        .payment-option:hover {
            border-color: #4a90e2;
            background-color: #f5f9ff;
        }

        .payment-option input {
            margin-right: 15px;
            transform: scale(1.2);
        }

        .payment-option label {
            flex: 1;
            cursor: pointer;
        }

        .submit-btn {
            display: block;
            width: 100%;
            padding: 14px;
            background-color: #4a90e2;
            color: white;
            border: none;
            border-radius: 8px;
            font-size: 16px;
            font-weight: 500;
            cursor: pointer;
            transition: background-color 0.2s;
            margin-top: 30px;
        }

        .submit-btn:hover {
            background-color: #3a7bc8;
        }

        .order-summary {
            background-color: #f9f9f9;
            padding: 20px;
            border-radius: 8px;
            margin-top: 30px;
        }

        .order-summary h3 {
            margin-top: 0;
            border-bottom: 1px solid #eee;
            padding-bottom: 10px;
        }

        .order-row {
            display: flex;
            justify-content: space-between;
            margin: 10px 0;
        }

        .order-total {
            font-weight: 600;
            font-size: 18px;
            border-top: 1px solid #ddd;
            padding-top: 10px;
            margin-top: 15px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Checkout - Billing & Payment</h2>
        <form action="${pageContext.request.contextPath}/checkout/process" method="post">

            <!-- Address Selection -->
            <div class="form-group">
                <label>Select Delivery Address:</label>
                <select name="addressId" class="address-select" required>
                    <c:forEach items="${addresses}" var="address">
                        <option value="${address.addressId}">
                            ${address.recipientName}, ${address.streetLine1},
                            ${address.city}, ${address.state} - ${address.postalCode}
                        </option>
                    </c:forEach>
                </select>
            </div>

            <!-- Dynamic Order Summary -->
            <div class="order-summary">
                <h3>Order Summary</h3>
                <div class="order-row">
                    <span>Subtotal (${cart.items.size()} items)</span>
                    <span>₹<fmt:formatNumber value="${subtotal}" pattern="#,##0.00"/></span>
                </div>
                <div class="order-row">
                    <span>Delivery Fee</span>
                    <span>₹<fmt:formatNumber value="${shipping}" pattern="#,##0.00"/></span>
                </div>
                <div class="order-row">
                    <span>Tax (18%)</span>
                    <span>₹<fmt:formatNumber value="${tax}" pattern="#,##0.00"/></span>
                </div>
                <div class="order-row order-total">
                    <span>Total</span>
                    <span>₹<fmt:formatNumber value="${total}" pattern="#,##0.00"/></span>
                </div>
            </div>

            <button type="submit" class="submit-btn">Place Order</button>
        </form>
    </div>

    <script>
        // Enhanced promo code validation with AJAX
        document.querySelector('.promo-container button').addEventListener('click', function(e) {
            e.preventDefault();
            const promoInput = document.querySelector('input[name="promo"]');
            const promoCode = promoInput.value.trim();

            if(!promoCode) {
                alert('Please enter a promo code');
                return;
            }

            fetch('${pageContext.request.contextPath}/api/validate-promo?code=' + promoCode)
                .then(response => response.json())
                .then(data => {
                    if(data.valid) {
                        alert(`Promo applied! Discount: ₹${data.discount}`);
                        // Update UI with discount
                    } else {
                        alert('Invalid promo code');
                    }
                })
                .catch(error => {
                    console.error('Error:', error);
                    alert('Error validating promo code');
                });
        });
    </script>
</body>
</html>