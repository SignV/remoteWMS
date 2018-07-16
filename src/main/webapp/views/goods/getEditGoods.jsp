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
</head>
<body>
<div class="templatemo-content-container light-gray-bg">
    <div class="templatemo-content-widget white-bg">
        <div class="square"></div>
        <h2 class="templatemo-inline-block">&nbsp;货物管理</h2><hr>
        <label>货物 ID：${goods.goodsId}</label>
        &emsp;&emsp;&emsp;<label>所属仓库号：${goods.repositoryNumGoods}<input type="text" id="repositoryNumGoods" name="repositoryNumGoods" placeholder="" value="${goods.repositoryNumGoods}" style="border: none;display: none" ></label><br>
        <form class="templatemo-login-form" method="post" enctype="multipart/form-data">
            <div class="row form-group has-success">
                <div class="col-lg-6 col-md-6 form-group">
                    <label for="goodsName">货物名字</label>
                    <input type="text" class="form-control" id="goodsName" name="goodsName" placeholder="" value="${goods.goodsName}">
                </div>
                <div class="col-lg-6 col-md-6 form-group">
                    <label for="goodsType">货物类型</label>
                    <input type="text" class="form-control" id="goodsType" name="goodsType" placeholder="" value="${goods.goodsType}">
                </div>
            </div>
            <div class="row form-group has-success">
                <div class="col-lg-6 col-md-6 form-group">
                    <label for="stockPrice">入库单价</label>
                    <input type="text" class="form-control" id="stockPrice" name="stockPrice" placeholder="" value="${goods.stockPrice}">
                </div>
                <div class="col-lg-6 col-md-6 form-group">
                    <label for="salePrice">出库单价</label>
                    <input type="text" class="form-control" id="salePrice" name="salePrice" placeholder="" value="${goods.salePrice}">
                </div>
            </div>


            <div class="row form-group has-success">
                <div class="col-lg-6 col-md-6 form-group">
                    <label for="reserveNum">库存数量</label>
                    <input type="text" class="form-control" id="reserveNum" name="reserveNum" value="${goods.reserveNum}">
                </div>
                <div class="col-lg-6 col-md-6 form-group">
                    <label for="totalPrice">库存总价</label>
                    <input type="text" class="form-control" id="totalPrice" name="totalPrice" value="${goods.totalPrice}">
                </div>
            </div>

            <div class="row form-group has-success">
                <div class="col-lg-6 col-md-6 form-group">
                    <label for="upperLimit">库存数量上限</label>
                    <input type="text" class="form-control" id="upperLimit" name="upperLimit" placeholder="" value="${goods.upperLimit}">
                </div>

                <div class="col-lg-6 col-md-6 form-group">
                    <label for="remark">库存管理备注</label>
                    <input type="text" class="form-control" id="remark" name="remark" placeholder="出入库管理备注" value="${goods.remark}">
                </div>
            </div>

            <div class="row form-group has-success">
                <div class="col-lg-6 col-md-6 form-group">
                    <label >出入库</label>
                    <select class="form-control" id="outInStatus">
                        <option value="out">出库</option>
                        <option value="in">入库</option>
                    </select>
                </div>
                <div class="col-lg-6 col-md-6 form-group">
                    <label for="outInNum">出入库数量</label>
                    <input type="text" class="form-control" id="outInNum" placeholder="请输入出入库的数量" value="0">
                </div>
            </div>
            <div class="form-group text-right">
                <span id="editInfo" style="color: #13895F" hidden="true">货物管理操作成功</span>
                <button id="submitBtn" class="templatemo-blue-button">更新</button>
                <button id="deleteBtn" class="templatemo-white-button">删除</button>
            </div>
        </form>
    </div>
    <footer class="text-right">
        <p>Copyright &copy; 2018 SignV 远程仓储管理系统
        </p>
    </footer>
</div>
<!-- JS -->
<script src="${pageContext.request.contextPath}/static/js/jquery-1.11.2.min.js"></script>      <!-- jQuery -->
<script src="${pageContext.request.contextPath}/static/js/jquery-migrate-1.2.1.min.js"></script> <!--  jQuery Migrate Plugin -->

<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/templatemo-script.js"></script>      <!-- Templatemo Script -->

</body>
<script>
    //获取实时的库存总价格
    $('#stockPrice').bind('input propertychange', function() {
        var reserveNum = $('#reserveNum').val();
        $('#totalPrice').val($(this).val() * reserveNum);
    });
    $('#reserveNum').bind('input propertychange', function() {
        var stockPrice = $('#stockPrice').val();
        $('#totalPrice').val($(this).val() * stockPrice);
    });

    //获取实时的库存数量
    <%--var thisRNum = "${goods.reserveNum}";--%>
    <%--$('#outInNum').blur(function() {--%>
        <%--var status = $('#outInStatus').val();--%>
        <%--var num = $('#outInNum').val();--%>
        <%--var rNum = $('#reserveNum').val();--%>
        <%--if(num != "" && num != 0){--%>
            <%--if(status == "out"){--%>
                <%--//出库减少--%>
                <%--$('#reserveNum').val((rNum - $(this).val()));--%>
            <%--}else {--%>
                <%--//入库增加--%>
                <%--$('#reserveNum').val(parseInt(rNum) + parseInt($(this).val()));--%>
            <%--}--%>
        <%--}else {--%>
            <%--$('#reserveNum').val(thisRNum);--%>
        <%--}--%>
    <%--});--%>
    //提交ajax表单
    $('#submitBtn').click(function () {
        var dataGoods = {};
        dataGoods.goodsId = "${goods.goodsId}";
        dataGoods.goodsName = $('#goodsName').val();
        dataGoods.goodsType = $('#goodsType').val();
        dataGoods.stockPrice = $('#stockPrice').val();
        dataGoods.salePrice = $('#salePrice').val();
        dataGoods.reserveNum = $('#reserveNum').val();
        dataGoods.totalPrice = $('#totalPrice').val();
        dataGoods.upperLimit = $('#upperLimit').val();
        dataGoods.repositoryNumGoods = $('#repositoryNumGoods').val();
        dataGoods.remark = $('#remark').val();
        // dataGoods.storyList = [{'id':'471163085038686208','type':44}]

        var goods = JSON.stringify(dataGoods);
        var outInStatus = $("#outInStatus ").val();
        var outInNum = $("#outInNum").val();
        // debugger
        $.ajax(
            {
                type:"post",
                dataType:"json",
                url:"${pageContext.request.contextPath}/goods/editGoods",
                data:{
                    "goods":goods,
                    "outInStatus":outInStatus,
                    "outInNum":outInNum
                },
                success:function (data) {
                    alert("货物管理操作成功!");
                    // $('#editInfo').show();
                },
                error:function (XMLHttpRequest, textStatus, errorThrown) {
                    alert("货物操作失败！");
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
    });

    $('#deleteBtn').click(function () {
        var goodsId = ${goods.goodsId};
      $.ajax(
          {
              type:"post",
              dataType:"json",
              url:"${pageContext.request.contextPath}/goods/deleteGoods",
              data:{
                  "goodsId":goodsId
              },
              success:function (data) {
                  alert("货物删除成功!");
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