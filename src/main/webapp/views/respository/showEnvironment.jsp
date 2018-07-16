<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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

</head>

<body>
<!-- Left column -->
<div class="templatemo-flex-row">

    <!-- Main content -->
    <div class="templatemo-content col-1 light-gray-bg">
        <!-- 上方导航栏 -->

        <!-- 内容区 -->
        <div class="templatemo-content-container">


            <div class="row templatemo-flex-row flex-content-row">
                <div class="col-md-6">
                    <div class="panel panel-default templatemo-content-widget white-bg no-padding templatemo-overflow-hidden">
                        <i class="fa fa-times"></i>
                        <div class="panel-heading templatemo-position-relative"><h2 class="text-uppercase">仓库温度记录</h2></div>
                        <div class="table-responsive">
                            <table class="table table-striped table-bordered" >
                                <thead>
                                <tr class="info">
                                    <td >温度</td>
                                    <td >仓库号</td>
                                    <td >传感器号</td>
                                    <td >记录时间</td>

                                </tr>
                                </thead>

                                <c:forEach items="${cenPageList}" var="cenPage">
                                    <tr class="">
                                        <td >${cenPage.centigradeNum}°C</td>
                                        <td >${cenPage.repositoryNum}</td>
                                        <td >${cenPage.sensorNum}</td>
                                        <td ><fmt:formatDate value="${cenPage.cenRecordDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                    </div>
                    <span>最大页数${maxCen}</span>
                    <div class="pagination-wrap">
                        <ul class="pagination" id="cenPagination">
                            <li><a href="${pageContext.request.contextPath}/enviroment/showCen?first=1">首页</a></li>
                            <c:forEach items="${cenPageSize}" var="page">
                                <li><a href="${pageContext.request.contextPath}/enviroment/showCen?first=${page}">${page}</a></li>
                            </c:forEach>
                            <li>&nbsp;<input id="pageValue" size="2">&nbsp;<button><a id="jump" style="color:#000">跳转</a></button></li>
                        </ul>
                    </div>

                </div>

                <div class="col-md-6">
                    <div class="panel panel-default templatemo-content-widget white-bg no-padding templatemo-overflow-hidden">
                        <i class="fa fa-times"></i>
                        <div class="panel-heading templatemo-position-relative"><h2 class="text-uppercase">仓库湿度记录</h2></div>
                        <div class="table-responsive">
                            <table class="table table-striped table-bordered" >
                                <thead>
                                <tr class="info">
                                    <td >湿度</td>
                                    <td >仓库号</td>
                                    <td >传感器号</td>
                                    <td >记录时间</td>
                                </tr>
                                </thead>

                                <c:forEach items="${humPageList}" var="humPage">
                                    <tr class="">
                                        <td >${humPage.humidityNum}</td>
                                        <td>${humPage.repositoryNum}</td>
                                        <td >${humPage.sensorNum}</td>
                                        <td ><fmt:formatDate value="${humPage.humRecordDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                    </div>
                    <span>最大页数${maxHum}</span>
                    <div class="pagination-wrap">
                        <ul class="pagination" id="humPagination">
                            <li><a href="${pageContext.request.contextPath}/enviroment/showHum?first=1">首页</a></li>
                            <c:forEach items="${humPageSize}" var="page">
                                <li><a href="${pageContext.request.contextPath}/enviroment/showHum?first=${page}">${page}</a></li>
                            </c:forEach>
                            <li style="margin-top: 10px">&nbsp;<input id="humValue" size="2">&nbsp;<button><a id="humJump" style="color:#000">跳转</a></button></li>
                        </ul>
                    </div>
                </div>
            </div> <!-- Second row ends -->

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

<script>
    var humNum = "${humNum}";
    if(humNum   != null){
        $('#humPagination li').eq(humNum-1).addClass("active");
    }else {
        $('#humPagination li').first().addClass("active");
    }
   var cenNum = "${cenNum}";
    if(cenNum   != null){
        $('#cenPagination li').eq(cenNum-1).addClass("active");
    }else {
        $('#cenPagination li').first().addClass("active");
    }

    $('#pageValue').blur(function () {
        var pageVal = $('#pageValue').val();
        $('#jump').attr("href","${pageContext.request.contextPath}/enviroment/jumpCen?first=" + pageVal);
    })
    $('#humValue').blur(function () {
        var humVal = $('#humValue').val();
        $('#humJump').attr("href","${pageContext.request.contextPath}/enviroment/showHum?first=" + humVal);
    })
    $('#jump').click(function () {
        var pageVal = $('#pageValue').val();
        if(pageVal== ""|| pageVal == null){
            return false;
        }
    })
    $('#humJump').click(function () {
        var humVal = $('#humValue').val();
        if(humVal== ""|| humVal == null){
            return false;
        }
    })
</script>
</html>