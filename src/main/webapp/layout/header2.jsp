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
</table>
<table>
<tr>
<td class='all25'><a class="button" href="navigatororg" >Organization</a></td>
<td><a href="navigatororg" ></a></td>
<td class='all25'><a class="button"href="navigatoraddr" >Address</a></td>
</tr>
</table>
</body>
</head>
</html>