<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Change practice</title>
    <jsp:include page="../head/head.jsp"/>
</head>
<body>
<div class="container">
    <form:form commandName="requestDto">
        <div class="input-group input-group-lg">
            <div class="form-group">
                <label for="attributeId"></label>
                <form:select path="attributeId" class="form-control">
                    <c:forEach var="item" items="${attributes}">
                        <option value="${item.id}">${item.name} Course: ${item.course}</option>
                    </c:forEach>
                </form:select>
            </div>
        </div>
        <button type="submit" formmethod="post" class="btn btn-primary">Submit</button>
    </form:form>
</div>
</body>
</html>
