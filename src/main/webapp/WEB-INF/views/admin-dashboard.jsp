<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Dashboard</title>

<style>
    body {
        margin: 0;
        padding: 0;
        font-family: Arial, sans-serif;
        background: #f4f6f9;
    }

    .header {
        background: #343a40;
        color: white;
        padding: 20px;
        text-align: center;
        font-size: 24px;
        font-weight: bold;
    }

    .container {
        width: 90%;
        margin: 30px auto;
    }

    .top-bar {
        display: flex;
        justify-content: space-between;
        margin-bottom: 25px;
    }

    .welcome {
        font-size: 18px;
        font-weight: bold;
        color: #333;
    }

    .logout-btn a {
        text-decoration: none;
        background: #dc3545;
        color: white;
        padding: 10px 18px;
        border-radius: 6px;
        font-size: 14px;
    }

    .logout-btn a:hover {
        background: #b02a37;
    }

    .section {
        background: white;
        padding: 25px;
        margin-bottom: 30px;
        border-radius: 10px;
        box-shadow: 0px 0px 10px rgba(0,0,0,0.08);
    }

    h2 {
        margin-top: 0;
        color: #222;
    }

    label {
        display: block;
        margin-top: 15px;
        font-weight: bold;
        color: #444;
    }

    input, textarea, select {
        width: 100%;
        padding: 10px;
        margin-top: 6px;
        border: 1px solid #ccc;
        border-radius: 6px;
        font-size: 14px;
    }

    textarea {
        resize: vertical;
        min-height: 80px;
    }

    button {
        margin-top: 20px;
        padding: 12px 20px;
        background: #2d89ef;
        color: white;
        border: none;
        border-radius: 6px;
        cursor: pointer;
        font-size: 14px;
    }

    button:hover {
        background: #1b5fbf;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
    }

    table th, table td {
        border: 1px solid #ddd;
        padding: 12px;
        text-align: center;
    }

    table th {
        background: #f1f1f1;
    }

    .status-select {
        width: auto;
    }
</style>
</head>
<body>

<div class="header">
    Admin Dashboard
</div>

<div class="container">

    <div class="top-bar">
        <div class="welcome">
            Welcome ${sessionScope.loggedInUser.name}
        </div>

        <div class="logout-btn">
            <a href="${pageContext.request.contextPath}/user/logout">
                Logout
            </a>
        </div>
    </div>

    <!-- Add Food Section -->
    <div class="section">
        <h2>Add New Food Item</h2>
		
		
        <form action="${pageContext.request.contextPath}/food" method="post">

            <label for="name">Food Name</label>
            <input type="text" id="name" name="name" required />

            <label for="description">Description</label>
            <textarea id="description" name="description" required></textarea>

            <label for="price">Price</label>
            <input type="number" id="price" name="price" step="0.01" required />

            <label for="available">Availability</label>
            <select id="available" name="available" required>
                <option value="true">Available</option>
                <option value="false">Not Available</option>
            </select>
			
            <button type="submit">Add Food Item</button>

        </form>
    </div>

    <!-- View Orders Section -->
    <div class="section">
        <h2>Manage Orders</h2>

        <table>
            <thead>
                <tr>
                    <th>Order ID</th>
                    <th>User ID</th>
                    <th>Total Price</th>
                    <th>Current Status</th>
                    <th>Update Status</th>
                </tr>
            </thead>

            <tbody>

                <c:forEach var="order" items="${orderList}"> <!--orderList is coming from controller where model.addAttribute("orderList",list); and items is use for list , array,set etc-->
                    <tr>

                        <td>${order.orderId}</td>
                        <td>${order.userId}</td>
                        <td>₹ ${order.totalPrice}</td>
                        <td>${order.status}</td>

                        <td>
                            <form action="${pageContext.request.contextPath}/update-order-status"
                                  method="post">

                                <input type="hidden"
                                       name="orderId"
                                       value="${order.orderId}" />

                                <select name="status" class="status-select">
                                    <option value="PENDING">PENDING</option>
                                    <option value="PREPARING">PREPARING</option>
                                    <option value="DELIVERED">DELIVERED</option>
                                </select>

                                <button type="submit">Update</button>
                            </form>
                        </td>

                    </tr>
                </c:forEach>

            </tbody>
        </table>
    </div>

</div>

</body>
</html>