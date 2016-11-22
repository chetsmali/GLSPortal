<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/bootstrap.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/profile.css">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/datepicker.css">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/bootstrap.css">
	<script src="<%=request.getContextPath() %>/resources/script/jquery-1.10.2.min.js"></script>
	<script src="<%=request.getContextPath() %>/resources/script/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath() %>/resources/script/bootstrap-datepicker.js"></script>
	
	<script type="text/javascript">
   $(document).ready(function () {
		$('.datepicker').datepicker();
   });
   </script>
	
</head>
<body>
	<div class="container">
      <div class="row">
      <div class="col-md-5  toppad  pull-right col-md-offset-3 ">
        <a href="<%= request.getContextPath() %>/j_spring_security_logout">Logout</a>
       <br>
      </div>
        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-8 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad" >
   			<form class="form-horizontal" role="form" name="form.profileForm"  enctype="multipart/form-data" >
   
          <div class="panel panel-info">
            <div class="panel-heading">
              <h3 class="panel-title">Profile</h3>
            </div>
            <div class="panel-body">
              <div class="row">
                <div class="col-md-2 col-lg-2 " align="center"> 
                	<img alt="User Pic" class="img-circle img-responsive"> <!-- ng-src="{{adminUsersDetails.photoPath}}" ng-src="./resources/images/pratik.jpg"-->
                	<h6>Upload a different photo...</h6>
        			<!-- <input type="file" class="avatar img-circle" alt="avatar"> -->
        			<input type="file" class="avatar img-circle" alt="avatar"  name="photoPath">
                </div>
                <div class=" col-md-10 col-lg-10 "> 
			          <div class="form-group">
			            <label class="col-lg-3 control-label">First Name:</label>
			            <div class="col-lg-8">
				            <input class="form-control" type="text"  name="firstname" id="firstname">
			            </div>
			          </div>
			          <div class="form-group">
			            <label class="col-lg-3 control-label">Last Name:</label>
			            <div class="col-lg-8">
			              <input class="form-control" type="text" name="lastname" id="lastname">
			            </div>
			          </div>
			          <div class="form-group">
			            <label class="col-lg-3 control-label">Date Of Birth:</label>
			            <div class="col-lg-8">
						  <input type="text" class="datepicker" datepicker="" name="dateOfBirth" id="dateOfBirth"> <br>
						</div>
			          </div>
			         
			          <div class="form-group">
			            <label class="col-lg-3 control-label">Email:</label>
			            <div class="col-lg-8">
			              <input class="form-control" type="text" name="emailId" id="emailId">
			            </div>
			          </div>	
			          <div class="form-group">
			            <label class="col-lg-3 control-label">Password:</label>
			            <div class="col-lg-8">
			              <input class="form-control" type="text" name="password" id="password">
			            </div>
			          </div>
			          <div class="form-group">
			            <label class="col-lg-3 control-label">Mobile No:</label>
			            <div class="col-lg-8">
			              <input type="text" class="form-control" name="mobileNo" id="mobileNo">
			            </div>
			          <div class="form-group">
			            <label class="col-lg-3 control-label">Date Of Joining:</label>
			            <div class="col-lg-8">
						  <input type="text" class="datepicker" datepicker="" name="dateOfJoining"> <br>
						</div>
			          </div>
			          <div class="form-group">
			            <label class="col-lg-3 control-label">Designation:</label>
			            <div class="col-lg-8">
			              <input class="form-control" type="text" name="designation" id="designation">
			            </div>
			          </div>
			          <div class="form-group">
			            <label class="col-lg-3 control-label">project:</label>
			            <div class="col-lg-8">
			              <input class="form-control" type="text" name="project" >
			            </div>
			          </div>
			          <div class="form-group">
			            <label class="col-lg-3 control-label">Manager:</label>
			            <div class="col-lg-8">
			              <input class="form-control" type="text" name="manager" id="manager">
			            </div>
			          </div>
			          <div class="form-group">
			            <label class="col-lg-3 control-label">Marital Status:</label>
						<div class="radio">
				            <label><input type="radio" name="maritalStatus" value="married">Married</label>
				            <label><input type="radio" name="maritalStatus" value="unmarried">Unmarried</label>
				        </div>
			          </div>
			          <div class="form-group">
			            <label class="col-lg-3 control-label">Date Of Marriage:</label>
			            <div class="col-lg-8">
						  <input type="text" class="datepicker" datepicker="" name="dateOfMarriage" id="dateOfMarriage"><br>
						</div>
			          </div>
			           <div class="form-group">
			            <label class="col-lg-3 control-label">Spause/Parent Name:</label>
			            <div class="col-lg-8">
			              <input class="form-control" type="text" name="parentName" id="parentName">
			            </div>
			          </div>
			           <div class="form-group">
			            <label class="col-lg-3 control-label">Spause/Parent Contact:</label>
			            <div class="col-lg-8">
			              <input class="form-control" type="text" name="parentContact" id="parentContact">
			            </div>
			          </div>
			          <div class="form-group">
			            <label class="col-lg-3 control-label">Blood group:</label>
			            <div class="col-lg-8">
			              <input class="form-control" type="text" name="bloodGroup" id="bloodGroup">
			            </div>
			          </div>
			          <div class="form-group">
			            <label class="col-lg-3 control-label">Total Year of Exp:</label>
			            <div class="col-lg-8">
			              <input class="form-control" type="text" name="totalYearOfExperience" id="totalYearOfExperience">
			            </div>
			          </div>
			          <div class="form-group">
			            <label class="col-lg-3 control-label">Address:</label>
			            <div class="col-lg-8">
			              <textarea rows="3" class="form-control" name="address" id="address"></textarea>
			            </div>
			          </div>
			          <div class="form-group">
			            <label class="col-md-3 control-label"></label>
			            <div class="col-md-8">
			              <input type="button" class="btn btn-primary" value="Save Changes" name="save" id="save">
			              <span></span>
			              <input type="reset" class="btn btn-default" value="Cancel">
			            </div>
			          </div>
	                </div>
	              </div>
	            </div>
	          </div>
	        </div>
        </form>
      </div>
    </div> 
    </div>
</body>
</html>