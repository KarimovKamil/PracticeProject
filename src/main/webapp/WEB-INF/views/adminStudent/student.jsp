<html>
<head>
    <title>Student</title>
    <jsp:include page="../head/adminTableHead.jsp"/>
</head>
<body>
<div class="container">

    <form>
        <h3>First name: ${student.firstName}<br>
            Last Name: ${student.lastName}<br>
            Middle name: ${student.middleName}<br>
            Course: ${student.course}<br>
            Group: ${student.group}<br>
            Lab: ${student.lab}<br>
            Elective: ${student.elective}<br>
            Practice: ${student.practice}<br>
            Teacher: ${student.teacher.firstName} ${student.teacher.lastName} ${student.teacher.middleName}
        </h3>
        <button class="btn btn-primary" formaction="/admin/student/${student.id}/delete" formmethod="post">
            Delete
        </button>
        <button class="btn btn-primary" formaction="/admin/student/${student.id}/update" formmethod="get">
            Update
        </button>
    </form>
</div>
</body>
</html>