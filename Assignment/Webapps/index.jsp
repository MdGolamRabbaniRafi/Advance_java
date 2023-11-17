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
        <input type="date" name="dateOfBirth" required><br>
        
        <label>Email:</label>
        <input type="email" name="email" required><br>
        
        <label>Joining Date (yyyy-MM-dd):</label>
        <input type="date" name="joiningDate" required><br>
        
        <label>Employee Type :</label>
        <select name="employeeType">
                <option selected disabled>Employee Type</option>

                    <option value="1">Officer </option>
                    <option value="2">Stuff </option>

            </select><br />
    <input type="submit" name="addButton" value="Add">
    </form>
    <form action="/Lab_Task_1/EmployeeServlet" method="post">
        <input type="submit" name="detailsButton" value="Details">
    </form>
</body>
</html>
