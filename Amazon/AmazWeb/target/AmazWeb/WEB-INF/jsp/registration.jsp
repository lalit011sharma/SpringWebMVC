<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<style type="text/css">
#color{ color:red; }
</style>
<title>Registration</title>
</head>
<body>

	<p><a href="showLogin.do">Login here</a></p>
<!-- 	<p><a href="showProduct.do">Product</a></p>
 -->	<form:form method="POST" action="submitRegistration.do"  modelAttribute="RegistrationKey">
		<table width="100%" border="0">
			<tr>
				<td>
				<p id="color"><form:errors path="firstname"/><p>
				Firstname: <form:input path="firstname" id="firstname" />
				</td>
			</tr>
			<tr>
				<td>
				<p id="color"><form:errors path="lastname"/></p>
				Lastname: <form:input path="lastname" id="lastname" /></td>
			</tr>
			<tr>
				<td>
				<p id="color"><form:errors path="mobile"/></p>
				Mobile: <form:input path="mobile" id="mobile" />
				</td>
			</tr>
			<tr>
				<td>
				<p id="color"><form:errors path="emailId"/></p>
				Email: <form:input path="emailId" id="emailId" />
				</td>
			</tr><tr>
				<td>
				<p id="color"><form:errors path="password"/></p>
				Password: <form:password path="password" id="password" />
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>