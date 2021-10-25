<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <!--    <h3> Login here </h3>
      <form action="registration" method="post">  -->
      <p><a href="product.do"> Register product here</a></p>
      <p><a href="registration.do"> Register here</a></p>
 
      <form:form method="POST" action="userSignIn.do" modelAttribute="AdminLogin">
        <table width="100%" border="0">
          <tr>
            <td><div class="form-control">
                <%-- <form:errors path="name"  class="label error-label"></form:errors> --%>
                <label>
                  <p>
                    Email :<small class="required"></small>
                  </p> <form:input path="emailId" id="emailId" /> </label>
              </div> 
            </td>
          </tr>
          <tr>
            <td><div class="form-control">
                <%-- <form:errors path="subject"  class="label error-label"></form:errors> --%>
                <label>
                  <p>
                    Password : <small class="required"></small>
                  </p> <form:password path="Password" id="password" /> </label>
              </div>
            </td>
          </tr>
              <tr>
          
          
            <td colspan="2"><input type="submit" value="Submit" class="btn lg-btn" onclick="remeberMe();" />
            </td>
          </tr>
        </table>
      </form:form>
    </div>
  </div>



</body>
</html>