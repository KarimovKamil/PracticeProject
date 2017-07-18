<html>
<head>
    <title>Practice</title>
    <jsp:include page="../head/adminTableHead.jsp"/>
</head>
<body>
<div class="container">
    <form>
        <h3>Name: ${practice.name}<br>
            Course: ${practice.course}<br>
            Teacher: ${practice.teacher.lastName} ${practice.teacher.firstName} ${practice.teacher.middleName}<br>
            Start date: ${practice.startDate}<br>
            End date: ${practice.endDate}<br>
        </h3>
        <button class="btn btn-primary" formaction="/admin/practice/${practice.id}/delete" formmethod="post">
            Delete
        </button>
        <button class="btn btn-primary" formaction="/admin/practice/${practice.id}/update" formmethod="get">
            Update
        </button>
    </form>
</div>
</body>
</html>