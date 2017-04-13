<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>University Enrollments</title>
    <link href="<c:url value="../../resources/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="../../resources/css/employees.css">
</head>
<body>
<%--<div class="well">--%>
    <div class="panel panel-default">
        <div class="panel-heading">List of Employees<a href="<c:url value='/registration' />" class="btn btn-primary btn-reg">Add New Employee</a></div>
        <table class="table table-striped">
            <tr>
                <td>Name</td>
                <td>Joining Date</td>
                <td>Salary</td>
                <td>SSN</td>
                <td></td>
            </tr>
            <c:forEach items="${employees}" var="employee">
                <tr>
                    <td>${employee.name}</td>
                    <td>${employee.joiningDate}</td>
                    <td>${employee.salary}</td>
                    <td><a href="<c:url value='/edit-${employee.ssn}-employee' />">${employee.ssn}</a></td>
                    <td>
                        <a href="<c:url value='/delete-${employee.ssn}-employee' />" class="btn btn-sm btn-danger">
                            delete
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>

<%--</div>--%>
<script src="<c:url value="/resources/js/jquery-1.12.4.js"/>"></script>
<script src="<c:url value="../../resources/bootstrap/js/bootstrap.min.js"/>"></script>
</body>
</html>