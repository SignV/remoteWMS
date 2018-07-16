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
    <!-- JS -->
    <script src="${pageContext.request.contextPath}/static/js/jquery-1.11.2.min.js"></script>      <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/static/js/jquery-migrate-1.2.1.min.js"></script> <!--  jQuery Migrate Plugin -->
    <script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
    <!-- <link href='http://fonts.useso.com/css?family=Open+Sans:400,300,400italic,700' rel='stylesheet' type='text/css'> -->
    <link href="${pageContext.request.contextPath}/static/css/font-awesome.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/templatemo-style.css" rel="stylesheet">

</head>
<body>
<!-- Left column -->
<div class="templatemo-flex-row">
    <div class="templatemo-sidebar">
        <header class="templatemo-site-header">
            <div class="square"></div>
            <h1>Remote WMS</h1>
        </header>
        <div class="profile-photo-container">
            <img src="${pageContext.request.contextPath}/static/images/profile-photo.jpg" alt="Profile Photo" class="img-responsive">
            <div class="profile-photo-overlay"></div>
        </div>
        <!-- Search box -->
        <form class="templatemo-search-form" role="search">
            <%--<div class="input-group">--%>
                <%--<button type="submit" class="fa fa-search"></button>--%>
                <%--<input type="text" class="form-control" placeholder="Search" name="srch-term" id="srch-term">--%>
            <%--</div>--%>
        </form>
        <div class="mobile-menu-icon">
            <i class="fa fa-bars"></i>
        </div>
        <nav class="templatemo-left-nav">
            <ul>
                <li><a href="${pageContext.request.contextPath}/goods/goodsInsert" class="" target="mainFrame"><i class="fa fa-home fa-fw"></i>货物信息登记</a></li>
                <li><a href="${pageContext.request.contextPath}/goods/goodsPageList?first=1" target="mainFrame"><i class="fa fa-bar-chart fa-fw"></i>货物列表</a></li>
                <li><a href="${pageContext.request.contextPath}/goods/getOutInStatisticsPageList?first=1" target="mainFrame"><i class="fa fa-database fa-fw"></i>出入库记录</a></li>
                <li><a href="${pageContext.request.contextPath}/epc/epcPageList?first=1" target="mainFrame"><i class="fa fa-map-marker fa-fw"></i>EPC码登记</a></li>
                <li><a href="${pageContext.request.contextPath}/user/getUserInfo" target="mainFrame"><i class="fa fa-sliders fa-fw"></i>个人中心</a></li>
                <c:if test="${admin!=null}">
                    <li><a href="${pageContext.request.contextPath}/admin/adminGetUserList?first=1" target="mainFrame"><i class="fa fa-eject fa-fw"></i>用户管理</a></li>
                    <li><a href="${pageContext.request.contextPath}/admin/addUser" target="mainFrame"><i class="fa fa-users fa-fw"></i>添加用户</a></li>
                </c:if>
            </ul>
        </nav>
    </div>

    <!-- Main content -->
    <div class="templatemo-content col-1 light-gray-bg" >
        <!-- 上方导航栏 -->
        <div class="templatemo-top-nav-container">
            <div class="row">
                <nav class="templatemo-top-nav col-lg-12 col-md-12">
                    <ul class="text-uppercase">
                        <li><a class="" href="${pageContext.request.contextPath}/enviroment/showEnvironment?first=1" target="mainFrame"><i class="fa fa-map-marker fa-fw"></i>仓库环境查看</a></li>
                        <li><a href="${pageContext.request.contextPath}/respository/showRespository?first=1" target="mainFrame"><i class="fa fa-home fa-fw"></i>仓库管理</a></li>
                        <li><a href="${pageContext.request.contextPath}/respository/respositoryInsert" target="mainFrame"><i class="fa fa-sliders fa-fw"></i>仓库信息登记</a></li>
                        <li><a href="${pageContext.request.contextPath}/user/logout"><i class="fa fa-eject fa-fw"></i>退出登录</a></li>
                    </ul>
                </nav>
            </div>
        </div>
        <!-- 内容区 -->
        <iframe src="${pageContext.request.contextPath}/views/user/show.jsp" id="mainFrame" name="mainFrame" frameborder="0" width="100%"  height="100%" frameBorder="0">
        </iframe>

    </div>

</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/templatemo-script.js"></script>      <!-- Templatemo Script -->

</body>
<script>
    $('.templatemo-left-nav li').click(function () {
        $('a').removeClass("active");
        $(this).children('a').addClass("active");
        $(this).children('a').css({'text-decoration':'none'});
    });
    $('.text-uppercase li').click(function () {
        $('a').removeClass("active");
        $(this).children('a').addClass("active");
        $(this).children('a').css({'text-decoration':'none'});
    });
</script>
</html>