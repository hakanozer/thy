<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world! - Spring  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<h1>Gelen Data ${data }</h1>

<c:forEach begin="0" end="10" var="i" >
	<a href='<s:url value="/pro?id=${i}"></s:url>'>Product</a>
</c:forEach>


<hr/>
<c:if test="${ not empty ls }">
	<c:forEach items="${ls }" var="item" >
		<a href='<s:url value="/pro?id=${item.id}"></s:url>'>${item.title }</a>
	</c:forEach>
</c:if>

<form action='<s:url value="/addUser"></s:url>' method="post">
	<input name="userName" type="text" />
	<input name="userSurname" type="text" />
	<input type="submit" value="Gönder" />
</form>


</body>
</html>
