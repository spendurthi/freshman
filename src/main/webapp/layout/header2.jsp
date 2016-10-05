<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<body>
<table>
<tr>
<td>
<c:if test="${userDtls!=null}">
	<div id='errorDiv2' class="blue">
		<c:forEach items = "${userDtls}" var="imsg">
			${imsg}
	   	</c:forEach>   
	</div>
</c:if>
</td>
</tr>
<tr>
<td><a href="navigatororg" >ORG</a></td>
<td><a href="navigatoraddr" >Address</a></td>
</tr>
</table>
</body>
</head>
</html>