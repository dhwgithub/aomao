<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<style>
		table{
		 margin-top:30px;
		 margin-left:30px;
		 width:80%;
		 border-collapse:collapse;
		 background-color:#D8E5F2;
		}
		th{
			background-color:#3b579d;
			color:#FFFFFF;
			height:30px;
			line-height:30px;
			border:1px solid white;
		}
		td{
			border:1px solid white;
			height:30px;
			line-height:30px;
			text-align:center;
		}
	</style>
	<body>
		<form id="searchUsersform" action="${pageContext.request.contextPath}/GiftinfoServlet?method=searchGift&f=2" method="post">
<!-- 			<input type="hidden" name="method" value="searchUsers"> -->
			根据礼物名查询：<input type="text" id="ky" name="ky" value=""/>
			<input type="submit" value="查询"/>
		</form>
		<table>	
			<tr>
				<th width="15%">礼物id</th>
				<th width="15%">礼物名</th>
				<th width="15%">赠送对象</th>
				<th width="15%">赠送场合</th>
				<th width="15%">赠送节日</th>
				<th width="10%">点赞数</th>
				<th width="15%">操作</th>
			</tr>
			<c:forEach items="${requestScope.gifts}" var="gifts" varStatus="s">
			<tr>
		    <td>${gifts.giftid }</td>
		    <td>${gifts.giftname }</td>
			<td>${gifts.tosb }</td>	 
			<td>${gifts.atsp }</td>
			<td>${gifts.fest }</td>
			<td>${gifts.agreenum}</td>
			<td>
			<a href="${pageContext.request.contextPath }/GiftinfoServlet?method=searchGiftId&giftid=${gifts.giftid}&f=2">修改</a>
			<a href="${pageContext.request.contextPath }/GiftinfoServlet?method=deleteGift&giftid=${gifts.giftid }">删除</a>
				            <a href="${pageContext.request.contextPath }/GiftinfoServlet?method=downloadGift&giftpath=${gifts.img1 }">下载</a>
			</td>
			</tr>
			</c:forEach>
		</table>
<!-- 		<div class="page"> -->
<!-- 			第&nbsp;&nbsp;页&nbsp;共&nbsp;&nbsp;页&nbsp;共&nbsp;&nbsp;个用户<br> -->
<!-- 			<a href="">首页</a> -->
<!-- 			<a href="">上一页</a> -->
<!-- 			<a href="">下一页</a> -->
<!-- 			<a href="">尾页</a> -->
<!-- 			转到第：<input type="text" name="currentPage" id="pageNo"/>页<input type="button" onclick="" value="go"/> -->
<!-- 		</div> -->
	</body>
</html>
