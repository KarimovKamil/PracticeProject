<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Teacher</title>
    <jsp:include page="../head/adminTableHead.jsp"/>
</head>
<body>
<div class="container">

    <h2>#${teacher.id} teacher</h2>

    <form>
        <h3>First name: ${teacher.firstName}<br>
            Last name: ${teacher.lastName}<br>
            Midde name: ${teacher.middleName}<br>
        </h3>
        <button class="btn btn-primary" formaction="/admin/teacher/${teacher.id}/delete" formmethod="post">
            Delete
        </button>
        <button class="btn btn-primary" formaction="/admin/teacher/${teacher.id}/update" formmethod="get">
            Update
        </button>
    </form>
</div>
</body>
</html>