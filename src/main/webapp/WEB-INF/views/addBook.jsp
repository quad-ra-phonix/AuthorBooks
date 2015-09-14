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
    <li role="presentation"><a href="${pageContext.request.contextPath}/books">Books</a></li>
    <li role="presentation"><a href="${pageContext.request.contextPath}/authors">Authors</a></li>
  </ul>
  <div class="row">
    <div class="col-md-4"></div>
    <div class="col-md-4">
        <c:set var="action" value="${pageContext.request.contextPath}/book/add" />
        <c:if test="${parameter eq 'update'}">
            <c:set var="action" value="${pageContext.request.contextPath}/book/update" />
        </c:if>
        <form:form method="post" commandName="book" action="${action}">
        <div class="panel panel-default">
          <div class="panel-heading">
            <h3 class="panel-title">Add book</h3>
          </div>
          <div class="panel-body">
            <div class="row">
              <div class="col-xs-6">
                  <form:label path="title">Title</form:label>
              </div>
              <div class="col-xs-6">
                  <form:input type="text" path="title" />
              </div>
            </div>
            <div class="row">
              <div class="col-xs-6">
                  <form:label path="genre">Genre</form:label>
              </div>
              <div class="col-xs-6">
                  <form:input type="text" path="genre" />
              </div>
            </div>
            <div class="row">
              <div class="col-xs-6">
                <form:label path="authorId">Author</form:label>
              </div>
              <div class="col-xs-6">
                  <form:select path="authorId">
                      <form:option value="0" label="--- Select ---"/>
                      <c:forEach var="author" items="${authors}">
                          <form:option value="${author.id}">${author.lastName}, ${author.firstName}</form:option>
                      </c:forEach>
                  </form:select>
              </div>
            </div>
          </div>
          <div class="panel-footer">
            <form:button>Submit</form:button>
          </div>
        </div>
      </form:form>
    </div>
    <div class="col-md-4"></div>
  </div>
</div>
<!-- jQuery first, then Bootstrap JS. -->
<script src="${pageContext.request.contextPath}/static/js/jquery-2.1.4.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
</body>
</html>
