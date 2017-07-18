<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Labs</title>
    <jsp:include page="../head/adminTableHead.jsp"/>
</head>
<body>
<div class="container">

    <h2>Practices</h2>

    <table class="table table-striped table-bordered">
        <thead>
        <tr align="center">
            <th>Name</th>
            <th>Teacher</th>
            <th></th>
        </tr>
        </thead>
        <c:forEach items="${labs}" var="lab">
            <tr>
                <td>${lab.name}</td>
                <td>${lab.teacher.lastName} ${lab.teacher.firstName} ${lab.teacher.middleName}</td>
                <td><a href="/admin/lab/${lab.id}">Details</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>