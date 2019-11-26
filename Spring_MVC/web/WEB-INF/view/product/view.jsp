<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View product details</title>
</head>
<body>
<h1>Product details</h1>
<a href="/products">Back to product list</a>
<table>
    <tr>
        <td>Code: </td>
        <td>${product.getCode()}</td>
    </tr>
    <tr>
        <td>Name: </td>
        <td>${product.getName()}</td>
    </tr>
    <tr>
        <td>Price: </td>
        <td>${product.getPrice()}</td>
    </tr>
</table>
</body>
</html>