<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update elective</title>
    <jsp:include page="../head/adminTableHead.jsp"/>
</head>
<body>
<div class="container">
    <form:form commandName="electiveDto">
        <div class="input-group input-group-lg">
            <div class="form-group">
                <label for="name">Name:</label>
                <form:input type="text" minlength="1" maxlength="30" class="form-control" path="name" id="name"
                            placeholder="Enter name"/>
            </div>
            <div class="form-group">
                <label for="course">Course:</label>
                <form:input type="number" min="1" max="6" class="form-control" path="course" id="course"
                            placeholder="Enter course"/>
            </div>
            <div class="form-group">
                <label for="teacherId">Teacher:</label>
                <form:select path="teacherId" class="form-control">
                    <c:forEach var="item" items="${teachers}">
                        <option value="${item.id}">${item.lastName} ${item.firstName} ${item.middleName}</option>
                    </c:forEach>
                </form:select>
            </div>
        </div>
        <button type="submit" formmethod="post" class="btn btn-primary">Submit</button>
    </form:form>
</div>
</body>
</html>
