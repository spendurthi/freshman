<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<form:form method="POST" action="validateUser" modelAttribute="login">
<form:errors path="*" cssClass="red" />
 <div id="errorDiv"></div> 		  
   <table class="top25">
    <tr>
        <td><form:label path="userName"><fmt:message key="username" /> :</form:label></td>
        <td><form:input path="userName" cssClass="required" class="input-sm"/></td>
    </tr>
    <tr>
        <td><form:label path="password"><fmt:message key="password" /> :</form:label></td>
        <td><form:password path="password" cssClass="required" /></td>
    </tr>
    <tr>
    	<td></td>
        <td style="float:right;">
            <input type="submit" value="Submit" class="btn btn-success custom-width" />
        </td>
    </tr>
</table>
</form:form>
</body>
</html>