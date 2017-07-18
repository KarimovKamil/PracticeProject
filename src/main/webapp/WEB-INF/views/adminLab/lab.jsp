<html>
<head>
    <title>Lab</title>
    <jsp:include page="../head.jsp"/>
</head>
<body>
<div class="container">

    <h2>#${lab.id} lab</h2>

    <form>
        <h3>Lab name: ${lab.name}<br>
            Teacher: ${lab.teacher.lastName}  ${lab.teacher.middleName}<br>
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