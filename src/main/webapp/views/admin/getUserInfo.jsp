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
    <style type="text/css">
        #userName{
            border: 1px solid #ccc;
            border-radius: 4px;
            height: 27px;
            border-color: #13895F;
            padding: 6px 12px;
            font-size: 14px;
            transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
            font-family: inherit;
        }
        #userName:focus{
            border-color: #13895F;
            outline: 0;
            box-shadow: inset 0 1px 1px rgba(19,137,95,.075),0 0 8px rgba(19,137,95,.6);
        }
        #userId{
            border: 1px solid #ccc;
            border-radius: 4px;
            height: 30px;
            /*border-color: #13895F;*/
            padding: 6px 12px;
            font-size: 14px;
            transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
            font-family: inherit;
        }
        #userId:hover{
            cursor: not-allowed;
        }

        .editBtn {
            background-color: #39ADB4;
            border: none;
            color: white;
            border-radius: 3px;
            padding: 8px 24px;
            transition: all 0.3s ease;
            margin-right: 20px;
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
</head>
<body>
<div class="templatemo-content-container light-gray-bg" style="height: 900px">
    <div class="templatemo-content-widget white-bg">
        <div class="square"></div>
        <h2 class="templatemo-inline-block">&nbsp;用户管理</h2><hr>
                <label>用户ID：${userInfo.userId}</label>
        &emsp;&emsp;&emsp;  <label >用户账号：${userInfo.userName}</label><br>
        <form class="templatemo-login-form" method="post" enctype="multipart/form-data">
            <div class="row form-group has-success">
                <div class="col-lg-6 col-md-6 form-group">
                    <label>用户姓名</label>
                    <input type="text" class="form-control" id="realName" name="realName" placeholder="" value="${userInfo.realName}">
                </div>
                <div class="col-lg-6 col-md-6 form-group">
                    <label>联系电话</label>
                    <input type="text" class="form-control" id="phoneNumber" name="phoneNumber" placeholder="" value="${userInfo.phoneNumber}">
                </div>
            </div>

            <div class="row form-group has-success">
                <div class="col-lg-6 col-md-6 form-group">
                    <label >电子邮箱</label>
                    <input type="text" class="form-control" id="email" name="email" placeholder="" value="${userInfo.email}">
                </div>
                <div class="col-lg-6 col-md-6 form-group">
                    <label >身份证号</label>
                    <input type="text" class="form-control" id="identity_number" name="identity_number" placeholder="" value="${userInfo.identityNumber}">
                </div>
            </div>

            <div class="row form-group has-success">
                <div class="col-lg-6 col-md-6 form-group">
                    <label >用户创建时间</label>

                    <input type="text" class="form-control" id="createTime" name="createTime" placeholder=""
                           value="<fmt:formatDate value="${userInfo.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
                           style="cursor: not-allowed;" disabled>
                </div>
                <div class="col-lg-6 col-md-6 form-group">
                    <label >用户备注</label>
                    <input type="text" class="form-control" id="remark" name="remark" placeholder="" value="${userInfo.remark}">
                </div>
            </div>


            <div class="row form-group has-success">
                <div class="col-lg-12 col-md-12 form-group">
                    <a href="javascript:void(0);" onclick="show_modal()" class="editBtn">修改密码</a>
                    <%--<button id="modifyPW" class="templatemo-blue-button">修改密码</button>--%>
                </div>
            </div>

            <div class="form-group text-right">
                <span id="editInfo" style="color: #13895F" hidden="true"></span>

                <%--<button id="modifyPW" class="templatemo-blue-button">修改密码</button>--%>
                <button id="submitBtn" class="templatemo-blue-button">更新信息</button>
                <button id="deleteBtn" class="templatemo-white-button">删除</button>
            </div>
        </form>
    </div>
    <footer class="text-right">
        <p>Copyright &copy; 2018 SignV 远程仓储管理系统
        </p>
    </footer>
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
                        修改密码
                    </h3>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" role="form">
                        <div class="form-group">
                            <label  class="col-sm-3 control-label">原密码</label>
                            <div class="col-sm-9">
                                <input type="password" class="form-control" id="oldPW" name="oldPW" value=""
                                       >
                            </div>
                        </div>

                        <div class="form-group">
                            <label  class="col-sm-3 control-label">新密码</label>
                            <div class="col-sm-9">
                                <input type="password" class="form-control" id="newPW1" name="newPW1" value=""
                                       placeholder="">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">确认新密码</label>
                            <div class="col-sm-9">
                                <input type="password" class="form-control" name="newPW2" value="" id="newPW2"
                                       placeholder="">
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <span><font color="red" id="error" hidden="true">${errorInfo }</font></span>
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                    </button>
                    <button type="button" id="changePW" class="btn btn-primary">
                        提交
                    </button><span id="tip"> </span>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>
</form>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/templatemo-script.js"></script>      <!-- Templatemo Script -->
</body>
<script>
    //提交ajax表单
    $('#submitBtn').click(function () {
        var dataUser = {};
        dataUser.userId = "${userInfo.userId}";
        dataUser.userName = $('#userName').val();
        dataUser.realName = $('#realName').val();
        dataUser.phoneNumber = $('#phoneNumber').val();
        dataUser.email = $('#email').val();
        dataUser.identityNumber = $('#identity_number').val();
        dataUser.remark = $('#remark').val();
        dataUser.createTime = $('#createTime').val();

        var user = JSON.stringify(dataUser);
        // debugger
        $.ajax(
            {
                type:"post",
                dataType:"json",
                url:"${pageContext.request.contextPath}/admin/modifyUserInfo",
                data:{
                    "user":user
                },
                success:function (data) {
                    alert("更新用户信息操作成功!");
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

    function show_modal() {
        $("#error").hide();
        $('#oldPW').val("");
        $('#newPW1').val("");
        $('#newPW2').val("");
        $('#myModal').modal('show');
    }

    $('#changePW').click(function () {
        var oldPW = $('#oldPW').val();
        var newPW1 = $('#newPW1').val();
        var newPW2 = $('#newPW2').val();
        if(newPW1 != newPW2){
            $("#error").html("两次输入的新密码不一样！");
            $("#error").show();
            return false;
        }else {
            $("#error").hide();
            $.ajax(
                {
                    type:"post",
                    dataType:"json",
                    url:"${pageContext.request.contextPath}/admin/changePassword",
                    data:{
                        "oldPW":oldPW,
                        "newPW1":newPW1
                    },
                    success:function (data) {
                        if(data.changeInfo){
                            alert(data.errorInfo);
                            $('#myModal').modal('hide');
                        }else {
                            $("#error").html(data.errorInfo);
                            $("#error").show();
                        }
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
                    }
                    // ,
                    // async: false
                }
            );
        }
    });

    $('#deleteBtn').click(function () {
        var userId = ${userInfo.userId};
        $.ajax(
            {
                type:"post",
                dataType:"json",
                url:"${pageContext.request.contextPath}/admin/deleteUser",
                data:{
                    "userId":userId
                },
                success:function (data) {
                    alert("该用户删除成功!");
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