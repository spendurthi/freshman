<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
</head>
<body ng-app="deptAppSearch">

<form:form method="POST" action="/freshman/dept/search" modelAttribute="dept" ng-controller="deptController as deptCtrl">
<form:errors path="*" cssClass="red" />
 <div id="errorDiv"></div> 		  
   <table id="box-table-a">
    <tr>
        <td><form:label path="deptId"><fmt:message key="deptId" /> :</form:label></td>
        <td><form:input path="deptId" ng-model="deptCtrl.dept.deptId" cssClass="required" ng-change="deptCtrl.searchDepts()" /></td>
        <td><form:label path="deptName"><fmt:message key="deptName" /> :</form:label></td>
        <td><form:input path="deptName" ng-model="deptCtrl.dept.deptName" cssClass="required" ng-change="deptCtrl.searchDepts()" /></td>
        <td><form:label path="deptLoc"><fmt:message key="deptLoc" /> :</form:label></td>
        <td><form:input path="deptLoc" ng-model="deptCtrl.dept.deptLoc" ng-change="deptCtrl.searchDepts()" /></td>
    	<td align="center" colspan="2">
            <input type="submit" value="Find" class="bigBtn" id="btnDeptSearch" />
        </td>
    </tr>
</table>
<div class="panel panel-default">
   <!-- Default panel contents -->
 <div class="panel-heading"><span class="lead">List of Departments </span></div>
 <div class="tablecontainer">
     <table class="table table-hover">
         <thead>
             <tr>
                 <th>ID.</th>
                 <th>Name</th>
                 <th>Location</th>
             </tr>
         </thead>
         <tbody>
             <tr ng-repeat="u in deptCtrl.depts">
                 <td><span ng-bind="u.deptId"></span></td>
                 <td><span ng-bind="u.deptName"></span></td>
                 <td><span ng-bind="u.deptLoc"></span></td>
             </tr>
         </tbody>
     </table>
 </div>
</div>
</form:form>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
<script src="<c:url value='/resources/js/app.js' />?r=<%=session.getId() %>>"></script>
<script src="<c:url value='/resources/js/deptController.js' />?r=<%=session.getId() %>>"></script>   
<script src="<c:url value='/resources/js/deptService.js' />?r=<%=session.getId() %>>"></script>

</html>