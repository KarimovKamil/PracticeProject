<html>
<head>
    <title>Sign in</title>
    <jsp:include page="../head/adminHead.jsp"/>
</head>
<body>
<div class="container">
    <h2>Admin Login</h2>
    <form>
        <div class="input-group input-group-lg">
            <div class="form-group">
                <label for="login">Login:</label>
                <input type="text" class="form-control" required name="login" id="login" placeholder="Enter login">
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" class="form-control" required name="password" id="password"
                       placeholder="Enter password">
            </div>
        </div>
        <br>
        <button type="submit" formmethod="post" class="btn btn-primary">
            Sign in
        </button>
    </form>
    <form>
        <button class="btn btn-primary" formaction="/login" formmethod="get">
            Login
        </button>
    </form>
</div>
</body>
</html>