<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<title>Spittr</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/style.css">
</head>
<body>
    <h1><s:message code="spittr.welcome" text="Welcome to Spittr"></s:message></h1>
    <a href="${pageContext.request.contextPath }/spittles">Spittles</a> |
    <a href="${pageContext.request.contextPath }/spitter/register">Register</a>
</body>
</html>