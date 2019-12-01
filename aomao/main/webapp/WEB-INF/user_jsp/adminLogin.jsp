<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>澳猫团</title>
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
            欢迎登录
        </div>
    </div>
</header>
<!-- 中间内容 -->
<div class="mainArea">
    <div class="mainAreaW textWarp w1190">
        <div class="mainContent boxS" style="height: 500px">
            <div class="MCup clearfix">
                <form action="" method="post">
                    <div class="MCright W310">
                        <h3 class="clearfix">
                            <span>澳猫团管理员端</span>
                        </h3>
                        <p class="userName">
                            <em></em>
                            <input name="admuser" id="loginname" class="W310" placeholder="请输入您的账户" type="text" value="${cookie.remember.value }">
                        </p>
                        <p class="passWord">
                            <em></em>
                            <input name="admpwd" id="password" class="W310" placeholder="请输入密码" type="password">
                        </p>
                        <button class="loGin W310" type="button" onclick="login()">登录</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<!-- 底部 -->
<footer>
    <div class="txt textWarp w1190">
        <p>
            澳大利亚Health more - 河南康多多贸易有限公司 - 河南澳蜜电子商务有限公司 版权所有<br>
            Copyright © 20015-2018  澳猫aumalls.com 版权所有, 豫ICP备15030837号-1
        </p>
        <div class="ALLN"></div>
    </div>
</footer>
<script src="js/jquery-1.7.2.min.js"></script>
<script src="js/jquery.lazyload.min.js"></script>
<script src="layui/layui.all.js"></script>
<script src="js/login.js"></script>
<script type="text/javascript">
    /* 登录提交 */
    function login() {
        var name =$("#loginname").val();//#是id选择器
        var pwd =$("#password").val();
        if(name==""){
            alert("用户名不能为空！");
            return false;
        }
        else if(pwd==" "){
            alert("密码不能为空！");
            return false;
        }
        else
        {
        $.ajax({
            type:"POST",
            url:"adminLogin",
            data: $("form").serialize(),
            dataType:'json',
            success:function(data){
                if(data.code==100){
                    layer.msg(data.msg, {time:2000, icon:1});
                    window.location.href = "toAdmin";
                }
            },
            error:function () {
                layer.alert("哇啊，系统坏了!");
            }
        });
    }}
</script>
</body>
</html>