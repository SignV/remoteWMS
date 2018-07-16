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


            <div class="templatemo-flex-row flex-content-row">
                <div class="col-1">
                        <div class="panel panel-default templatemo-content-widget white-bg no-padding templatemo-overflow-hidden">
                            <i class="fa fa-times"></i>
                            <div class="panel-heading templatemo-position-relative"><h2 class="text-uppercase">出入库记录</h2></div>
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered" >
                                    <thead>
                                    <tr class="info">
                                        <td >出入库ID</td>
                                        <td >货物ID</td>
                                        <td >货物名</td>
                                        <td >出入库数量</td>
                                        <td >出库/入库</td>
                                        <td >出入库总金额</td>
                                        <td >出入库日期</td>
                                    </tr>
                                    </thead>

                                    <c:forEach items="${outInStatisticsList}" var="outInStatistics">
                                        <tr class="">
                                            <td >${outInStatistics.outInId}</td>
                                            <td >${outInStatistics.outInGoodsId}</td>
                                            <td >${outInStatistics.outInGoodsName}</td>
                                            <td >${outInStatistics.outInNum}</td>
                                            <c:if test="${outInStatistics.outInStatus == true}">
                                                <td >出库</td>
                                            </c:if>
                                            <c:if test="${outInStatistics.outInStatus != true}">
                                                <td >入库</td>
                                            </c:if>
                                            <td >${outInStatistics.outInAmount}</td>
                                            <td >
                                                <fmt:formatDate value="${outInStatistics.outInDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </div>
                        </div>

                    <div class="pagination-wrap">
                        <ul class="pagination">
                            <li><a href="${pageContext.request.contextPath}/goods/getOutInStatisticsPageList?first=1">1</a></li>
                            <c:forEach items="${pageSize}" var="page">
                                <li><a href="${pageContext.request.contextPath}/goods/getOutInStatisticsPageList?first=${page}">${page}</a></li>
                            </c:forEach>
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
    var num = "${num}";
    // alert(num);
    if(num   != null){
        $('.pagination li').eq(num-1).addClass("active");
    }else {
        $('.pagination li').first().addClass("active");
    }

    // $('.pagination li').click(function () {
    //     $('a').removeClass("active");
    //     $(this).children('a').addClass("active");
    // });
</script>
</html>