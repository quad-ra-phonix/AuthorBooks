<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required meta tags always come first -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Welcome</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap-theme.min.css"/>
</head>
<body>
<div class="container">
    <ul class="nav nav-tabs">
        <li role="presentation"><a href="/">Home</a></li>
        <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/books">Books</a></li>
        <li role="presentation"><a href="${pageContext.request.contextPath}/authors">Authors</a></li>
    </ul>
    <div class="row">
        <div class="col-lg-12">
            <h3>All books with author's last name and first name</h3>

            <table class="table table-striped table-bordered">
                <thead>
                <tr>
                    <th>Title</th>
                    <th>Author</th>
                    <th>Genre</th>
                    <th></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="book" items="${books}">
                    <tr>
                        <td>${book.title}</td>
                        <td>${book.author.lastName}, ${book.author.firstName}</td>
                        <td>${book.genre}</td>
                        <td>
                            <button class="btn btn-warning">Edit</button>
                        </td>
                        <td>
                            <button class="btn btn-danger">Delete</button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<!-- jQuery first, then Bootstrap JS. -->
<script src="${pageContext.request.contextPath}/static/js/jquery-2.1.4.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
</body>
</html>