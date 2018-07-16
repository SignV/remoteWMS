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
        .text-mine{
            top: 18px;
            position: relative;
        }
    </style>
</head>
<body>
<!-- Left column -->
<div class="templatemo-flex-row">

    <!-- Main content -->
    <div class="templatemo-content col-1 light-gray-bg">
        <!-- 添加EPC码 -->
        <div class="templatemo-content-widget white-bg">
            <div class="square"></div>
            <h2 class="templatemo-inline-block">&nbsp;登记EPC码</h2>
            &emsp;<strong><span id="error" style="color: red;font-size: 16px"></span><hr></strong>

            <%--<label>货物 ID：<input type="text" id="goodsId" class="mine" name="goodsId" placeholder="无需填写，系统自动分配" value="" disabled></label>--%>
            <%--&emsp;&emsp;&emsp;<label >所属仓库号：<input type="text" id="repositoryNumGoods" class="mine" name="repositoryNumGoods" placeholder="" value=""></label><br>--%>
            <form class="templatemo-login-form" method="post" enctype="multipart/form-data">
                <div class="row form-group has-success">
                    <div class="col-lg-4 col-md-4 form-group">
                        <label for="epcCode">EPC码</label>
                        <input type="text" class="form-control" id="epcCode" name="epcCode" placeholder="">
                    </div>
                    <div class="col-lg-2 col-md-2 form-group">
                        <label for="goodsId">对应货物ID</label>
                        <input type="text" class="form-control" id="goodsId" name="goodsId" placeholder="">
                    </div>
                    <div class="col-lg-2 col-md-2 form-group">
                        <label >Epc码状态</label>
                        <input type="text" class="form-control" id="epcStatus" name="epcStatus" placeholder="" value="未入库" disabled>
                        <%--<select class="form-control" id="outInStatus">--%>
                            <%--<option value="out">出库</option>--%>
                            <%--<option value="in">入库</option>--%>
                        <%--</select>--%>
                    </div>
                    <div class="col-lg-2 col-md-2 form-group">
                        <label for="outInNum">出入库数量</label>
                        <input type="text" class="form-control" id="outInNum" name="outInNum" placeholder="">
                    </div>
                    <div class="col-lg-2 col-md-2 form-group">
                        <div class="form-group text-center text-mine">
                            <%--<a href="${pageContext.request.contextPath}/admin/getUserInfo?username=${user.userName}" class="editBtn" target="_self">登记</a>--%>
                            <button id="submitBtn" class="templatemo-blue-button">EPC码登记</button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
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
                                        <td >ID</td>
                                        <td >EPC码</td>
                                        <td >对应货物ID</td>
                                        <td >Epc码状态</td>
                                        <td >出入库数量</td>
                                        <td>EPC码登记时间</td>
                                    </tr>
                                    </thead>

                                    <c:forEach items="${epcPageList}" var="epc">
                                        <tr class="">
                                            <td >${epc.epcId}</td>
                                            <td >${epc.epcCode}</td>
                                            <td >${epc.epcGoodsId}</td>

                                            <c:if test="${epc.epcStatus == 1}">
                                                <td >未入库</td>
                                            </c:if>
                                            <c:if test="${epc.epcStatus == 2}">
                                                <td >入库</td>
                                            </c:if>
                                            <c:if test="${epc.epcStatus == 3}">
                                                <td >已出库</td>
                                            </c:if>
                                            <td >${epc.outInNum}</td>
                                            <td >
                                                <fmt:formatDate value="${epc.epcDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </div>
                        </div>

                    <div class="pagination-wrap">
                        <ul class="pagination">
                            <li><a href="${pageContext.request.contextPath}/epc/epcPageList?first=1">1</a></li>
                            <c:forEach items="${epcPageSize}" var="page">
                                <li><a href="${pageContext.request.contextPath}/epc/epcPageList?first=${page}">${page}</a></li>
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
    var num = "${epcNum}";
    // alert(num);
    if(num   != null){
        $('.pagination li').eq(num-1).addClass("active");
    }else {
        $('.pagination li').first().addClass("active");
    }
    $('#submitBtn').click(function () {
        $("#error").html("");
        var epcCode = $("#epcCode").val();
        var goodsId = $("#goodsId").val();
        var outInNum = $("#outInNum").val();
        if (epcCode == null || epcCode == "") {
            $("#error").html("EPC码不能为空");
            return false;
        }
        if (goodsId == null || goodsId == "") {
            $("#error").html("货物ID不能为空");
            return false;
        }
        if (outInNum == null || outInNum == "") {
            $("#error").html("出入库数量不能为空");
            return false;
        }
        var dataEpc = {};
        dataEpc.epcCode = $('#epcCode').val();
        dataEpc.epcGoodsId = $('#goodsId').val();
        dataEpc.epcStatus = 1;
        dataEpc.outInNum = $('#outInNum').val();
        var epc = JSON.stringify(dataEpc);
        // debugger
        $.ajax(
            {
                type:"post",
                dataType:"json",
                url:"${pageContext.request.contextPath}/epc/epcInsert",
                data:{
                    "epc":epc
                },
                success:function (data) {
                    alert("EPC码登记成功!");
                    // $('#editInfo').show();
                },
                error:function (XMLHttpRequest, textStatus, errorThrown) {
                    alert("fail");
                    window.location.reload();
                    // 状态码
                    console.log(XMLHttpRequest.status);
                    // 状态
                    console.log(XMLHttpRequest.readyState);
                    // 错误信息
                    console.log(textStatus);
                    //服务器抛出返回的错误信息
                    console.log(errorThrown);
                    <%--window.location.href="${pageContext.request.contextPath}/goods/getEditGoods?goodsId=${goods.goodsId}";--%>
                },
                async: false
            }
        );
    })
</script>
</html>