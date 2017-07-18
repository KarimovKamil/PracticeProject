<html>
<head>
    <title>Elective</title>
<<<<<<< Updated upstream:src/main/webapp/WEB-INF/views/adminElective/elective.jsp
    <jsp:include page="../head.jsp"/>
=======
    <jsp:include page="head/head.jsp"/>
>>>>>>> Stashed changes:src/main/webapp/WEB-INF/views/elective.jsp
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