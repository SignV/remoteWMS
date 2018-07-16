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
        <h2 class="templatemo-inline-block">&nbsp;添加用户</h2><hr>

        <label>用户ID：<input type="text" id="userId" class="mine" name="userId" placeholder="无需填写，系统自动分配" value="" disabled></label>
        &emsp;&emsp;&emsp;<label >用户账号：<input type="text" id="userName" class="mine" name="userName" placeholder="" value=""></label>
        &emsp;<strong><span><font color="red" id="errorUser" hidden="true"></font></span></strong><br>

        <form class="templatemo-login-form" method="post" enctype="multipart/form-data">
            <div class="row form-group has-success">
                <div class="col-lg-6 col-md-6 form-group">
                    <label >密码</label>
                    <input type="text" class="form-control" id="password1" name="password1" placeholder="" value="">
                </div>
                <div class="col-lg-6 col-md-6 form-group">
                    <label >确认密码</label>
                    <input type="text" class="form-control" id="password2" name="password2" placeholder="" value="">
                </div>
            </div>

            <div class="row form-group has-success">
                <div class="col-lg-6 col-md-6 form-group">
                    <label>用户姓名</label>
                    <input type="text" class="form-control" id="realName" name="realName" placeholder="" value="">
                </div>
                <div class="col-lg-6 col-md-6 form-group">
                    <label>联系电话</label>
                    <input type="text" class="form-control" id="phoneNumber" name="phoneNumber" placeholder="" value="">
                </div>
            </div>

            <div class="row form-group has-success">
                <div class="col-lg-6 col-md-6 form-group">
                    <label >电子邮箱</label>
                    <input type="text" class="form-control" id="email" name="email" placeholder="" value="">
                </div>
                <div class="col-lg-6 col-md-6 form-group">
                    <label >身份证号</label>
                    <input type="text" class="form-control" id="identity_number" name="identity_number" placeholder="" value="">
                </div>
            </div>

            <div class="row form-group has-success">

                <div class="col-lg-6 col-md-6 form-group">
                    <label >用户备注</label>
                    <input type="text" class="form-control" id="remark" name="remark" placeholder="" value="">
                </div>
            </div>
            <div class="form-group text-right">
                <span id="editInfo" style="color: #13895F" hidden="true"></span>
                <strong><span><font color="red" id="error" hidden="true">${errorInfo }</font></span></strong>
                <button id="submitBtn" class="templatemo-blue-button">添加用户</button>
                <button type="reset" class="templatemo-white-button">Reset</button>
            </div>
        </form>
    </div>
    <footer class="text-right">
        <p>Copyright &copy; 2018 SignV 远程仓储管理系统
        </p>
    </footer>
</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/templatemo-script.js"></script>      <!-- Templatemo Script -->
</body>
<script>
    $('#userName').blur(function () {
       var userName = $(this).val();
       if(userName == ""){
           $("#errorUser").html("用户账号不能为空！");
           $("#errorUser").show();
       }else{
           $.ajax(
               {
                   type:"post",
                   dataType:"json",
                   url:"${pageContext.request.contextPath}/admin/checkUsername",
                   data:{
                       "userName":userName
                   },
                   success:function (data) {
                       // alert(data.errorInfo);
                       $("#errorUser").html(data.errorInfo);
                       $("#errorUser").show();
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
               }
           );
       }
    });
    $('#password2').blur(function () {
        var password1 = $('#password1').val();
        var password2 = $('#password2').val();
        if(password1 == "" || password2 == ""){
            $("#error").html("密码不能为空！");
            $("#error").show();
        }else if(password1 != password2) {
            $("#error").html("两次输入的密码不一样！");
            $("#error").show();
        }else{
            $('#error').hide();
        }
    });
    //提交ajax表单
    $('#submitBtn').click(function () {
            $("#error").hide();
            var dataUser = {};
            dataUser.userName = $('#userName').val();
            dataUser.userPassword = $('#password1').val();
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
                    url:"${pageContext.request.contextPath}/admin/insertUser",
                    data:{
                        "user":user
                    },
                    success:function (data) {
                        alert(data.errorInfo);
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
    //验证手机号
    $('#phoneNumber').blur(function () {
        var pattern = /^1[34578]\d{9}$/;
        var result = pattern.test($(this).val());
        if($(this).val() == ""){
            $("#error").html("联系电话不能为空！");
            $("#error").show();
        }else if(!result){
            $("#error").html("请输入正确的手机号码！");
            $("#error").show();
        }else {
            $("#error").hide();
        }
    });
    //验证身份证
    $('#identity_number').blur(function () {
        var pattern = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
        var result = pattern.test($(this).val());
        if($(this).val() == ""){
            $("#error").html("身份证号码不能为空！");
            $("#error").show();
        }else if(!result){
            $("#error").html("请输入正确的身份证号码！");
            $("#error").show();
        }else {
            $("#error").hide();
        }
    });
    //验证电子邮箱
    $('#email').blur(function () {
        var pattern = /^\w+@\w+(\.[a-zA-Z]{2,3}){1,2}$/;
        var result = pattern.test($(this).val());
        if($(this).val() != ""  && !result){
            $("#error").html("请输入正确的邮箱地址！");
            $("#error").show();
        }else {
            $("#error").hide();
        }
    });
    //验证用户姓名
    $('#realName').blur(function () {
        var pattern = /^[\u4E00-\u9FA5]{2,6}$/;
        var result = pattern.test($(this).val());
        if($(this).val() == ""){
            $("#error").html("用户姓名不能为空！");
            $("#error").show();
        }else if(!result){
            $("#error").html("请输入正确的用户姓名！");
            $("#error").show();
        }else {
            $("#error").hide();
        }
    });
</script>
</html>