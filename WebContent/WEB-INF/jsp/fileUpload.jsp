<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="myApp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="<%=request.getContextPath() %>/resources/script/angular.min.js"></script>
</head>
<body ng-controller="uploadController">
	<h3>${headerName}</h3>
	<form name="f" action="fileupload" method="POST" enctype="multipart/form-data" ><!-- action="fileupload"  -->
		Name: <input type="text" name="name" ng-model="upload.name"><br><br>
		File: <input type="file" name="file" ng-model="upload.file"><br><br>
		<input type="submit" ng-click="uploadFile()">
	</form>
	<!-- <script>
	var myApp = angular.module('myApp', []);
	myApp.controller('uploadController', ['$scope','$http', function($scope,$http) {
		$scope.form={};
		$scope.upload={};
		$scope.submitted=false;
		$scope.uploadFile = function() {
			console.log('aaaaaaaaa');
			$http({
				method : "POST",
				url : "fileupload",
				data : angular.toJson($scope.upload)
			}).then(function mySucces(response) {
				console.log(JSON.stringify(response));
			}, function myError(response) {
			    
			});
		}
	}]); 
	
	</script> -->
</body>
</html>