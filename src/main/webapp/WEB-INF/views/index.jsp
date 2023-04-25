<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Oh my code!</h1>
<a href="${pageContext.request.contextPath}/cinema-halls">
    <input type="button" value="Cinema halls" />
</a><br><br>
<a href="${pageContext.request.contextPath}/movies">
    <input type="button" value="Movies" />
</a><br><br>
<a href="${pageContext.request.contextPath}/movie-sessions/available?movieId=1&date=25-04-2023">
    <input type="button" value="movieId=1&date=25-04-2023" />
</a>
</body>
</html>
