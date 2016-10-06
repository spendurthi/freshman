<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
	<title>Address</title>
</head>
<body>
<table border="1" id="box-table-a" >
<thead>
	<tr>
	<th width="2%"><fmt:message key="id" /></th>
	<th width="40%"><fmt:message key="street" /></th>
	<th width="2%"><fmt:message key="suiteApt" /></th>
	<th width="8%"><fmt:message key="city" /></th>
	<th width="8%"><fmt:message key="state" /></th>
	<th width="5%"><fmt:message key="zip" /></th>
	<th width="8%"><fmt:message key="country" /></th>
	<th width="5%"><fmt:message key="phoneHome" /></th>
	<th width="5%"><fmt:message key="phoneOffice" /></th>
	<th width="5%"><fmt:message key="phoneMobile" /></th>
	<th width="5%"><fmt:message key="fax" /></th>
	
	</tr>
</thead>
<c:forEach items = "${listOfAddress}" var="add">
<tr>
	<td><a href="addrupde${add.id}"><c:out value="${add.id}"/></a></td>
	<td><c:out value="${add.street}"/></td>
	<td><c:out value="${add.suiteApt}"/></td>
	<td><c:out value="${add.city}"/></td>
	<td><c:out value="${add.state}"/></td>
	<td><c:out value="${add.zip}"/></td>
	<td><c:out value="${add.country}"/></td>
	<td><c:out value="${add.phoneHome}"/></td>
	<td><c:out value="${add.phoneOffice}"/></td>
	<td><c:out value="${add.phoneMobile}"/></td>
	<td><c:out value="${add.fax}"/></td>		
</tr>	
</c:forEach>
</table>
<table>
<tr>
<td><a href="navigatoraddrAdd" >Add</a></td>
</tr>
</table>
</body>
</html>
