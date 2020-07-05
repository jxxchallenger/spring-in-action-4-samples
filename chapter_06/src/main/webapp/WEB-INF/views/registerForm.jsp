<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<title>Spittr</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/style.css">
</head>
<body>
    <div class="container-fluid">
        <div class="row justify-content-center align-items-center" style="height: 900px;">
            <div class="col-lg-3 col-xs-12">
                <h1><s:message code="spittr.spitter.register" text="Register"></s:message></h1>
                <form:form method="post" modelAttribute="spitter">
                    <div class="form-group row">
                        <form:errors path="*" cssClass="text-danger" element="div"></form:errors>
                    </div>
                    <div class="form-group row">
                        <form:label path="firstName" cssClass="col-sm-3 col-form-label" cssErrorClass="col-sm-3 col-form-label text-danger"><s:message code="spittr.spitter.firstname" text="First Name:"></s:message></form:label>
                        <div class="col-sm-9">
                            <form:input path="firstName" cssClass="form-control" cssErrorClass="form-control border-danger" placeholder="first name"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <form:label path="lastName" cssClass="col-sm-3 col-form-label" cssErrorClass="col-sm-3 col-form-label text-danger"><s:message code="spittr.spitter.lastname" text="Last Name:"></s:message></form:label>
                        <div class="col-sm-9">
                            <form:input path="lastName" cssClass="form-control" cssErrorClass="form-control border-danger" placeholder="last name"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <form:label path="username" cssClass="col-sm-3 col-form-label" cssErrorClass="col-sm-3 col-form-label text-danger"><s:message code="spittr.spitter.username" text="Username:"></s:message></form:label>
                        <div class="col-sm-9">
                            <form:input path="username" cssClass="form-control" cssErrorClass="form-control border-danger" placeholder="username"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <form:label path="password" cssClass="col-sm-3 col-form-label" cssErrorClass="col-sm-3 col-form-label text-danger"><s:message code="spittr.spitter.password" text="Password:"></s:message></form:label>
                        <div class="col-sm-9">
                            <form:password path="password" cssClass="form-control" cssErrorClass="form-control border-danger" placeholder="password"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <form:label path="email" cssClass="col-sm-3 col-form-label" cssErrorClass="col-sm-3 col-form-label text-danger"><s:message code="spittr.spitter.email" text="Email:"></s:message></form:label>
                        <div class="col-sm-9">
                            <form:input path="email" cssClass="form-control" cssErrorClass="form-control border-danger" placeholder="name@example.com"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary offset-md-3"><s:message code="spittr.submit" text="Submit"></s:message></button>
                        <button type="reset" class="btn btn-secondary offset-md-1"><s:message code="spittr.reset" text="Reset"></s:message></button>
                        <!-- 分析对比html form 表单乱码原因  -->
                        <!-- <button type="button" class="btn btn-default aaa">测试</button> -->
                        
                    </div>
                </form:form>
                
            </div>
        </div>
    </div>
    <!-- <script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
    <script type="text/javascript">
        $('.aaa').click(function(event) {
            var spitter = {'firstName': $('#firstName').val(), 'lastName': $('#lastName').val(), 'username': $('#username').val(), 'password': $('#password').val(), 'email': $('#email').val()};
            $.ajax({
                url: '${pageContext.request.contextPath}/spitter/register',
                type: 'post',
                dataType: 'json',
                data: spitter,
                success: function(data, status) {
                    console.log(data);
                },
                error: function(data, status) {
                    console.log(data);
                }
            });
        });
    </script> -->
</body>
</html>