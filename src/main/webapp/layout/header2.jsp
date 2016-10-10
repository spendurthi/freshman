<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="utf-8"/>

<body>
	<nav>
		<a href="login" class="login" id="hrefLogin">Home</a>
		<a href="#" class="navigatoraddr" id="hrefAddress">Address</a>
		<a href="vUser" class="user" id="hrefUser">User</a>
	</nav>	
	<script type="text/javascript">
		var ctx= contextRootName();
		document.getElementById('hrefLogin').href = "/"+ctx + "/login";
		document.getElementById('hrefAddress').href = "/"+ctx + "/address";
		document.getElementById('hrefUser').href = "/"+ctx + "/users";
	</script>
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
</body>
</head>
</html>