<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags always come first -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
	<title>Welcome</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap-theme.min.css" />
  </head>
  <body>
    <div class="container">
	    <ul class="nav nav-tabs">
		  <li role="presentation" class="active"><a href="/">Home</a></li>
			<li role="presentation"><a href="${pageContext.request.contextPath}/books">Books</a></li>
		  <li role="presentation"><a href="${pageContext.request.contextPath}/profile">Profile</a></li>
		  <li role="presentation"><a href="${pageContext.request.contextPath}/messages">Messages</a></li>
		</ul>
		<div class="jumbotron">
			<h1>Hello, world!</h1>
			<p>...</p>
		  	<p><a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a></p>
		</div>
    	<div class="row">
    		<div class="col-md-4">
    			<div class="panel panel-default">
  					<div class="panel-heading">
  						<div class="panel-title">
  							<h3>column 1</h3>
  						</div>
					</div>
  					<div class="panel-body">
    					Panel content
  					</div>
  					<div class="panel-footer">
  						<a href="#"><button class="btn btn-primary">more</button></a>
  					</div>
				</div>
    		</div>
    		<div class="col-md-4">
    			<div class="panel panel-default">
  					<div class="panel-heading">
  						<div class="panel-title">
  							<h3>column 2</h3>
  						</div>
					</div>
  					<div class="panel-body">
    					Panel content
  					</div>
  					<div class="panel-footer">
  						<a href="#"><button class="btn btn-primary">more</button></a>
  					</div>
				</div>
    		</div>
    		<div class="col-md-4">
    			<div class="panel panel-default">
  					<div class="panel-heading">
  						<div class="panel-title">
  							<h3>column 3</h3>
  						</div>
					</div>
  					<div class="panel-body">
    					Panel content
  					</div>
  					<div class="panel-footer">
  						<a href="#"><button class="btn btn-primary">more</button></a>
  					</div>
				</div>
    		</div>
    	</div>
    </div>
    <!-- jQuery first, then Bootstrap JS. -->
    <script src="${pageContext.request.contextPath}/static/js/jquery-2.1.4.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
  </body>
</html>