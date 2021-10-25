<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="co"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product</title>
<style type="text/css">
td {
	text-align: center;
}

#table {
	border: 1px solid black;
	border-collapse: collapse;
}
</style>
</head>
<body>
	<p>
		<a href="showLogin.do">Login here</a>
	</p>
	<p>
		<a href="showRegistration.do">Registration here</a>
	</p>
	<form:form method="POST" action="submitProduct.do"
		modelAttribute="productDto">
		<table width="100%" id="table">
			<tr>
				<td><div class="form-control">
						<%-- <form:errors path="name"  class="label error-label"></form:errors> --%>
						<label>
							<p>
								Product Name<small class="required">*</small>
							</p> <form:input path="productName" class="inputControl"
								placeholder="productName" required="autofocus" maxlength="30"
								onkeypress="return Alphabets(event)" />
						</label>
					</div></td>
				<td><div class="form-control">
						<form:errors path="description" class="label error-label"></form:errors>
						<label>
							<p>
								Description<small class="required"></small>
							</p> <form:input path="description" class="inputControl"
								placeholder="description" required="autofocus" maxlength="30"
								onkeypress="return Alphabets(event)" />
						</label>
					</div></td>
			</tr>
			<tr>
				<td></td>
				<td><div class="form-control">
						<form:errors path="price" class="label error-label"></form:errors>
						<label>
							<p>
								Price<small class="required">*</small>
							</p> <form:input path="price" class="inputControl"
								placeholder="price" required="autofocus" maxlength="100"
								onblur="emailVarification(this);" />
						</label>
					</div></td>
			<tr>
				<td><div class="form-control">
						<%-- <form:errors path="subject"  class="label error-label"></form:errors> --%>
						<label>
							<p>productCode:</p> <input type="productCode"
							class="inputControl" placeholder="productCode"
							required="autofocus" maxlength="20" onchange="return validate();" />
						</label>
					</div></td>
				<td><div class="form-control">
						<form:errors path="expireDate" class="label error-label"></form:errors>
						<label>
							<p>
								Expire Date<small class="required">*</small>
							</p> <form:input path="expireDate" class="inputControl"
								placeholder="expireDate" required="autofocus" maxlength="20" />
						</label>
					</div></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" id="Submit"
					class="btn lg-btn" onclick="productRegistration();"
					style="width: 17%;" /></td>

			</tr>
		</table>
	</form:form>
	<br>
	<br>
	<table border="1" style="width: 100%">
		<tr>
			<th>PRODUCT_ID</th>
			<th>PRODUCT_NAME</th>
			<th>DESCRIPTION</th>
			<th>PRICE</th>
			<th>EXPIRE_DATE</th>
		</tr>
		<c:choose>
			<c:when test="${productList!=null}">
				<c:forEach var="product" items="${productList }">
					<tr>
						<td><c:out value="${product.productId}" /></td>
						<td><c:out value="${product.productName}" /></td>
						<td><c:out value="${product.description }" /></td>
						<td><c:out value="${product.price }" /></td>
						<td><c:out value="${product.expireDate }" /></td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="5"><marquee>NO DATA AVAILABLE</marquee></td>
				</tr>
			</c:otherwise>
		</c:choose>
	</table>

</body>
</html>