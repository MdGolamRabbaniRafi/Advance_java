<!DOCTYPE html>
<html>
<head>
    <title>Employee Information Form</title>
</head>
<body>
<form action="/Lab_Task_1/EmployeeServlet" method="post">
        <label>ID:</label>
        <input type="text" name="id" required><br>

        <label>Name:</label>
        <input type="text" name="name" required><br>

        <label>Date of Birth (yyyy-MM-dd):</label>
        <input type="text" name="dateOfBirth" required><br>

        <label>Email:</label>
        <input type="text" name="email" required><br>

        <label>Joining Date (yyyy-MM-dd):</label>
        <input type="text" name="joiningDate" required><br>

        <label>Employee Type (1 for Officer, 2 for Staff):</label>
        <input type="text" name="employeeType" required><br>

        <input type="submit" value="Submit">
    </form>
</body>
</html>
