<%--
  Created by IntelliJ IDEA.
  User: 邓贺文
  Date: 2019/6/25
  Time: 13:37
  To change this template use File | Settings | File Templates.
--%>
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
        <div class="mainContent boxS" style="height: 500px">
            <div class="MCup clearfix">
                <form action="" method="post">
                    <div class="MCright W310">
                        <h3 class="clearfix">
                            <span>登录澳猫团</span>
                            <a target="_self" href="toUserRegister" >免费注册</a>
                        </h3>
                        <p class="userName">
                            <em></em>
                            <input name="uemail" class="W310" placeholder="请输入您的邮箱" type="text" value="${cookie.remember.value }">
                        </p>
                        <p class="passWord">
                            <em></em>
                            <input name="upwd" class="W310" placeholder="请输入密码" type="password">
                        </p>
                        <p class="clearfix yzm">
                            <input name="code" type="text" placeholder="验证码">
                            <img src="codeController" id="checkCode" onclick="changeImg(this)" />

                        </p>
                        <p class="clearfix Jzmm">
                            <input type="checkbox" value="remember" name="isremember" class="checkbox checked"/>
                            <span>记住密码</span>
                            <a target="_blank" href="#">忘记密码？</a>
                        </p>
                        <button class="loGin W310" type="button" onclick="login()">登录</button>
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
            <div class="MCdown">
                <p>使用其他账户登录</p>
                <ul>
                    <li class="clearfix">
                        <em></em>
                        <a href="#">QQ登录</a>
                    </li>
                    <li class="clearfix">
                        <em></em>
                        <a href="#">微博登录</a>
                    </li>
                    <li class="clearfix">
                        <em></em>
                        <a href="#">腾讯微博</a>
                    </li>
                    <li class="clearfix">
                        <em></em>
                        <a href="#">微信登录</a>
                    </li>
                    <li class="clearfix BN">
                        <em></em>
                        <a href="#">百度登录</a>
                    </li>
                </ul>
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
<script src="layui/layui.all.js"></script>
<script src="js/login.js"></script>
<script type="text/javascript">


    /* 验证码更新 */
    function changeImg(obj){
        obj.src="codeController?i="+Math.random();
    }

    /* 登录提交 */
    function login() {
        $.ajax({
            type:"POST",
            url:"userLogin",
            data: $("form").serialize(),
            dataType:'json',
            success:function(data){
                if(data.code==100){
                    layer.msg(data.msg, {time:2000, icon:1});
                    window.location.href = "toList";
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
</script>
</body>
</html>