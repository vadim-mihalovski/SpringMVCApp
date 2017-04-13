<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Employee Registration Form</title>
    <link href="<c:url value="../../resources/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="../../resources/css/styles.css">
</head>
<body>
<div class="panel panel-default">
    <div class="panel-heading">Registration Form<a href="<c:url value='/list'/>" class="btn btn-primary btn-list">List of All Employees</a></div>
    <form:form method="POST" modelAttribute="employee">
    <div class="regform">
        <form:input type="hidden" path="id" id="id"/>
        <div class="form-group">
            <label class="col-md-2 control-label" for="name">Name</label>
            <div class="col-md-10">
                <form:input path="name" class="form-control" placeholder="Name" type="text"/>
                <form:errors path="name" class="alert alert-danger" role="alert"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-2 control-label" for="joiningDate">Joining Date</label>
            <div class="col-md-10">
                <form:input path="joiningDate" class="form-control" placeholder="Joining Date" type="text"/>
                <form:errors path="joiningDate" class="alert alert-danger" role="alert"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-2 control-label" for="salary">Salary</label>
            <div class="col-md-10">
                <form:input path="salary" class="form-control" placeholder="Salary" type="number"/>
                <form:errors path="salary" class="alert alert-danger" role="alert"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-2 control-label" for="ssn">SSN</label>
            <div class="col-md-10">
                <form:input path="ssn" class="form-control" placeholder="SSN" type="number"/>
                <form:errors path="ssn" class="alert alert-danger" role="alert"/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-2"></div>
            <div class="col-md-10">
                <c:choose>
                    <c:when test="${edit}">
                        <input type="submit" value="Update" class="btn btn-success"/>
                    </c:when>
                    <c:otherwise>
                        <input type="submit" value="Register" class="btn btn-success"/>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
        </fieldset>
        </form:form>
    </div>
    <script src="<c:url value="/resources/js/jquery-1.12.4.js"/>"></script>
    <script src="<c:url value="../../resources/bootstrap/js/bootstrap.min.js"/>"></script>
</body>
</html>