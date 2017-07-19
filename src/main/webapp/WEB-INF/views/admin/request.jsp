<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Request</title>
    <jsp:include page="../head/adminRequestHead.jsp"/>
</head>
<body>
<div class="container">
    <form>
        <h3>Date: ${reqest.date}<br>
            Student: ${request.student.lastName} ${request.student.firstName} ${request.student.middleName}<br>
            Type: ${request.type}<br>
            Status: ${request.status}<br>
            Request message: ${request.reqMessage}<br>
        </h3>

        <c:choose>
            <c:when test="${request.status=='ACTIVE'}">
                <div class="form-group">
                    <label for="message">Response message:</label>
                    <input type="text" maxlength="255" class="form-control" id="message" name="message"
                           placeholder="Enter response message">
                </div>
                <button class="btn btn-primary" formaction="/admin/request/${request.id}/accept" formmethod="post">
                    Accept
                </button>
                <button class="btn btn-primary" formaction="/admin/request/${request.id}/decline" formmethod="post">
                    Decline
                </button>
            </c:when>
        </c:choose>
    </form>
</div>
</body>
</html>