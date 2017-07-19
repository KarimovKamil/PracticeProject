<html>
<head>
    <title>Profile</title>
    <jsp:include page="../head/head.jsp"/>
</head>
<body>
<div class="container">
    <form>
        <h3>Full name: ${profileDto.lastName} ${profileDto.firstName} ${profileDto.middleName}<br>
            Group: ${profileDto.group}<br>
            Course: ${profileDto.course}<br>
            Laboratory: ${profileDto.lab}<br>
            Elective: ${profileDto.elective}<br>
            Practice: ${profileDto.practice}<br>
            Teacher: ${profileDto.teachersLastName} ${profileDto.teachersFirstName}<br>
        </h3>
        <button class="btn btn-primary" formaction="/request/all" formmethod="get">
            Show my requests
        </button>
        <button class="btn btn-primary" formaction="/request/lab" formmethod="get">
            Change laboratory
        </button>
        <button class="btn btn-primary" formaction="/request/elective" formmethod="get">
            Change elective
        </button>
        <button class="btn btn-primary" formaction="/request/practice" formmethod="get">
            Change practice
        </button>
        <button class="btn btn-primary" formaction="/request/teacher" formmethod="get">
            Change teacher
        </button>
    </form>
</div>
</body>
</html>
