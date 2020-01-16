<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
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
    <div class="listTitle">
        <h1>Recent Spittles</h1>
        <ul class="spittleList">
            <c:forEach items="${spittleList}" var="spittle">
                <li id="spittle_${spittle.id }">
                    <div class="spittleMessage">${spittle.message}</div>
                    <div>
                        <span class="spittleTime">${spittle.time}</span>
                        <span class="spittleLocation">(${spittle.latitude}, ${spittle.longitude})</span>
                    </div>
                </li>
            </c:forEach>
            
        </ul>

    </div>
</body>
</html>