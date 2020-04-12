<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<title>Spittr</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/style.css">
</head>
<body>
    <div class="container-fluid">
        <div class="row justify-content-center align-items-center" style="height: 900px;">
            <div class="col-lg-3 col-xs-12">
                <h1>Register</h1>
                <form method="post">
                    <div class="form-group row">
                        <label for="firstName" class="col-sm-3 col-form-label"> First Name:</label>
                        <div class="col-sm-9">
                            <input class="form-control" id="firstName" name="firstName" placeholder="first name">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="lastName" class="col-sm-3 col-form-label"> Last Name:</label>
                        <div class="col-sm-9">
                            <input class="form-control" id="lastName" name="lastName" placeholder="last name">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="username" class="col-sm-3 col-form-label"> Username:</label>
                        <div class="col-sm-9">
                            <input class="form-control" id="username" name="username" placeholder="username">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="password" class="col-sm-3 col-form-label"> Password:</label>
                        <div class="col-sm-9">
                            <input class="form-control" type="password" id="password" name="password" placeholder="password">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="email" class="col-sm-3 col-form-label"> Email:</label>
                        <div class="col-sm-9">
                            <input class="form-control" type="email" id="email" name="email" placeholder="name@example.com">
                        </div>
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary offset-md-3">Submit</button>
                        <button type="reset" class="btn btn-secondary offset-md-1">Reset</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>