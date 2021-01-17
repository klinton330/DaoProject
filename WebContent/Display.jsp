<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Details</title>
</head>
<body>
<table>
<tr>
<td>Student Id</td>
<td>Student Name</td>
<td>Student City</td>
</tr>
<tr>
<td>${display.sid}</td>
<td>${display.sname}</td>
<td>${display.scity}</td>
</tr>
</table>
</body>
</html>