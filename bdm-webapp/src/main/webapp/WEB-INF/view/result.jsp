<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Search Result</title>
</head>
<body>
<h1>Search Result</h1>

<h2>Facets</h2>
<table>
    <tr>
        <td>Suppliers: </td>
        <c:forEach items="${facets}" var="facet">
            <td>${facet}, </td>
        </c:forEach>
    </tr>
</table>

<h2>Products</h2>
<c:forEach items="${result}" var="element">
    <ul>
        <li>Id: ${element.id}</li>
        <li>Name: ${element.product_name}</li>
        <li>Code: ${element.product_code}</li>
        <li>Price: ${element.detail_price}</li>
        <li>Quantity: ${element.detail_quantity}</li>
        <li>Snippet: ${element.detail_snippet}</li>
        <li>Description: ${element.detail_description}</li>
        <li>Supplier code: ${element.supplier_code}</li>
        <li>Supplier name: ${element.supplier_name}</li>
        <li>Supplier description: ${element.supplier_description}</li>
    </ul>
</c:forEach>
</body>
</html>
