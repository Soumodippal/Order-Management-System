<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>

<style>
    body {
        margin: 0;
        padding: 0;
        font-family: Arial, sans-serif;
        background: #f4f6f9;
    }

    .container {
        width: 400px;
        margin: 80px auto;
        background: #ffffff;
        padding: 30px;
        border-radius: 10px;
        box-shadow: 0px 0px 12px rgba(0,0,0,0.1);
    }

    h2 {
        text-align: center;
        color: #333;
        margin-bottom: 25px;
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

    .register-link {
        text-align: center;
        margin-top: 20px;
    }

    .register-link a {
        text-decoration: none;
        color: #007bff;
        font-weight: bold;
    }

    .register-link a:hover {
        text-decoration: underline;
    }

    .error-message {
        text-align: center;
        color: red;
        margin-top: 15px;
        font-size: 14px;
    }
</style>
</head>
<body>

<div class="container">

    <h2>User Login</h2>
	
	<c:if test="${not empty error}">
		<h3> User Doesn't Exists </h3>
		</c:if>

    <form action="${pageContext.request.contextPath}/user/login" method="post">
        <label for="email">Email Address</label>
        <input 
            type="email" 
            id="email" 
            name="email" 
            placeholder="Enter your email"
            required>

        <label for="password">Password</label>
        <input 
            type="password" 
            id="password" 
            name="password" 
            placeholder="Enter your password"
            required>

        <button type="submit">Login</button>

    </form>

    <!-- Optional error message -->
    <div class="error-message">
        ${errorMessage}
    </div>

    <div class="register-link">
        Don't have an account?
        <a href="${pageContext.request.contextPath}/user/register">
            Register Here
        </a>
    </div>

</div>

</body>
</html>