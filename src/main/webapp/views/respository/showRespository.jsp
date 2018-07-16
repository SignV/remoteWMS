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
    <!-- JS -->
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.3.1.min.js"></script>      <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/static/js/jquery-migrate-1.2.1.min.js"></script> <!--  jQuery Migrate Plugin -->
    <script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
    <!-- <link href='http://fonts.useso.com/css?family=Open+Sans:400,300,400italic,700' rel='stylesheet' type='text/css'> -->
    <link href="${pageContext.request.contextPath}/static/css/font-awesome.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/templatemo-style.css" rel="stylesheet">

</head>
<style type="text/css">
    .editBtn {
        background-color: #39ADB4;
        border: none;
        color: white;
        border-radius: 3px;
        padding: 5px 15px;
        transition: all 0.3s ease;
    }
    .editBtn:hover {
        color: white;
        background-color: #2A858B;
        /*border: 1px solid #2A858B;*/
    }
    .modal {
        margin: 0 auto;
        position: fixed;
        top: 30%;
        left: 20%;
        /*margin: -100px 0 0 -100px;!* margin 负值为宽高的一半 *!*/
    }
</style>
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
                        <div class="panel-heading templatemo-position-relative"><h2 class="text-uppercase">仓库信息</h2></div>
                        <div class="table-responsive">
                            <table class="table table-hover table-bordered table-striped">
                                <%--<thead>--%>
                                <tr class="info">
                                    <th>仓库号</th>
                                    <th>仓库名</th>
                                    <%--<th>仓库地址</th>--%>
                                    <th>适用货品</th>
                                    <th>周边运输网点</th>
                                    <th>仓库类型</th>
                                    <th>建筑面积</th>
                                    <th>仓库状态</th>
                                    <th>仓库操作</th>
                                </tr>
                                <%--</thead>--%>
                                <c:forEach items="${repositoryList}" var="repository">
                                    <tr class="">
                                        <td >${repository.repositoryNum}</td>
                                        <td >${repository.repositoryName}</td>
                                            <%--<td >${repository.repositoryAddress}</td>--%>
                                        <td >${repository.goodsType}</td>
                                        <td >${repository.nearbyTransportPoint}</td>
                                        <td >${repository.saveType}</td>
                                        <td >${repository.builtArea}</td>
                                        <td >
                                            <c:if test="${repository.repositoryStatus}">
                                                已满
                                            </c:if>
                                            <c:if test="${!repository.repositoryStatus}">
                                                未满（可入库）
                                            </c:if>
                                        </td>
                                        <td >
                                            <div class="form-group text-right" style="margin-top: 9px">
                                                    <%--<a href="${pageContext.request.contextPath}/goods/getEditGoods?goodsId=${goods.goodsId}" target="_self"><button class="templatemo-blue-button">管理</button></a>--%>
                                                <%--<a href="${pageContext.request.contextPath}/repository/getEditGoods?goodsId=${goods.goodsId}" class="editBtn" target="_self">管理</a>--%>
                                                        <!-- 按钮触发模态框 -->
                                                        <a href="javascript:void(0);" onclick="show_modal(
                                                            ${repository.repositoryNum},
                                                            '${repository.repositoryName}',
                                                            '${repository.goodsType}',
                                                            '${repository.nearbyTransportPoint}',
                                                            '${repository.saveType}',
                                                                '${repository.builtArea}',
                                                                ${repository.repositoryStatus},
                                                                '${repository.repositoryAddress}')" class="editBtn">管理</a>
                                                        <a href="${pageContext.request.contextPath}/respository/goodsPageList?first=1&repositoryNum=${repository.repositoryNum}" class="editBtn" target="_self">查看</a>
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
                            <li><a href="${pageContext.request.contextPath}/respository/showRespository?first=1">1</a></li>
                            <c:forEach items="${pageSize}" var="page">
                                <li><a href="${pageContext.request.contextPath}/respository/showRespository?first=${page}">${page}</a></li>
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

