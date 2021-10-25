<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>


<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>

	<form:form method="POST" action="productRegistration.do"
		modelAttribute="Pro">
		<table width="100%" border="0">
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
						<form:errors path="expireDate" class="label error-label"></form:errors>
						<label>
							<p>
								Expire Date<small class="required">*</small>
							</p> <form:password path="expireDate" class="inputControl"
								placeholder="expireDate" required="autofocus" maxlength="20" />
						</label>
					</div></td>


				<td><div class="form-control">
						<%-- <form:errors path="subject"  class="label error-label"></form:errors> --%>
						<label>
							<p>
								Product Code<small class="required"></small>
							</p> <input type="productCode" class="inputControl"
							placeholder="productCode" required="autofocus" maxlength="20"
							onchange="return validate();" />
						</label>
					</div></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" id="Submit"
					class="btn lg-btn" onclick="productRegistration();"
					style="width: 17%; float: right;" />
					</form></td>

			</tr>
		</table>
	</form:form>


	<table style="width: 100%">
		<tr>
			<th>PRODUCT_ID</th>
			<th>PRODUCT_NAME</th>
			<th>DESCRIPTION</th>
			<th>PRICE</th>
			<th>PRODUCT_CODE</th>
			<th>EXPIRE_DATE</th>
		</tr>

		<tr>
			<c:forEach items="${List}" var="singleList">
				<td><c:out value="${singleList[0].ProductId}" /></td>
				<td><c:out value="${singleList[0]}" /></td>
				<td><c:out value="${singleList}" /></td>
				
				<td>{singleList}</td>
				
				<%-- <td><c:out value="${singleList.productName}" /></td>
				<td><c:out value="${singleList.description}" /></td>
				<td><c:out value="${singleList.price}" /></td>
				<td><c:out value="${singleList.productCode}" /></td>
				<td><c:out value="${singleList.expireDate}" /></td> --%>
			</c:forEach>
		</tr>
	</table>


</body>
</html>