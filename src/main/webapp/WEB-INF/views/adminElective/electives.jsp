<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Electives</title>
    <jsp:include page="../head.jsp"/>
</head>
<body>
<div class="container">

    <h2>Electives</h2>

    <table class="table table-striped table-bordered">
        <thead>
        <tr align="center">
            <th>Name</th>
            <th>Course</th>
            <th>First name</th>
            <th>Middle name</th>
            <th>Last name</th>
        </tr>
        </thead>
        <c:forEach items="${electives}" var="elective">
            <tr>
                <td>${elective.name}</td>
                <td>${elective.course}</td>
                <td>${elective.teacher.firstName}</td>
                <td>${elective.teacher.middleName}</td>
                <td>${elective.teacher.lastName}</td>
                <td><a href="/admin/elective/${elective.id}">Details</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>