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
    <title>Visual Admin Dashboard - Home</title>
    <meta name="description" content="">
    <meta name="author" content="templatemo">

    <!-- <link href='http://fonts.useso.com/css?family=Open+Sans:400,300,400italic,700' rel='stylesheet' type='text/css'> -->
    <link href="${pageContext.request.contextPath}/static/css/font-awesome.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/templatemo-style.css" rel="stylesheet">
    <style type="text/css">
        .contentHeight{
            height: 450px;
        }
    </style>
</head>
<body>
<!-- Left column -->
<div class="templatemo-flex-row">

    <!-- Main content -->
    <div class="templatemo-content col-1 light-gray-bg">
        <!-- 内容区 -->
        <div class="templatemo-content-container ">
            <div class="templatemo-flex-row flex-content-row">
                <div class="templatemo-content-widget white-bg col-2 contentHeight">
                    <i class="fa fa-times"></i>
                    <div class="square"></div>
                    <h2 class="templatemo-inline-block">&nbsp;Welcome To Remote WMS</h2><hr>
                    <h3><p>欢迎使用远程仓储管理系统！</p></h3><br>
                    <h3><p>您好，可以在左侧或者上侧导航栏选择要使用的功能！</p></h3><br>
                    <h3><p>Remote WMS实现仓库真正的信息化、智能化、无纸化、快速反应、高效管理、安全管理。</p></h3>
                </div>
            </div>
<!-- Second row ends -->
            <footer class="text-right">
                <p>Copyright &copy; 2018 SignV 远程仓储管理系统
                    </p>
            </footer>
        </div>
    </div>
</div>
<!-- JS -->
<script src="${pageContext.request.contextPath}/static/js/jquery-1.11.2.min.js"></script>      <!-- jQuery -->
<script src="${pageContext.request.contextPath}/static/js/jquery-migrate-1.2.1.min.js"></script> <!--  jQuery Migrate Plugin -->

<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/templatemo-script.js"></script>      <!-- Templatemo Script -->

</body>
</html>