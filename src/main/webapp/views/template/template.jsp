<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/index.js" />"></script>
</head>
 
<body>
    <div class="header">
        <tiles:insertAttribute name="header" />
    </div>
    <div class="menu">
        <tiles:insertAttribute name="menu" />
    </div>
    <div class="body">
        <tiles:insertAttribute name="body" />
    </div>
    <div class="footer">
        <tiles:insertAttribute name="footer" />
    </div>
</body>
</html>