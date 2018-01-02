<!DOCTYPE html>
<html>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
	<head>
	  <title>Home</title>
	</head>
	<body>
	  <a href="/logout">logout</a>
	  <h2>Home page for Dog Park app</h2>
	  <p>more to come</p>
	  
	  <ul>
	   <c:forEach var="dog" items="${dogs}">
	     <li>${dog.name} is a ${dog.breed}</li>
	   </c:forEach>
	  </ul> 
	  
	</body>
</html>