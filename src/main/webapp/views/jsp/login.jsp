<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html >
<head>
<meta charset="UTF-8">
<title>eMIPP</title>
</head>
<body>
	<div id="wrap">
  		<div id="regbar">
    	<div id="navthing">
      	<h2><a href="#" id="loginform">Connect</a></h2>
    	<div class="login">
      	<div class="arrow-up"></div>
      	<div class="formholder">
        <div class="randompad">
        <form:form method="post" modelAttribute="loginVO" action="logins">
           <fieldset>
             <label name="userName">Database User Name</label>
             <form:input path="userName" />
             <label name="usrpwd">Database Password</label>
             <form:password path="usrpwd" />
             <label name="userName">Environment</label>
             <form:select path="type">
   				<form:option value="DEV" label="DEV"/>
   				<form:option value="ITF" label="ITF"/>
   				<form:option value="UAT" label="UAT"/>
			</form:select>
             <input type="submit" value="Login" />              
           </fieldset>
         </form:form>  
        </div>
      </div>
    </div>
    </div>
  </div>
</div>
</body>
</html>
