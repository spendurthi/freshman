<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="utf-8"/>
	<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,700" rel="stylesheet" />
	<link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>">
<body ng-app>
	<!-- The navigation menu will get the value of the "active" variable as a class.
		The $event.preventDefault() stops the page from jumping when a link is clicked. -->
	<nav class="{{active}}">
		<!-- When a link in the menu is clicked, we set the active variable -->
		<a href="login" class="login" ng-click="active='login'">Home</a>
		<a href="navigatoraddr" class="navigatoraddr" ng-click="active='navigatoraddr'">Address</a>
	</nav>
		<!-- ng-show will show an element if the value in the quotes is truthful,
			 while ng-hide does the opposite. Because the active variable is not set
			 initially, this will cause the first paragraph to be visible. -->
	<!-- Include AngularJS from Google's CDN -->
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.7/angular.min.js"></script>
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