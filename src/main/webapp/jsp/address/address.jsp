<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<form:form method="POST" action="dAddressAdd" modelAttribute="address">
<form:errors path="*" cssClass="red" />
 <div id="errorDiv"></div> 		  
   <table id="box-table-a" width="400px;">
    <tr>
        <td><form:label path="id"><fmt:message key="id" /> :</form:label></td>
        <td><form:input path="id" cssClass="required"/></td>
    </tr>
    <tr>
        <td><form:label path="street"><fmt:message key="street" /> :</form:label></td>
        <td><form:input path="street" cssClass="required"/></td>
    </tr>
    <tr>
        <td><form:label path="suiteApt"><fmt:message key="suiteApt" /> :</form:label></td>
        <td><form:input path="suiteApt" /></td>
    </tr>
    <tr>
        <td><form:label path="city"><fmt:message key="city" /> :</form:label></td>
        <td><form:input path="city" cssClass="required"/></td>
    </tr>
    <tr>
        <td><form:label path="state"><fmt:message key="state" /> :</form:label></td>
        <td><form:input path="state" cssClass="required"/></td>
    </tr>
    <tr>
        <td><form:label path="zip"><fmt:message key="zip" /> :</form:label></td>
        <td><form:input path="zip" cssClass="required"/></td>
    </tr>
    <tr>
        <td><form:label path="country"><fmt:message key="country" /> :</form:label></td>
        <td><form:input path="country" cssClass="required"/></td>
    </tr>
    <tr>
        <td><form:label path="phoneHome"><fmt:message key="phoneHome" /> :</form:label></td>
        <td><form:input path="phoneHome" /></td>
    </tr>
     <tr>
        <td><form:label path="phoneOffice"><fmt:message key="phoneOffice" /> :</form:label></td>
        <td><form:input path="phoneOffice" /></td>
    </tr>
     <tr>
        <td><form:label path="phoneMobile"><fmt:message key="phoneMobile" /> :</form:label></td>
        <td><form:input path="phoneMobile" /></td>
    </tr>
     <tr>
        <td><form:label path="type"><fmt:message key="type" /> :</form:label></td>
        <td><form:input path="type" /></td>
    </tr>
     <tr>
        <td><form:label path="extension"><fmt:message key="extension" /> :</form:label></td>
        <td><form:input path="extension" /></td>
    </tr>
     <tr>
        <td><form:label path="fax"><fmt:message key="fax" /> :</form:label></td>
        <td><form:input path="fax" /></td>
    </tr>
    <tr>
        <td align="center" colspan="2">
            <input type="submit" value="Submit" class="loginActions11" />
        </td>
    </tr>
</table>
</form:form>
</body>
</html>