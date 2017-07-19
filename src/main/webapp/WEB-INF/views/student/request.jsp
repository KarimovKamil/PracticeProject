<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Request</title>
    <jsp:include page="../head/head.jsp"/>
</head>
<body>
<div class="container">
    <form>
        <h3>Date: ${request.date}<br>
            Type: ${request.type}<br>
            Status: ${request.status}<br>
            Request Message: ${request.reqMessage}<br>
            Response Message: ${request.resMessage}<br>
        </h3>
        <button class="btn btn-primary" formaction="/request/${request.id}/delete" formmethod="post">
            Delete
        </button>
    </form>
</div>
</body>
</html>