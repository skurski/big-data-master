
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Search Engine</title>
</head>

<body>
<h1>Search Engine</h1>
<p>${message}</p>
<p>See all products: <a href="http://localhost:8080/solr/core0/select?indent=on&q=*:*&wt=json">
    http://localhost:8080/solr/core0/select?indent=on&q=*:*&wt=json</a></p>
<form:form method="POST" action="search" modelAttribute="searchForm">
    <form:input path="keywords"/>&nbsp
    <input type="submit" value="Search"/>
</form:form>
</body>

</html>