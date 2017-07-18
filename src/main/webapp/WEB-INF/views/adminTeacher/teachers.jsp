<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Teachers</title>
    <jsp:include page="../head/adminTableHead.jsp"/>
</head>
<body>
<div class="container">

    <h2>Teachers</h2>

    <table class="table table-striped table-bordered">
        <thead>
        <tr align="center">
            <th>First name</th>
            <th>Last name</th>
            <th>Middle name</th>
            <th></th>
        </tr>
        </thead>
        <c:forEach items="${teachers}" var="teacher">
            <tr>
                <td>${teacher.firstName}</td>
                <td>${teacher.lastName}</td>
                <td>${teacher.middleName}</td>

                <td><a href="/admin/teacher/${teacher.id}">Details</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>