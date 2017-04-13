<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Registration Confirmation Page</title>
    <link href="<c:url value="../../resources/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="../../resources/css/success.css"/>" rel="stylesheet">
</head>
<body>
<div class="alert alert-success" role="alert">
    <div><strong>Message: </strong> ${success}</div>
    <a href="<c:url value='/list'/>" class="btn btn-primary">
        List of All Employees
    </a>
</div>
<script src="<c:url value="/resources/js/jquery-1.12.4.js"/>"></script>
<script src="<c:url value="../../resources/bootstrap/js/bootstrap.min.js"/>"></script>
</body>
</html>