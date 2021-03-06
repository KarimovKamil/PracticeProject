<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Labs</title>
    <jsp:include page="../head/adminTableHead.jsp"/>
</head>
<body>
<div class="container">

    <form>
        <h2>Labs</h2>
        <button class="btn btn-primary" formaction="/admin/lab/add" formmethod="get">
            Add new
        </button>
    </form>

    <table class="table table-striped table-bordered">
        <thead>
        <tr align="center">
            <th>Lab name</th>
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