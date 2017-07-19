<html>
<head>
    <title>Lab</title>
    <jsp:include page="../head/adminTableHead.jsp"/>
</head>
<body>
<div class="container">
    <form>
        <h3>Lab name: ${lab.name}<br>
            Teacher: ${lab.teacher.lastName} ${lab.teacher.firstName} ${lab.teacher.middleName}<br>
        </h3>
        <button class="btn btn-primary" formaction="/admin/lab/${lab.id}/delete" formmethod="post">
            Delete
        </button>
        <button class="btn btn-primary" formaction="/admin/lab/${lab.id}/update" formmethod="get">
            Update
        </button>
    </form>
</div>
</body>
</html>