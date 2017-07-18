<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add student</title>
    <jsp:include page="../head/adminTableHead.jsp"/>
</head>
<body>
<div class="container">
    <form:form commandName="studentDto">
        <div class="input-group input-group-lg">
            <div class="form-group">
                <label for="firstName">FirstName:</label>
                <form:input type="text" minlength="1" maxlength="30" class="form-control" path="firstName"
                            id="firstName"
                            placeholder="Enter firstname"/>
            </div>
            <div class="form-group">
                <label for="lastName">LastName:</label>
                <form:input type="text" minlength="1" maxlength="30" class="form-control" path="lastName" id="lastName"
                            placeholder="Enter lastname"/>
            </div>
            <div class="form-group">
                <label for="middleName">MiddleName:</label>
                <form:input type="text" minlength="1" maxlength="30" class="form-control" path="middleName"
                            id="middleName"
                            placeholder="Enter middlename"/>
            </div>
            <div class="form-group">
                <label for="group">Group:</label>
                <form:input type="text" minlength="1" maxlength="30" class="form-control" path="group" id="group"
                            placeholder="Enter group"/>
                <div class="form-group">
                    <label for="login">Login:</label>
                    <form:input type="text" minlength="1" maxlength="30" class="form-control" path="login" id="login"
                                placeholder="Enter login"/>
                </div>
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <form:input type="password" minlength="1" maxlength="30" class="form-control" path="password" id="password"
                            placeholder="Enter password"/>
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
                        <option value="${item.id}">${item.firstName} ${item.lastName} ${item.middleName}</option>
                    </c:forEach>
                </form:select>
            </div>
            <div class="form-group">
                <label for="labId">Laboratory:</label>
                <form:select path="labId" class="form-control">
                    <c:forEach var="item" items="${labs}">
                        <option value="${item.id}"> ${item.name}
                    </c:forEach>
                </form:select>
            </div>
            <div class="form-group">
                <label for="electiveId">Elective:</label>
                <form:select path="electiveId" class="form-control">
                    <c:forEach var="item" items="${electives}">
                        <option value="${item.id}">${item.name} Course: ${item.course}
                    </c:forEach>
                </form:select>
            </div>
            <div class="form-group">
                <label for="practiceId">Practice:</label>
                <form:select path="practiceId" class="form-control">
                    <c:forEach var="item" items="${practices}">
                        <option value="${item.id}">${item.name} Course: ${item.course}
                    </c:forEach>
                </form:select>
            </div>
        </div>
        <button type="submit" formmethod="post" class="btn btn-primary">Submit</button>
    </form:form>
</div>
</body>
</html>
