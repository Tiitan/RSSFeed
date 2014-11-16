<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>RSSFeed sign up</title>
	</head>
	<body>
		<form method="post" action="signup">
	   		<fieldset>
       			<legend>Sign up</legend>
		
		       <label for="firstName">First Name</label>
		       <input type="text" id="emailText" name="firstName" value="" size="20" maxlength="20" />
		       <br />
		       
		       <label for="lastName">Last Name</label>
		       <input type="text" id="passwordText" name="lastName" value="" size="20" maxlength="20" />
		       <br />
		       
		       <label for="email">Email</label>
		       <input type="text" id="emailText" name="email" value="" size="20" maxlength="20" />
		       <br />
		       
		       <label for="password">Password</label>
		       <input type="text" id="passwordText" name="password" value="" size="20" maxlength="20" />
		       <br />
		       
		   	</fieldset>
		   	<input type="submit" value="Valid"  />
		    <c:if  test="${not empty errorMessage}">
				<c:out value="${errorMessage}" />
		    </c:if>
		</form>
	</body>
</html>