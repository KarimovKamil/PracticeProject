<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add elective</title>
<<<<<<< Updated upstream:src/main/webapp/WEB-INF/views/adminElective/addElective.jsp
    <jsp:include page="../head.jsp"/>
=======
    <jsp:include page="head/head.jsp"/>
>>>>>>> Stashed changes:src/main/webapp/WEB-INF/views/addelective.jsp
</head>
<body>
<div class="container">
    <form:form commandName="electivedto">
        <div class="input-group input-group-lg">
            <div class="form-group">
                <label for="name">Name:</label>
                <form:input type="text" minlength="1" maxlength="30" class="form-control" path="name" id="name"
                            placeholder="Enter name"></form:input>
            </div>
            <div class="form-group">
                <label for="course">Course:</label>
                <form:input type="number" min="1" max="6" class="form-control" path="course" id="course"
                            placeholder="Enter course"></form:input>
            </div>
            <div class="form-group">
                <form:select path="teacherId">
                    <c:forEach var="item" items="${teachers}">
                        <option value="${item.id}">${item.firstName} ${item.middleName} ${item.lastName}</option>
                    </c:forEach>
                </form:select>
            </div>
        </div>
        <button type="submit" formmethod="post" class="btn btn-primary">Submit</button>
    </form:form>
</div>
</body>
</html>
