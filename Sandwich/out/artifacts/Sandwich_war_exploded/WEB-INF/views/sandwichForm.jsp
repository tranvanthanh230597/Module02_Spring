<%--
  Created by IntelliJ IDEA.
  User: tranv
  Date: 11/28/2019
  Time: 3:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sanwich Form</title>
</head>
<body>
<form action="/addCondiment" method="post">
    <table>
        <h2>Sandwich condiments</h2>
        ${condimentList}
        <tr>
            <td><label>Chose sandwich condiments</label></td>
            <td><input type="checkbox" value="Lettuce" name="condiments">Lettuce</td>
            <td><input type="checkbox" value="Tomato" name="condiments">Tomato</td>
            <td><input type="checkbox" value="Mustard" name="condiments">Mustard</td>
            <td><input type="checkbox" value="Sprouts" name="condiments">Sprouts</td>
        </tr>
        <tr>
            <td colspan = "2">
                <input type = "submit" value = "Submit"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