<!-- 模态框示例（Modal） -->
<form method="post" action="" class="form-horizontal" role="form" id="form_data"  style="margin: 20px;">
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h3 class="modal-title" id="">
                        仓库信息操作
                    </h3>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" role="form">
                        <div class="form-group">
                            <label for="repository_name" class="col-sm-3 control-label">仓库号</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="repository_num" name="repository_num" value=""
                                       style="border: none" disabled>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="repository_name" class="col-sm-3 control-label">仓库名</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="repository_name" name="repository_name" value=""
                                       placeholder="仓库名">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">适用货品</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" name="goods_type" value="" id="goods_type"
                                       placeholder="适用货品">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="nearby_transport_point" class="col-sm-3 control-label">附近物流</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" name="nearby_transport_point" value="" id="nearby_transport_point"
                                       placeholder="附近物流">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">仓库类型</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" name="save_type" value="" id="save_type"
                                       placeholder="仓库类型">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">建筑面积</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" name="built_area" value="" id="built_area"
                                       placeholder="建筑面积">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">仓库状态</label>
                            <div class="col-sm-9">
                                <select class="form-control" id="repository_status">
                                    <option value="notfull">未满（可入库）</option>
                                    <option value="full">已满</option>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">仓库地址</label>
                            <div class="col-sm-9">
                                <textarea  style="resize:none" class="form-control"  name="repository_address" value="" id="repository_address"
                                           placeholder="仓库地址">
                                </textarea>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <div style="float: left">
                        <button type="button" id="open" class="btn btn-primary">
                            开启仓库管理
                        </button>
                        <button type="button" id="close" class="btn btn-danger">
                            关闭仓库管理
                        </button>
                    </div>

                    <button type="button" id="deleteBtn" class="btn btn-danger">删除</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                    </button>
                    <button type="button" id="submitBtn" class="btn btn-primary">
                        提交
                    </button><span id="tip"> </span>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>
</form>
<!-- <script src="https://www.google.com/jsapi"></script> Google Chart -->
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

   function show_modal(repositoryNum,repositoryName,goodsType,nearbyTransportPoint,
                       saveType,builtArea,repositoryStatus,repositoryAddress) {
       $('#repository_num').val(repositoryNum);
       $('#repository_name').val(repositoryName);
       $('#goods_type').val(goodsType);
       $('#nearby_transport_point').val(nearbyTransportPoint);
       $('#save_type').val(saveType);
       $('#built_area').val(builtArea);
       if(repositoryStatus){
            $('#repository_status').val('full');
       }else {
           $('#repository_status').val('notfull');
       }

        $('#repository_address').val(repositoryAddress);
        $('#myModal').modal('show');
    };
    $(function () {
        $('#submitBtn').click(function () {
            var dataRepository = {};
            dataRepository.repositoryNum = $('#repository_num').val();
            dataRepository.repositoryName = $('#repository_name').val();
            dataRepository.goodsType = $('#goods_type').val();
            dataRepository.nearbyTransportPoint = $('#nearby_transport_point').val();
            dataRepository.saveType = $('#save_type').val();
            dataRepository.builtArea = $('#built_area').val();
            if($('#repository_status').val() == 'full'){
                dataRepository.repositoryStatus = true;
            }else {
                dataRepository.repositoryStatus = false;
            }

            dataRepository.repositoryAddress = $('#repository_address').val();

            var repository = JSON.stringify(dataRepository);
            $.ajax(
                {
                    type:"post",
                    dataType:"json",
                    url:"${pageContext.request.contextPath}/respository/editRespository",
                    data:{
                        "repository":repository
                    },
                    success:function (data) {
                        // alert(data);
                        alert("修改仓库信息成功!");
                        window.location.reload();
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
                    // async: false,
                    complete:function () {
                        $('#myModal').modal('hide');
                    }
                }
            );
        });
    });

    $('#deleteBtn').click(function () {
        var repositoryNum = $('#repository_num').val();
        $.ajax(
            {
                type:"post",
                dataType:"json",
                url:"${pageContext.request.contextPath}/respository/deleteRespository",
                data:{
                    "respositoryNum":repositoryNum
                },
                success:function (data) {
                    alert("该仓库删除成功!");
                    // $('#editInfo').show();
                },
                error:function (XMLHttpRequest, textStatus, errorThrown) {
                    alert("删除失败！");
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
                async: false,
                complete:function () {
                    $('#myModal').modal('hide');
                    window.location.reload();
                }
            }
        )
    })

    $('#open').click(function () {
        var repositoryNum = $('#repository_num').val();
        $.ajax(
            {
                type:"post",
                dataType:"json",
                url:"${pageContext.request.contextPath}/respository/openRespository",
                data:{
                    "respositoryNum":repositoryNum
                },
                success:function (data) {
                    alert("该仓库管理开启!");
                    // $('#editInfo').show();
                },
                error:function (XMLHttpRequest, textStatus, errorThrown) {
                    alert("删除失败！");
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
        )
    })

    $('#close').click(function () {
        var repositoryNum = $('#repository_num').val();
        $.ajax(
            {
                type:"post",
                dataType:"json",
                url:"${pageContext.request.contextPath}/respository/closeRespository",
                data:{
                    "respositoryNum":repositoryNum
                },
                success:function (data) {
                    alert("该仓库管理关闭!");
                    // $('#editInfo').show();
                },
                error:function (XMLHttpRequest, textStatus, errorThrown) {
                    alert("删除失败！");
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
        )
    })
</script>
</html>