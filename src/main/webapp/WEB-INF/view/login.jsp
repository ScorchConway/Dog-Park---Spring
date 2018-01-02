<!DOCTYPE html>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
        <title>Dog Park Login</title>
    </head>
    <body>
        <div> 
          <c:if test="${!empty param.error}">
            Invalid username and password.
          </c:if>
        </div>
        <div>
          <c:if test="${!empty param.logout}">
            You have been logged out.
          </c:if>
        </div>
        <p>Login form</p>
        <form action="/login" method="post">
            <div><label> User Name : <input type="text" name="username"/> </label></div>
            <div><label> Password: <input type="password" name="password"/> </label></div>
            <div><input type="submit" value="Sign In"/></div>
        </form>
    </body>
</html>