<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Place Order</title>

<style>
    body {
        margin: 0;
        padding: 0;
        font-family: Arial, sans-serif;
        background: #f4f6f9;
    }

    .container {
        width: 500px;
        margin: 60px auto;
        background: #ffffff;
        padding: 30px;
        border-radius: 10px;
        box-shadow: 0px 0px 12px rgba(0,0,0,0.1);
    }

    h2 {
        text-align: center;
        margin-bottom: 25px;
        color: #333;
    }

    .food-details {
        margin-bottom: 25px;
        padding: 15px;
        background: #f8f9fa;
        border-radius: 8px;
    }

    .food-details p {
        margin: 10px 0;
        font-size: 15px;
        color: #444;
    }

    label {
        display: block;
        margin-top: 15px;
        font-weight: bold;
        color: #444;
    }

    input {
        width: 100%;
        padding: 10px;
        margin-top: 6px;
        border: 1px solid #ccc;
        border-radius: 6px;
        font-size: 14px;
    }

    button {
        width: 100%;
        margin-top: 25px;
        padding: 12px;
        background-color: #28a745;
        color: white;
        border: none;
        border-radius: 6px;
        font-size: 15px;
        cursor: pointer;
    }

    button:hover {
        background-color: #1e7e34;
    }

    .back-link {
        text-align: center;
        margin-top: 20px;
    }

    .back-link a {
        text-decoration: none;
        color: #007bff;
        font-weight: bold;
    }

    .back-link a:hover {
        text-decoration: underline;
    }
</style>
</head>
<body>

<div class="container">

    <h2>Place Your Order</h2>

    <div class="food-details">
        <p><strong>Food Name:</strong> ${food.name}</p>
        <p><strong>Description:</strong> ${food.description}</p>
        <p><strong>Price:</strong> ₹ ${food.price}</p>
        <p><strong>Status:</strong>
            <c:choose>
                <c:when test="${food.available}">
                    Available
                </c:when>
                <c:otherwise>
                    Not Available
                </c:otherwise>
            </c:choose>
        </p>
    </div>

    <form action="${pageContext.request.contextPath}/order-page/place-order" method="post">

        <!-- Logged in User ID -->
        <input type="hidden"
               name="userId"
               value="${sessionScope.loggedInUser.id}" />
		
        <!-- Selected Food ID -->
        <input type="hidden"
               name="foodId"
               value="${food.id}" />
		
        <label for="quantity">Enter Quantity</label>
        <input type="number"
               id="quantity"
               name="quantity"
               min="1"
               required />

        <button type="submit">Confirm Order</button>

    </form>
	<c:if test="${not empty msg}">
	    <div style="color:green; font-weight:bold;">
	        ${msg}
	    </div>
	</c:if>
    <div class="back-link">
        <a href="${pageContext.request.contextPath}/food/menu">
            ← Back to Menu
        </a>
    </div>

</div>

</body>
</html>