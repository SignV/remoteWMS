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
        .editBtn {
            background-color: #39ADB4;
            border: none;
            color: white;
            border-radius: 3px;
            padding: 6px 18px;
            transition: all 0.3s ease;
        }
        .editBtn:hover {
            color: white;
            background-color: #2A858B;
            /*border: 1px solid #2A858B;*/
        }
    </style>

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
                            <div class="panel-heading templatemo-position-relative"><h2 class="text-uppercase">${repositoryNum}号仓库货物列表</h2></div>
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered" >
                                    <thead>
                                    <tr class="info">
                                        <td >货物ID</td>
                                        <td >货物名字</td>
                                        <td >货物类型</td>
                                        <td >入库单价</td>
                                        <td >出库单价</td>
                                        <td >库存数量</td>
                                        <td >库存总价</td>
                                        <td >库存上限</td>
                                        <td>仓库号</td>
                                        <td >货物操作</td>
                                    </tr>
                                    </thead>

                                    <c:forEach items="${goodsList}" var="goods">
                                        <tr class="">
                                            <td >${goods.goodsId}</td>
                                            <td >${goods.goodsName}</td>
                                            <td >${goods.goodsType}</td>
                                            <td >${goods.stockPrice}</td>
                                            <td >${goods.salePrice}</td>
                                            <td >${goods.reserveNum}</td>
                                            <td >${goods.totalPrice}</td>
                                            <td >${goods.upperLimit}</td>
                                            <td>${goods.repositoryNumGoods}</td>
                                            <td >
                                                <div class="form-group text-right" style="margin-top: 9px">
                                                    <%--<a href="${pageContext.request.contextPath}/goods/getEditGoods?goodsId=${goods.goodsId}" target="_self"><button class="templatemo-blue-button">管理</button></a>--%>
                                                    <a href="${pageContext.request.contextPath}/goods/getEditGoods?goodsId=${goods.goodsId}" class="editBtn" target="_self">管理</a>
                                                    <%--<button class="templatemo-white-button" >删除</button>--%>
                                                </div>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </div>
                        </div>

                    <div class="pagination-wrap">
                        <ul class="pagination">
                            <li><a href="${pageContext.request.contextPath}/respository/goodsPageList?first=1&repositoryNum=${repositoryNum}">1</a></li>
                            <c:forEach items="${pageSize}" var="page">
                                <li><a href="${pageContext.request.contextPath}/respository/goodsPageList?first=${page}&repositoryNum=${repositoryNum}">${page}</a></li>
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

</script>
</html>