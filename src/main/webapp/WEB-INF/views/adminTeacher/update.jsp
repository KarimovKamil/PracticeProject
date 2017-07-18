<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update teacher</title>
    <jsp:include page="../head.jsp"/>
</head>
<body>
<div class="container">
    <form:form commandName="teacherDto">
        <div class="input-group input-group-lg">
            <div class="form-group">
                <label for="firstName">First name:</label>
                <form:input type="text" minlength="1" maxlength="30" class="form-control" path="firstName" id="firstName"
                            placeholder="Enter firstname"/>
            </div>
            <div class="form-group">
                <label for="lastName">Last name:</label>
                <form:input type="text" minlength="1" maxlength="30" class="form-control" path="lastName" id="lastName"
                            placeholder="Enter lastname"/>
            </div>
            <div class="form-group">
                <label for="middleName">Middle name:</label>
                <form:input type="text" minlength="1" maxlength="30" class="form-control" path="middleName" id="middleName"
                            placeholder="Enter middlename"/>
            </div>
            <button type="submit" formmethod="post" class="btn btn-primary">Submit</button>
        </div>
    </form:form>
</div>
</body>
</html>
