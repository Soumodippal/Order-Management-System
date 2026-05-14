<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Food Menu</title>

<style>
    body {
        margin: 0;
        padding: 0;
        font-family: Arial, sans-serif;
        background: #f5f7fa;
    }

    .header {
        background: #2d89ef;
        color: white;
        padding: 20px;
        text-align: center;
        font-size: 24px;
        font-weight: bold;
    }

    .container {
        width: 85%;
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

    .food-grid {
        display: grid;
        grid-template-columns: repeat(auto-fit, minmax(280px, 1fr));
        gap: 20px;
    }

    .food-card {
        background: white;
        border-radius: 10px;
        padding: 20px;
        box-shadow: 0px 0px 10px rgba(0,0,0,0.08);
    }

    .food-name {
        font-size: 22px;
        font-weight: bold;
        color: #222;
        margin-bottom: 10px;
    }

    .food-description {
        color: #666;
        margin-bottom: 12px;
    }

    .food-price {
        font-size: 18px;
        color: #28a745;
        font-weight: bold;
        margin-bottom: 12px;
    }

    .food-status {
        margin-bottom: 15px;
        font-weight: bold;
    }

    .available {
        color: green;
    }

    .not-available {
        color: red;
    }

    .order-btn button {
        width: 100%;
        padding: 12px;
        background: #2d89ef;
        color: white;
        border: none;
        border-radius: 6px;
        cursor: pointer;
        font-size: 15px;
    }

    .order-btn button:hover {
        background: #1b5fbf;
    }
</style>
</head>
<body>

<div class="header">
    Cloud Kitchen Menu
</div>

<div class="container">

    <div class="top-bar">
        <div class="welcome">
            Welcome, ${sessionScope.loggedInUser.name}
        </div>

        <div class="logout-btn">
            <a href="${pageContext.request.contextPath}/user/logout">
                Logout
            </a>
        </div>
    </div>

    <div class="food-grid">

        <c:forEach var="food" items="${foodList}">

            <div class="food-card">

                <div class="food-name">
                    ${food.name}
                </div>
				
                <div class="food-description">
                    ${food.description}
                </div>

                <div class="food-price">
                    ₹ ${food.price}
                </div>

                <div class="food-status">
                    <c:choose>
                        <c:when test="${food.available}">
                            <span class="available">Available</span>
                        </c:when>
                        <c:otherwise>
                            <span class="not-available">Not Available</span>
                        </c:otherwise>
                    </c:choose>
                </div>

                <div class="order-btn">
                    <form action="${pageContext.request.contextPath}/order-page/order"
                          method="get">

                        <input type="hidden"
                               name="foodId"
                               value="${food.id}" />

                        <button type="submit"
                            <c:if test="${!food.available}">
                                disabled
                            </c:if>>
                            Order Now
                        </button>

                    </form>
                </div>

            </div>

        </c:forEach>

    </div>

</div>

</body>
</html>