<html>
<head>
    <title>Practice</title>
    <jsp:include page="../head.jsp"/>
</head>
<body>
<div class="container">

    <h2>#${practice.id} practice</h2>

    <form>
        <h3>Name: ${practice.name}<br>
            Course: ${practice.course}<br>
            First name: ${practice.teacher.firstName}<br>
            Middle name: ${practice.teacher.middleName}<br>
            Last name: ${practice.teacher.lastName}<br>
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