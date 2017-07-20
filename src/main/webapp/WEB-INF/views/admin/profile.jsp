<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin profile</title>
    <jsp:include page="../head/adminHead.jsp"/>
</head>
<body>
<div class="container">
    <form>
        <h3>${user.lastName} ${user.firstName} ${user.middleName}
        </h3>
        <button class="btn btn-primary" formaction="/admin/request/active" formmethod="get">
            Show active requests
        </button>
        <button class="btn btn-primary" formaction="/admin/student/all" formmethod="get">
            Show all students
        </button>
        <button class="btn btn-primary" formaction="/admin/teacher/all" formmethod="get">
            Show all teachers
        </button>
        <button class="btn btn-primary" formaction="/admin/lab/all" formmethod="get">
            Show all laboratories
        </button>
        <button class="btn btn-primary" formaction="/admin/practice/all" formmethod="get">
            Show all practices
        </button>
        <button class="btn btn-primary" formaction="/admin/elective/all" formmethod="get">
            Show all electives
        </button>
        <button class="btn btn-primary" formaction="/admin/addAdmin" formmethod="get">
            Add new admin
        </button>
    </form>
</div>
</body>
</html>
