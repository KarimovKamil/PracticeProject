<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add admin</title>
    <jsp:include page="../head/adminHead.jsp"/>
</head>
<body>
<div class="container">
    <form:form commandName="adminDto">
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
                <label for="login">Login:</label>
                <form:input type="text" minlength="6" maxlength="30" class="form-control" path="login" id="login"
                            placeholder="Enter login"/>
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <form:input type="password" minlength="6" maxlength="30" class="form-control" path="password" id="password"
                            placeholder="Enter password"/>
            </div>
        </div>
        <button type="submit" formmethod="post" class="btn btn-primary">Submit</button>
    </form:form>
</div>
</body>
</html>

