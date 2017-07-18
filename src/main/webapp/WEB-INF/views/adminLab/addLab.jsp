<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add lab</title>
    <jsp:include page="../head.jsp"/>
</head>
<body>
<div class="container">
    <form:form commandName="labDto">
        <div class="input-group input-group-lg">
            <div class="form-group">
                <label for="name">Lab name:</label>
                <form:input type="text" minlength="1" maxlength="30" class="form-control" path="name" id="name"
                            placeholder="Enter lab name"/>
            </div>
            <div class="form-group">
                <label for="teacherId">Teacher:</label>
                <form:select path="teacherId" class="form-control">
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
