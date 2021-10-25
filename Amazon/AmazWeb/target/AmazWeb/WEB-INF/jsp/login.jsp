<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Login</title>
</head>
<body>
		<p><a href="showRegistration.do">Registration here</a></p>
	<form:form method="POST" action="submitLogin.do"  modelAttribute="UserDtoKey">
		<table width="100%" border="0">
			<tr>
				<td>Email: <form:input path="emailId" id="emailId" />
				</td>
			</tr>
			<tr>
				<td>Password: <form:password path="password" id="password" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>