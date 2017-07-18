<html>
<head>
    <title>Elective</title>
    <jsp:include page="../head.jsp"/>
</head>
<body>
<div class="container">

    <h2>#${elective.id} elective</h2>

    <form>
        <h3>Name: ${elective.name}<br>
            Course: ${elective.course}<br>
            First name: ${elective.teacher.firstName}<br>
            Middle name: ${elective.teacher.middleName}<br>
            Last name: ${elective.teacher.lastName}<br>
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