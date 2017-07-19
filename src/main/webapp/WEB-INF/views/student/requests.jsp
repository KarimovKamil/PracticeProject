<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Requests</title>
    <jsp:include page="../head/head.jsp"/>
</head>
<body>
<div class="container">

    <h2>Requests</h2>

    <table class="table table-striped table-bordered">
        <thead>
        <tr align="center">
            <th>Date</th>
            <th>Type</th>
            <th>Status</th>
            <th>reqMessage</th>
            <th></th>
        </tr>
        </thead>
        <c:forEach items="${requests}" var="request">
            <tr>
                <td>${request.date}</td>
                <td>${request.type}</td>
                <td>${request.status}</td>
                <td>${request.reqMessage}</td>

                <td><a href="/request/${request.id}">Details</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>