<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="<%=request.getContextPath() %>/resources/script/jquery-1.10.2.min.js"></script>
<script type="text/javascript">
	     $(document).ready(function () {
	     	var url = "test";
	     	$.ajax({
	     		url:url,
	     		type:'GET',
	     		dataType:'json',
	     		success: function(data) {
	     			console.log("data:: "+JSON.stringify(data));
	     			 /* $.each(data, function(index, data) {
	     	    		console.log("id:: "+data.id);
	     	    		console.log("userName:: "+data.userName);
	     	    		console.log("password:: "+data.password);
	     	    		var obj = jQuery.parseJSON(JSON.stringify(data.roles));
	     	    		console.log("data:: "+JSON.stringify(obj)); */
	  		      	/* if(obj.length>0) { 
	  	     			$.each(obj, function(key, item){
	  	     				console.log("id:: "+item.id);
	  	       	    		console.log("userName:: "+item.role);
	  	     			});
	  		      	} */
	     			//}); 
	     		}
	     	});
	     });
	</script>
</head>
<body>

</body>
</html>