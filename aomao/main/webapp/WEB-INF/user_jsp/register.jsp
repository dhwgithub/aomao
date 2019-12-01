<%--
  Created by IntelliJ IDEA.
  User: 邓贺文
  Date: 2019/6/26
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册页-澳猫团</title>
    <link rel="shortcut icon" href="favicon.ico">
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/base1.css">
    <link rel="stylesheet" href="css/login.css">
    <!-- 视图窗口，移动端特属的标签。 -->
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,minimum-scale=1,user-scalable=no" />
    <link media="screen and (min-width: 992px) and (max-width:1200px)" rel="stylesheet" href="css/base1-small.css">
    <link media="screen and (min-width: 992px) and (max-width:1200px)" rel="stylesheet" href="css/login-small.css">
    <link media="screen and (min-width: 768px) and (max-width:991px)" rel="stylesheet" href="css/base1-pad.css">
    <link media="screen and (min-width: 768px) and (max-width:991px)" rel="stylesheet" href="css/login-pad.css">
</head>
<body>
<!-- 顶部 -->
<header>
    <!-- 搜索和logo -->
    <div class="logoAndSearch textWarp w1190 clearfix">
        <div class="logo">
            <a href="toList">澳猫网</a>
        </div>
        <div class="LAStxt">
            欢迎注册
        </div>
        <div class="search">
            <div class="txt">
                <input type="text" placeholder="Swisse/澳洲">
                <em></em>
            </div>
            <a href="#" class="btn">
                搜索
            </a>
            <ul>
                <li><a target="_blank" href="#">胶原蛋白</a></li>
                <li><a target="_blank" href="#">叶绿素</a></li>
                <li><a target="_blank" href="#">睡眠片</a></li>
                <li><a target="_blank" href="#">儿童维生素</a></li>
                <li><a target="_blank" href="#">鱼肝油</a></li>
                <li><a target="_blank" href="#">保健品</a></li>
                <li><a target="_blank" href="#">美容</a></li>
                <li class="BN"><a target="_blank" href="#">运动保健</a></li>
            </ul>
        </div>
    </div>
</header>
<!-- 中间内容 -->
<div class="mainArea">
    <div class="mainAreaW textWarp w1190">
        <div class="mainContent boxS">
            <div class="MCup clearfix">
                <form  method="post">
                    <div class="MCright W310" >
                        <h3 class="clearfix">
                            <span>免费注册</span>
                        </h3>
                        <p class="userName">
                            <em></em>
                            <input id="uname" name="uname" class="W310" placeholder="请输入您的昵称" type="text">
                        </p>
                        <p class="passWord">
                            <em></em>
                            <input id="upwd" name="upwd" class="W310" placeholder="请输入密码" type="password">
                        </p>
                        <p class="passWord">
                            <em></em>
                            <input id="reUpwd" name="reUpwd" class="W310" placeholder="请再次输入密码" type="password">
                        </p>
                        <p class="">
                            <em></em>
                            <input id="uemail" name="uemail" class="W310" placeholder="请输入您的邮箱" type="text">
                        </p>
                        <p class="">
                            <em></em>
                            <input id="uid" name="uid" class="W310" placeholder="请输入您的身份证号" type="text">
                        </p>

                        <p class="clearfix yzm">
                            <input id="code" name="code" type="text" placeholder="验证码">
                            <img src="codeController" id="checkCode" onclick="changeImg(this)" />
                        </p>
<%--                        <a href="">--%>
                            <span onclick="userRegister()" style="background-color: #1D89E4; font-family: STLiti; font-size: 30px; color: white;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;提交&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
<%--                        </a>--%>
                    </div>
                </form>
                <div class="MCleft W115">
                    <img src="images/AppEr.png" alt="二维码">
                    <p>扫码下载客户端</p>
                    <div class="pL">
                        <span>手机可直接访问</span>
                        <strong>www.aomao.com</strong>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- 底部 -->
<footer>
    <div class="txt textWarp w1190">
        <ul>
            <li><a href="#">关于澳猫海淘</a></li>
            <li><a href="#">商家入驻</a></li>
            <li><a href="#">网站合作</a></li>
            <li><a href="#">友情链接</a></li>
            <li><a href="#">澳猫公益</a></li>
            <li><a href="#">法律声明</a></li>
            <li><a href="#">诚聘英才</a></li>
            <li><a href="#">联系我们</a></li>
            <li><a href="#">网站地图</a></li>
        </ul>
        <p>
            澳大利亚Health more - 河南康多多贸易有限公司 - 河南澳蜜电子商务有限公司 版权所有<br>
            Copyright © 20015-2018  澳猫aumalls.com 版权所有, 豫ICP备15030837号-1
        </p>
        <div class="ALLN"></div>
    </div>
</footer>
<script src="js/jquery-1.7.2.min.js"></script>
<script src="js/jquery.lazyload.min.js"></script>
<script src="js/login.js"></script>
<script src="layui/layui.all.js"></script>
<script>

    /* 验证码更新 */
    function changeImg(obj){
        obj.src="codeController?i="+Math.random();
    }

    /* 用户注册 */
    function userRegister() {
        var uname = $("#uname").val();
        var upwd = $("#upwd").val();
        var reUpwd = $("#reUpwd").val();
        var uemail = $("#uemail").val();
        var uid = $("#uid").val();
        var code = $("#code").val();
        var regEmail=/^([0-9A-Za-z\-_\.]+)@([0-9a-z]+\.[a-z]{2,3}(\.[a-z]{2})?)$/g;

        if(uname.length > 18 || uname.length < 2)
            layer.alert("昵称太长或太短了!");
        else if(upwd.length > 18 || upwd.length < 6)
            layer.alert("密码太长或太短了!");
        else if(upwd != reUpwd)
            layer.alert("两次密码输入不一样!");
        else if(regEmail.test(uemail) == false)
            layer.alert("邮箱格式错误!");
        else if(uid.length != 18)
            layer.alert("身份证号码输入有误!");
        else if(code.length != 4)
            layer.alert("验证码输入有误!");
        else{
            $.ajax({
                type:"POST",
                url:"userRegister",
                data: $("form").serialize(),
                dataType:'json',
                success:function(data){
                    if(data.code==100){
                        layer.msg(data.msg, {time:2000, icon:1});
                        window.location.href = "toLogin";
                    }else{
                        $("#checkCode").attr("src", "codeController?i="+Math.random());
                        layer.msg(data.msg, {time:3000, icon:2});
                    }
                },
                error:function () {
                    layer.alert("哇啊，系统坏了!");
                }
            });
        }

    }
</script>
</body>
</html>