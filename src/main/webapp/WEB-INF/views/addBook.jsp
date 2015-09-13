<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Add Author Page</title>
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
    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/authors">Authors</a></li>
  </ul>
  <div class="row">
    <h3>All authors and a list of books they've written</h3>
    <c:set var="action" value="${pageContext.request.contextPath}/book/add" />
    <c:if test="${parameter eq 'update'}">
      <c:set var="action" value="${pageContext.request.contextPath}/book/update" />
    </c:if>
    <form:form method="post" commandName="book" action="${action}">
      <form:label path="title">Title</form:label>
      <form:input type="text" path="title" />
      <form:label path="genre">Genre</form:label>
      <form:input type="text" path="genre" />
      <form:select path="authorId">
        <form:option value="0" label="--- Select ---"/>
        <c:forEach var="author" items="${authors}">
          <form:option value="${author.id}">${author.lastName}, ${author.firstName}</form:option>
        </c:forEach>
      </form:select>

      <form:button type="submit">Submit</form:button>
    </form:form>

  </div>
</div>
<!-- jQuery first, then Bootstrap JS. -->
<script src="${pageContext.request.contextPath}/static/js/jquery-2.1.4.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
</body>
</html>
