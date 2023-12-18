<%@ page contentType="text/html" %>
<%@ page isELIgnored="false" %>
<html>
<head></head>
<body>

<p>Id: ${user.id}</p>
<p>Name: ${user.fullname}</p>
<p>Email: ${user.email}</p>
<p>Gender: ${user.gender}</p>
<p>DOB: ${user.dob}</p>
<p> Quata:</p>

<c:forEach var="quata" items="${user.quataValues}">
    <p>${quata.name}</p>
</c:forEach>

<p>Country: ${user.country}</p>

</body>
</html>
