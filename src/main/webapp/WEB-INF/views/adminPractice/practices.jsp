<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Practices</title>
    <jsp:include page="../head/adminTableHead.jsp"/>
</head>
<body>
<div class="container">

    <h2>Practices</h2>

    <table class="table table-striped table-bordered">
        <thead>
        <tr align="center">
            <th>Name</th>
            <th>Course</th>
            <th>Teacher</th>
            <th>Start date</th>
            <th>End date</th>
        </tr>
        </thead>
        <c:forEach items="${practices}" var="practice">
            <tr>
                <td>${practice.name}</td>
                <td>${practice.course}</td>
                <td>${practice.teacher.lastName} ${practice.teacher.firstName} ${practice.teacher.middleName}</td>
                <td>${practice.startDate}</td>
                <td>${practice.endDate}</td>
                <td><a href="/admin/practice/${practice.id}">Details</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>