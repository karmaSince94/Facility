<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login User Page</title>

<script src="//code.jquery.com/jquery-1.9.1.js"></script>
  <script src="//ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>
  
  <!-- jQuery Form Validation code -->
  <script>
  
  // When the browser is ready...
  $(function() 
  {
  
    // Setup form validation on the #register-form element
    $("#login-form").validate({
    
        // Specify the validation rules
        rules: 
        {
            u_name: "required",
            u_password: "required",
        },
        
        // Specify the validation error messages
        messages: 
        {
            u_name: "Please enter your correct username",
            u_password: "Please enter your correct password",
            
        },
        
        submitHandler: function(loginForm) {
        	loginForm.submit();
        }
    });

  });
  
  </script>
  

</head>
<body>


<form name="loginForm" action="login.do" method="post" id="login-form">

<h1>Welcome To Login Page</h1>

<pre>
<spring:message code="label.u_name"></spring:message>  : <input type="text" name="u_name" id="u_name"/><br>
<spring:message code="label.u_password"></spring:message> : <input type="password" name="u_password" id="u_password"/><br><br><br> 
<input type="submit" value="<spring:message code="label.login"/>"/><br><br><br>
<a href="?lan=fr">French</a>
<a href="?lan=en">English</a>
</pre>


</form>

</body>
</html>