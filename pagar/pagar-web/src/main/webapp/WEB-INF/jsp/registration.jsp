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

    <p><a href="login.do"> Login here</a></p>
    <form:form method="POST" action="userRegistration.do" modelAttribute="Registration">
        <table width="100%" border="0">
          <tr>
            <td><div class="form-control">
                <%-- <form:errors path="name"  class="label error-label"></form:errors> --%>
                <label>
                  <p>
                    First Name<small class="required">*</small>
                  </p> <form:input path="firstName" class="inputControl" placeholder="First Name" required="autofocus"
                    maxlength="30" onkeypress="return Alphabets(event)" /> </label>
              </div>
            </td>
            <td><div class="form-control">
                <form:errors path="lastName"  class="label error-label"></form:errors>
                <label>
                  <p>
                    Last Name<small class="required"></small>
                  </p> <form:input path="lastName" class="inputControl" placeholder="Last Name" required="autofocus"
                    maxlength="30" onkeypress="return Alphabets(event)" /> </label>
              </div>
            </td>
          </tr>
          <tr>
            <td><div class="form-control">
                <form:errors path="emailId"  class="label error-label"></form:errors>
                <label>
                  <p>
                    Email Id<small class="required">*</small>
                  </p> <form:input path="emailId" class="inputControl" placeholder="Email Id" required="autofocus"
                    maxlength="100" onblur="emailVarification(this);" /> </label>
              </div>
            </td>
           
       
          <tr>
           
           
            <td><div class="form-control">
                <form:errors path="password"  class="label error-label"></form:errors>
                <label>
                  <p>
                    Password<small class="required">*</small>
                  </p> <form:password path="password" class="inputControl" placeholder="Password" required="autofocus"
                    maxlength="20" /> </label>
              </div>
            </td>
        <!--    <td><div class="form-control">
                <%-- <form:errors path="subject"  class="label error-label"></form:errors> --%>
                <label>
                  <p>
                    Confirm Password<small class="required"></small>
                  </p> <input type="password" id="confirmPassword" class="inputControl" placeholder="Confirm Password"
                  required="autofocus" maxlength="20" onchange="return validate();" /> </label>
              </div>
            </td>
          </tr>   -->
          <tr>
               <td colspan="2"><input type="submit" value="Submit" id="Submit" class="btn lg-btn" onclick="userRegistration();"
              style="width: 17%; float: right;" /> 
              </form>
            </td>
          </tr>
        </table>
      </form:form>
</body>
</html>