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
    <form:form method="post" commandName="author">
      <form:label path="firstName">First name</form:label>
      <form:input type="text" path="firstName" />
      <form:label path="lastName">Last name</form:label>
      <form:input type="text" path="lastName" />
      <form:label path="dateOfBirth">Date of birth</form:label>
      <form:input type="text" path="dateOfBirth" />
      <form:button type="submit">Submit</form:button>
    </form:form>

  </div>
</div>
<!-- jQuery first, then Bootstrap JS. -->
<script src="${pageContext.request.contextPath}/static/js/jquery-2.1.4.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
</body>
</html>
