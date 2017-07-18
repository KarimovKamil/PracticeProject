<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Practices</title>
    <jsp:include page="../head.jsp"/>
</head>
<body>
<div class="container">

    <h2>Practices</h2>

    <table class="table table-striped table-bordered">
        <thead>
        <tr align="center">
            <th>Name</th>
            <th>Course</th>
            <th>First name</th>
            <th>Middle name</th>
            <th>Last name</th>
            <th>Start date</th>
            <th>End date</th>
        </tr>
        </thead>
        <c:forEach items="${practices}" var="practice">
            <tr>
                <td>${practice.name}</td>
                <td>${practice.course}</td>
                <td>${practice.teacher.firstName}</td>
                <td>${practice.teacher.middleName}</td>
                <td>${practice.teacher.lastName}</td>
                <td>${practice.startDate}</td>
                <td>${practice.endDate}</td>
                <td><a href="/admin/practice/${practice.id}">Details</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>