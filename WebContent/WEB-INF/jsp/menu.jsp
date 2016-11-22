<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<s:eval expression="@propertyConfigurer.getProperty('role.admin')" var="roleAdmin" />
<s:eval expression="@propertyConfigurer.getProperty('role.user')" var="roleUser" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/bootstrap.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/menu.css">
	<script src="<%=request.getContextPath() %>/resources/script/jquery-1.10.2.min.js"></script>
	<script src="<%=request.getContextPath() %>/resources/script/bootstrap.min.js"></script>
</head>
<body>
	<div class="navbar-wrapper">
    <div class="container-fluid">
        <nav class="navbar navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">GLS Portal</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="#" class="">Home</a></li>
                        <sec:authorize access="hasRole('${roleAdmin}')">
                        <li class=" dropdown">
                            <a href="#" class="dropdown-toggle " data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Profile <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li class=" dropdown">
                                     <li><a href="<%= request.getContextPath() %>/profile.htm">Create Profile</a></li>
                                </li>
                                <li><a href="#">Edit Profile</a></li>
                            </ul>
                        </li>
                        <li class=" dropdown"><a href="#" class="dropdown-toggle " data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Bill <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="#">Telephone Bill</a></li>
                                <li><a href="#">Friday Huddle Bill</a></li>
                            </ul>
                        </li>
                        </sec:authorize>
                         <sec:authorize access="hasRole('${roleUser}')">
                        <li class=" dropdown">
                            <a href="#" class="dropdown-toggle " data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Profile <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li class=" dropdown">
                                     <li><a href="<%= request.getContextPath() %>/profile.htm">Create Profile</a></li>
                                </li>
                                <li><a href="#">Edit Profile</a></li>
                            </ul>
                        </li>
                        </sec:authorize>
                    </ul>
                    <ul class="nav navbar-nav pull-right">
                        <li class=" dropdown"><a href="" class="dropdown-toggle active" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Signed in as  <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="#">Change Password</a></li>
                                <li><a href="<%= request.getContextPath() %>/profile.htm">My Profile</a></li>
                            </ul>
                        </li>
                        <li class=""><a href="<%= request.getContextPath() %>/j_spring_security_logout">Logout</a></li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
</div>
</body>
</html>