
<!DOCTYPE html>
<html>
<head>
    <title>Registration Page</title>
</head>
<body>
    <form action="IndexServlet" method="post">
        <label>Email:</label>
        <input type="text" name="email" required><br>
        <label>Full Name:</label>
        <input type="text" name="fullname" required><br>
        <label>Password:</label>
        <input type="password" name="password" required><br>
        <input type="submit" value="Register">
    </form>
    <form action="login.jsp" method="get">
            <input type="submit" value="Already Register?">
        </form>

</body>
</html>


