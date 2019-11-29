<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tranv
  Date: 11/28/2019
  Time: 3:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sanwich</title>
</head>
<body>
<h2>Sandwich condiments</h2>
    <c:forEach var="condiment" items="${condiments}">
        <h4><c:out value="${condiment}"/></h4>
    </c:forEach>
</body>
</html>
