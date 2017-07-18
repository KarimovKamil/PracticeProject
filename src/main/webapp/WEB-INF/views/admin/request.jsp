<html>
<head>
    <title>Request</title>
    <jsp:include page="../head/adminRequestHead.jsp"/>
</head>
<body>
<div class="container">
    <form>
        <h3>Request message: ${request.name}<br>
            Date: ${reqest.date}<br>
            Student: ${request.student.middleName} ${request.student.firstName} ${request.student.lastName}<br>
            Type: ${request.type}<br>
            Status: ${request.status}<br>
        </h3>
        <button class="btn btn-primary" formaction="/admin/request/${request.id}/accept" formmethod="post">
            Accept
        </button>
        <button class="btn btn-primary" formaction="/admin/request/${request.id}/decline" formmethod="post">
            Decline
        </button>
    </form>
</div>
</body>
</html>