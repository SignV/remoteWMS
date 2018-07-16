<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>远程仓储管理系统</title>
	<meta name="description" content="">
	<meta name="author" content="templatemo">

	<%--<link href='http://fonts.useso.com/css?family=Open+Sans:400,300,400italic,700' rel='stylesheet' type='text/css'>--%>
	<link href="${pageContext.request.contextPath}/static/css/font-awesome.min.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/static/css/templatemo-style.css" rel="stylesheet">

</head>
<body class="light-gray-bg">
<div class="templatemo-content-widget templatemo-login-widget white-bg">
	<header class="text-center">
		<div class="square"></div>
		<h1>Remote Login</h1>
	</header>
	<form action="${pageContext.request.contextPath}/user/login" class="templatemo-login-form"
		  enctype="multipart/form-data" method="post">
		<div class="form-group">
			<div class="input-group">
				<div class="input-group-addon"><i class="fa fa-user fa-fw"></i></div>
				<input type="text" class="form-control" placeholder=""
					   id="userName" name="userName">
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
				<div class="input-group-addon"><i class="fa fa-key fa-fw"></i></div>
				<input type="password" class="form-control" placeholder=""
					   id="password" name="password">
			</div>
		</div>
		<div class="form-group">
			<div class="checkbox squaredTwo">
				<input type="checkbox" id="c1" name="cc" />
				<label for="c1"><span></span>Remember me</label>
				<span><font color="red" id="error">${errorInfo }</font></span>
			</div>
		</div>
		<div class="form-group">
			<button type="submit" id="submitBtn" class="templatemo-blue-button width-100">Login</button>
		</div>
	</form>
</div>
<div class="templatemo-content-widget templatemo-login-widget templatemo-register-widget white-bg">
	<p class="blue-text"><strong>Copyright © 2017-2018 SignV 远程仓储管理系统</strong>
		 </p>
	<%--<strong><a href="#" class="blue-text">Sign up now!</a></strong>--%>
</div>
</body>
<script src="${pageContext.request.contextPath}/static/js/jquery-1.11.2.min.js"></script>
<script>
    $('#submitBtn').click(function () {
        var username = $("#userName").val();
        var password = $("#password").val();
        if (username == null || username == "") {
            $("#error").html("用户名不能为空！");
            return false;
        }
        if (password == null || password == "") {
            $("#error").html("密码不能为空！");
            return false;
        }
        return true;
    })
</script>
</html>