<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<%
			String path = request.getContextPath();
			String basePath = request.getScheme()+"://"+request.getServerName()
					+":"+request.getServerPort()+path+"/";
		%>
		<base href="<%=basePath %>" >
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
		<title>管理员界面</title>
		<link rel="stylesheet" href="css/bootstrap.min.css"/>
		<link rel="stylesheet" href="css/adminStyle.css">
	</head>
	<body>
		<!--导航栏-->
		<nav id="top" class="navbar navbar-default navbar-fixed-top">
			<div class="container-fluid">
				<div class="navbar-header">
					<!--网站Logo-->
					<a href="${pageContext.request.contextPath }/default.jsp">
						<h1 style="float: right">澳猫网</h1>
					</a>
					<!--移动设备上展开导航元素按钮-->
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse">
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
				</div>
				<div style="float: right;margin-right: 20px">
					<form action="${pageContext.request.contextPath}/searchAdmin" style="float:right;margin-right:150px" >
						<input type="text"  placeholder="请输入管理员账号……"><input type="submit" name="admuser" value="查询" style="margin-top: 20px">
						<a  class="btn btn-primary navbar-right" href="${pageContext.request.contextPath}/listAdmin" style="margin-top: 20px;margin-left: 120px">刷新</a>
					</form>
				</div>
			</div>
		</nav>
		
		<!--左侧边导航栏-->
		<div id="adminMenu">
			<ul class="nav nav-pills nav-stacked">
				<li role="presentation"><a href="#" target="contentWrapper">统计信息</a></li>
				<span class="adminMenu_span">用户管理：</span>
				<li role="presentation"><a href="${pageContext.request.contextPath}/toAdmin" target="contentWrapper">添加管理员</a></li>
				<li role="presentation"><a href="${pageContext.request.contextPath}/toUpdate" target="contentWrapper" >修改管理员</a></li>
			  	<span class="adminMenu_span">商品管理：</span>
			  	<li role="presentation"><a href="addGift.jsp" target="contentWrapper">添加商品</a></li>
			  	<li role="presentation"><a href="${pageContext.request.contextPath}/GiftinfoServlet?method=SearchAllGifts&searchAllGiftsflag=2" target="contentWrapper">查询商品</a></li>
			</ul>
		</div>
		
		
		<!--右边内容嵌套栏-->
		<div id="adminIframe" class="content-wrapper">
			<table class="table" id="bold">
				<thead>
				<tr>
					<th><input type="checkbox" ></th>
					<th style="font-weight:bold">ID</th>
					<th style="font-weight:bold">管理员账号</th>
					<th style="font-weight:bold" >管理员昵称</th>
					<th style="font-weight:bold">操作</th>
				</tr>
				</thead>
				<tbody>

				<c:forEach items="${list}" var="admin">
					<tr>
						<td><input type="checkbox" name="${admin.admid}"></td>
						<td>${admin.admid }</td>
						<td>${admin.admuser}</td>
						<td>${admin.admname}</td>
						<td>
							<a href="" data-toggle="modal" data-target="#myModalTwo">修改</a>
							<a href="${pageContext.request.contextPath}/deleteAdmin/${admin.admid}" onclick="return confirm('确定删除该记录吗?')">删除</a>
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
<div>
		<!-- 模态框（Modal） -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
							&times;
						</button>
						<h4 class="modal-title" id="myModalLabel">
							添加管理员
						</h4>
					</div>
					<form role="form" action="${pageContext.request.contextPath}/addAdmin" method="post" class="registration-form">
					<div class="modal-body">

							<div class="form-group">
								账号：
								<input type="text" name="admuser" placeholder="账号..." class="form-email form-control" id="admuser">
							</div>
							<div class="form-group">
								密码：
								<input type="password" name="admpwd" placeholder="密码..." class="form-email form-control" id="admpwd">
							</div>
							<div class="form-group">
								确认密码：
								<input type="password" name="admpwd1" placeholder="确认密码..." class="form-email form-control" id="password1">
							</div>
							<div class="form-group">
								管理员名字：
								<input type="text" name="admname" placeholder="名字..." class="form-email form-control" id="tel">
							</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭
						</button>
						<button type="submit" class="btn btn-primary">
							提交
						</button>
					</div>
					</form>
				</div><!-- /.modal-content -->
			</div><!-- /.modal -->
		</div>
</div>
		<div>
			<!-- 修改模态框（Modal） -->
			<div class="modal fade" id="myModalTwo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
								&times;
							</button>
							<h4 class="modal-title" >
								修改管理员
							</h4>
						</div>
						<form role="form" action="${pageContext.request.contextPath}/updateAdmin" method="post" class="registration-form">
							<div class="modal-body">

								<div class="form-group">
									账号：
									<input type="text" name="admuser" placeholder="账号..." class="form-email form-control" id="admuserTwo" value="${adminNow.admuser}">
								</div>
								<div class="form-group">
									密码：
									<input type="password" name="admpwd" placeholder="密码..." class="form-email form-control" id="admpwdTwo" value="${adminNow.admpwd}">
								</div>
								<div class="form-group">
									确认密码：
									<input type="password" name="admpwd1" placeholder="确认密码..." class="form-email form-control" id="password1Two" value="${adminNow.admpwd}">
								</div>
								<div class="form-group">
									管理员名字：
									<input type="text" name="admname" placeholder="名字..." class="form-email form-control" id="admnameTwo" value="${adminNow.admname}">
								</div>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default" data-dismiss="modal">关闭
								</button>
								<button type="submit" class="btn btn-primary">
									提交
								</button>
							</div>
						</form>
					</div><!-- /.modal-content -->
				</div><!-- /.modal -->
			</div>
		</div>



		<script src="js/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
	</body>
</html>