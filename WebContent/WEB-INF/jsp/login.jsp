<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<html>
	<head>
	<title>GLS Portal</title>
	<link rel="stylesheet" href="resources/css/bootstrap.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/bootstrap-theme.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/login.css">
	<script src="${pageContext.request.contextPath}/resources/script/jquery-1.10.2.min.js"></script>
	<script src="<%=request.getContextPath() %>/resources/script/bootstrap.min.js"></script>
	</head>
	<body>
		<div class="container">
    	<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="panel panel-login">
					<div class="panel-heading">
						<div class="row">
							<div class="col-xs-6">
								<!-- <a href="#" class="active" id="login-form-link">GLS Portal</a> -->
								<h2>GLS Portal</h2>  
							</div>
						</div>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-12">
								<form name="form.f" action="<c:url value="j_spring_security_check" />" method="POST" role="form" style="display: block;">
									<div class="form-group">
										<label for="username">User Name</label>
										<input type="text" class="form-control" name='j_username' id="username" placeholder="Username" required/>
									</div>
									<div class="form-group">
										<label for="password">Password</label>
										<input type="password" class="form-control" name='j_password' id="password" placeholder="Password" required/>
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-sm-6 col-sm-offset-3">
												<button type="submit" class="btn btn-primary">Submit</button>&nbsp;
												<button type="reset" class="btn btn-primary">Reset</button>
											</div>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</body>
</html>