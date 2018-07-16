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
        #repositoryNumGoods{
            border: 1px solid #ccc;
            border-radius: 4px;
            height: 27px;
            border-color: #13895F;
            padding: 6px 12px;
            font-size: 14px;
            transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
            font-family: inherit;
        }
        #repositoryNumGoods:focus{
            border-color: #13895F;
            outline: 0;
            box-shadow: inset 0 1px 1px rgba(19,137,95,.075),0 0 8px rgba(19,137,95,.6);
        }
        #repository_num{
            border: 1px solid #ccc;
            border-radius: 4px;
            height: 30px;
            /*border-color: #13895F;*/
            padding: 6px 12px;
            font-size: 14px;
            transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
            font-family: inherit;
        }
        #repository_num:hover{
            cursor: not-allowed;
        }
    </style>
</head>
<body>
<div class="templatemo-content-container light-gray-bg">
    <div class="templatemo-content-widget white-bg">
        <div class="square"></div>
        <h2 class="templatemo-inline-block">&nbsp;登记仓库信息</h2><hr>

            <label>仓库号：<input type="text" id="repository_num" class="mine" name="repository_num" placeholder="无需填写，系统自动分配" value="" disabled></label>

        <form class="templatemo-login-form" method="post" enctype="multipart/form-data">
            <div class="row form-group has-success">
                <div class="col-lg-6 col-md-6 form-group">
                    <label for="repository_name">仓库名</label>
                    <input type="text" class="form-control" id="repository_name" name="repository_name" placeholder="" value="">
                </div>
                <div class="col-lg-6 col-md-6 form-group">
                    <label for="goods_type">适用货品</label>
                    <input type="text" class="form-control" id="goods_type" name="goods_type" placeholder="" value="">
                </div>
            </div>
            <div class="row form-group has-success">
                <div class="col-lg-6 col-md-6 form-group">
                    <label for="nearby_transport_point">周边运输网点</label>
                    <input type="text" class="form-control" id="nearby_transport_point" name="nearby_transport_point" placeholder="" value="">
                </div>
                <div class="col-lg-6 col-md-6 form-group">
                    <label for="save_type">仓库类型	</label>
                    <input type="text" class="form-control" id="save_type" name="save_type  " placeholder="" value="">
                </div>
            </div>


            <div class="row form-group has-success">
                <div class="col-lg-6 col-md-6 form-group">
                    <label >仓库状态</label>
                    <select class="form-control" id="repository_status">
                        <option value="notfull">未满（可入库）</option>
                        <option value="full">已满</option>
                    </select>
                </div>
                <div class="col-lg-6 col-md-6 form-group">
                    <label for="built_area">建筑面积（单位㎡）</label>
                    <input type="text" class="form-control" id="built_area" name="built_area" value="" >
                </div>
            </div>

            <div class="row form-group has-success">
                <div class="col-lg-6 col-md-6 form-group">
                <label class="">仓库地址</label>
                <input type="text" class="form-control" id="repository_address" name="repository_address" value="" >
                </div>
            </div>

            <div class="form-group text-right">
                <span id="editInfo" style="color: #13895F" hidden="true">货物管理操作成功</span>
                <strong><span id="error" style="color: red;font-size: 15px"></span></strong>
                &emsp;
                <button id="submitBtn" class="templatemo-blue-button">Update</button>
                <button type="reset" class="templatemo-white-button">Reset</button>
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
    //提交ajax表单
    $('#submitBtn').click(function () {
        $("#error").html("");
        var repository_name = $("#repository_name").val();
        var goods_type = $("#goods_type").val();
        var save_type = $("#save_type").val();
        var repository_address = $("#repository_address").val();
        if (repository_name == null || repository_name == "") {
            $("#error").html("仓库名不能为空");
            return false;
        }
        if (goods_type == null || goods_type == "") {
            $("#error").html("适用货品不能为空");
            return false;
        }
        if (save_type == null || save_type == "") {
            $("#error").html("仓库类型不能为空");
            return false;
        }
        if (repository_address == null || repository_address == "") {
            $("#error").html("仓库地址不能为空");
            return false;
        }

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

        var respository = JSON.stringify(dataRepository);
        // debugger
        $.ajax(
            {
                type:"post",
                dataType:"json",
                url:"${pageContext.request.contextPath}/respository/repositoryInsertAdd",
                data:{
                    "respository":respository
                },
                success:function (data) {
                    alert("仓库信息添加操作成功!");
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
    });
</script>
</html>