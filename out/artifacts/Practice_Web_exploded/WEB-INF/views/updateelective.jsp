<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update elective</title>
    <jsp:include page="head.jsp"/>
</head>
<body>
<div class="container">
    <form>
        <div class="input-group input-group-lg">
            <div class="form-group">
                <label for="name">Name:</label>
                <input type="text" pattern="[]|(([a-zA-Z]+ ?)*[a-zA-Z]+)" class="form-control" name="name" id="name"
                       placeholder="Enter name" required value="${elective.name}">
            </div>
            <div class="form-group">
                <label for="course">Course:</label>
                <input type="number" min="1" max="6" class="form-control" name="course" id="course"
                       placeholder="Enter course"
                       required value="${elective.course}">
            </div>
            <div class="form-group">
                <select name="teacherId">
                    <c:forEach var="item" items="${teachers}">
                        <option value="${item.id}">${item.firstName} ${item.middleName} ${item.lastName}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <button type="submit" formmethod="post" class="btn btn-primary">Submit</button>
    </form>
</div>
</body>
</html>
