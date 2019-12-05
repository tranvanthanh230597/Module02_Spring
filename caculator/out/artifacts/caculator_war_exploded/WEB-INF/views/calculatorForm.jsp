<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tranv
  Date: 11/29/2019
  Time: 2:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>calculatorForm</title>
</head>
<body>
<form action="/caculate" method="post">
    <input type="text" name="inputValue01" value="<c:if test = '${input01 != null}'><c:out value = "${input01}"/></c:if> ">
    <input type="text" name="inputValue02" value="<c:if test = '${input02 != null}'><c:out value = "${input02}"/></c:if> ">
    <input type="submit" value="Addition" name="operations">
    <input type="submit" value="Subtraction" name="operations">
    <input type="submit" value="Multiplication" name="operations">
    <input type="submit" value="Divition" name="operations">
</form>
<c:if test = "${outPutValue != null}">
    <p>Result:  <c:out value = "${outPutValue}"/><p></c:if>
</body>
</html>
