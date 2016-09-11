
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="import/header.jsp"%>

<p>${message}</p>
<p>See all products: <a href="http://localhost:8080/solr/core0/select?indent=on&q=*:*&wt=json">
    http://localhost:8080/solr/core0/select?indent=on&q=*:*&wt=json</a></p>
<form:form method="POST" action="search/result" modelAttribute="searchForm">
    <form:input path="keywords"/>&nbsp
    <input type="submit" value="Search"/>
</form:form>
</body>

</html>