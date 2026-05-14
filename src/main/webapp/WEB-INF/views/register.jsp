<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Registration</title>

<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f6f8;
        margin: 0;
        padding: 0;
    }

    .container {
        width: 400px;
        margin: 60px auto;
        background: #ffffff;
        padding: 30px;
        border-radius: 10px;
        box-shadow: 0px 0px 10px rgba(0,0,0,0.1);
    }

    h2 {
        text-align: center;
        margin-bottom: 25px;
        color: #333;
    }

    label {
        display: block;
        margin-top: 15px;
        font-weight: bold;
        color: #444;
    }

    input, select {
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
        background-color: #2d89ef;
        color: white;
        border: none;
        border-radius: 6px;
        font-size: 15px;
        cursor: pointer;
    }

    button:hover {
        background-color: #1b5fbf;
    }

    .login-link {
        text-align: center;
        margin-top: 20px;
    }

    .login-link a {
        text-decoration: none;
        color: #2d89ef;
        font-weight: bold;
    }

    .login-link a:hover {
        text-decoration: underline;
    }
</style>
</head>
<body>

<div class="container">

    <h2>Register Here</h2>
	<c:if test="${not empty msg}">
		<h3>User Addedd succesfully</h3>
	</c:if>
    <form action="${pageContext.request.contextPath}/user/register" method="post">
		
        <label for="name">Full Name</label>
        <input type="text" id="name" name="name" required>

        <label for="email">Email Address</label>
        <input type="email" id="email" name="email" required>

        <label for="password">Password</label>
        <input type="password" id="password" name="password" required>

        <label for="role">Select Role</label>
        <select id="role" name="role" required>
            <option value="">-- Select Role --</option>
            <option value="CUSTOMER">Customer</option>
            <option value="ADMIN">Admin</option>
        </select>

        <button type="submit">Register</button>

    </form>

    <div class="login-link">
        Already have an account?
        <a href="${pageContext.request.contextPath}/user/login">Login</a>
    </div>

</div>

</body>
</html>