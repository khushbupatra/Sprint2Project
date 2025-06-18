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
            width: 100%;
        }

        .add-new-btn:hover {
            background-color: #e0e0e0;
        }

        .add-address-form {
            display: none;
            background-color: #f5f5f5;
            padding: 20px;
            border-radius: 8px;
            margin-top: 20px;
            animation: fadeIn 0.3s ease;
        }

        @keyframes fadeIn {
            from { opacity: 0; transform: translateY(-10px); }
            to { opacity: 1; transform: translateY(0); }
        }

        .form-group {
            margin-bottom: 15px;
        }

        .form-group label {
            display: block;
            margin-bottom: 5px;
            font-weight: 500;
        }

        .form-group input, .form-group select {
            width: 100%;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 6px;
            box-sizing: border-box;
        }

        .form-actions {
            display: flex;
            justify-content: flex-end;
            gap: 10px;
            margin-top: 15px;
        }

        .form-btn {
            padding: 8px 16px;
            border-radius: 6px;
            cursor: pointer;
            border: none;
        }

        .cancel-btn {
            background-color: #f1f1f1;
        }

        .save-btn {
            background-color: #4a90e2;
            color: white;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Select a Delivery Address</h2>

        <form id="addressForm" action="${pageContext.request.contextPath}/checkout" method="post">
            <div class="address-option">
                <input type="radio" name="address" value="Ravi Kumar, 123 Main Street, Apt 4B, Bangalore, Karnataka 560001" id="address1" checked>
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
                <input type="radio" name="address" value="Rashmi Kumari, 456 Oak Avenue, Floor 2, Mumbai, Maharashtra 400001" id="address2">
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

        <button type="button" id="showFormBtn" class="add-new-btn">+ Add new address</button>

        <div id="newAddressForm" class="add-address-form">
            <h3>Add New Address</h3>
            <form id="saveAddressForm">
                <div class="form-group">
                    <label>Full Name</label>
                    <input type="text" name="fullName" required>
                </div>
                <div class="form-group">
                    <label>Phone Number</label>
                    <input type="tel" name="phone" required>
                </div>
                <div class="form-group">
                    <label>Address Line 1</label>
                    <input type="text" name="address1" required>
                </div>
                <div class="form-group">
                    <label>Address Line 2 (Optional)</label>
                    <input type="text" name="address2">
                </div>
                <div class="form-group">
                    <label>City</label>
                    <input type="text" name="city" required>
                </div>
                <div class="form-group">
                    <label>State</label>
                    <select name="state" required>
                        <option value="">Select State</option>
                        <option value="Karnataka">Karnataka</option>
                        <option value="Maharashtra">Maharashtra</option>
                        <option value="Delhi">Delhi</option>
                    </select>
                </div>
                <div class="form-group">
                    <label>PIN Code</label>
                    <input type="text" name="pincode" required>
                </div>
                <div class="form-actions">
                    <button type="button" id="cancelBtn" class="form-btn cancel-btn">Cancel</button>
                    <button type="button" id="saveBtn" class="form-btn save-btn">Save Address</button>
                </div>
            </form>
        </div>
    </div>

    <script>
        document.addEventListener('DOMContentLoaded', function() {
            const showFormBtn = document.getElementById('showFormBtn');
            const newAddressForm = document.getElementById('newAddressForm');
            const cancelBtn = document.getElementById('cancelBtn');
            const saveBtn = document.getElementById('saveBtn');
            const saveAddressForm = document.getElementById('saveAddressForm');

            // Show/hide address form
            showFormBtn.addEventListener('click', function() {
                newAddressForm.style.display = newAddressForm.style.display === 'block' ? 'none' : 'block';
            });

            // Hide form on cancel
            cancelBtn.addEventListener('click', function() {
                newAddressForm.style.display = 'none';
                saveAddressForm.reset();
            });

            // Save address - this is where you'd connect to your backend
            saveBtn.addEventListener('click', function() {
                // Validate form
                const inputs = saveAddressForm.querySelectorAll('[required]');
                let isValid = true;

                inputs.forEach(input => {
                    if (!input.value.trim()) {
                        input.style.borderColor = 'red';
                        isValid = false;
                    } else {
                        input.style.borderColor = '#ddd';
                    }
                });

                if (isValid) {
                    // Create FormData object
                    const formData = new FormData(saveAddressForm);

                    // AJAX call to save address (replace with your actual endpoint)
                    fetch('${pageContext.request.contextPath}/user-address/save', {
                        method: 'POST',
                        body: formData
                    })
                    .then(response => {
                        if (response.ok) {
                            return response.json();
                        }
                        throw new Error('Network response was not ok');
                    })
                    .then(data => {
                        // Handle successful save
                        alert('Address saved successfully!');
                        newAddressForm.style.display = 'none';
                        saveAddressForm.reset();

                        // Refresh the page to show new address
                        window.location.reload();
                    })
                    .catch(error => {
                        console.error('Error:', error);
                        alert('Error saving address');
                    });
                } else {
                    alert('Please fill all required fields');
                }
            });
        });
    </script>
</body>
</html>