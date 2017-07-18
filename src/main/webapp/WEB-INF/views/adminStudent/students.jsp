<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Students</title>
    <jsp:include page="../head/adminTableHead.jsp"/>
</head>
<body>
<div class="container">

    <h2>Students</h2>

    <table class="table table-striped table-bordered">
        <thead>
        <tr align="center">
            <th>First name</th>
            <th>Last Name</th>
            <th>Middle name</th>
            <th>Course</th>
            <th>Group</th>
        </tr>
        </thead>
        <c:forEach items="${students}" var="student">
            <tr>
                <td>${student.firstName}</td>
                <td>${student.lastName}</td>
                <td>${student.middleName}</td>
                <td>${student.course}</td>
                <td>${student.group}</td>

                <td><a href="/admin/student/${student.id}">Details</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>