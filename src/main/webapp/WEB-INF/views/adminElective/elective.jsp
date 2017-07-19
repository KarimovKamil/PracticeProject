<html>
<head>
    <title>Elective</title>
    <jsp:include page="../head/adminTableHead.jsp"/>
</head>
<body>
<div class="container">
    <form>
        <h3>Name: ${elective.name}<br>
            Course: ${elective.course}<br>
            Teacher: ${elective.teacher.lastName} ${elective.teacher.firstName} ${elective.teacher.middleName}<br>
        </h3>
        <button class="btn btn-primary" formaction="/admin/elective/${elective.id}/delete" formmethod="post">
            Delete
        </button>
        <button class="btn btn-primary" formaction="/admin/elective/${elective.id}/update" formmethod="get">
            Update
        </button>
    </form>
</div>
</body>
</html>