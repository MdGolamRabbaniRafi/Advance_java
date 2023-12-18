<%@ page contentType="text/html" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="dev.domain.User" %>
<html>
<head></head>
<body>
<h2>Student List</h2>
<c:forEach var="user" items="${userList}">
    <p>Id: ${user.id}</p>
    <p>Name: ${user.fullname}</p>
    <p>Email: ${user.email}</p>
    <p>Gender: ${user.gender}</p>
    <p>DOB: ${user.dob}</p>
    <p> Quata:</p>
    <c:forEach var="quata" items="${user.quataValues}">
        <p>${quata}</p>
    </c:forEach>

    <p>Country: ${user.country}</p>
    <hr>
</c:forEach>

</body>
</html>
