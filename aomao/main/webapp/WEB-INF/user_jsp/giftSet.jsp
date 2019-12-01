<%@page import="gift.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-cn">
	<head>
	<meta charset="utf-8" />
		<!--在移动设备端访问的时候，不会进行缩放，以100%的比例显示在移动设备中
		<meta name="viewport" content="width=device-width, initial-scale=1.0”>-->
		<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
		<title>礼应如此</title>
 
		<link rel="stylesheet" href="css/bootstrap.min.css"/>
		<link rel="stylesheet" href="css/style.css">
	    <link href="css/bootstrapValidator.min.css" rel="stylesheet" />
	</head>
<!--礼物详情-->

  		<div class="container">
  		<form action="${pageContext.request.contextPath }/UploadServlet?method=giftPhoto&giftid=${gift.giftid}" method="post" enctype="multipart/form-data">
  			<div class="row">
  				<!--左侧商品图片-->
  				<div class="col-md-6">
  					<div class="row">
  						<!--左边的大图-->
  						<div class="col-md-9">
  							<div id="leftimage" class="thumbnail"><img id="preview" name="preview" src="${gift.img1 }"/></div>
  							<input style="position:absolute; left:40%; top:39%; opacity:0;" type="file" id="img1" name="img1" onchange="viewImage(this)" accept="image/jpg,image/png,image/PNG">
  						</div>
  					</div>
  					<div id="divlike" class="like">喜欢 &#10084;</div>
  				</div>
  	
  				<!--右侧商品信息-->
  				<div id="leftgift" class="col-md-6">
  					<!--外面都放上div-->
  					<p class="giftName">礼物名称：<input id="giftname" name="giftname" value="${gift.giftname }" /> </p>
	  					<p class="giftDescribe">礼物描述：<input id="intro" name="intro" value="${gift.intro }" /></p>
	  					<!--下拉菜单-->
  					<p class="giftSelect">赠送对象：<input id="tosb" name="tosb" value="${gift.tosb }" /> </p>
  					<p class="giftSelect">送礼场合：<input id="atsp" name="atsp" value="${gift.atsp }" /></p>
  					<p class="giftSelect">送礼节日：<input id="fest" name="fest" value="${gift.fest }" /></p>
  					<hr />
  					<div id="source">
  						<p class="text-primary" style="font-size: 18px;">获取来源：<input id="from" name="from" value="${gift.from }" /></p>
  					</div>
  					 <button type = "submit" id="buy" class="btn btn-lg btn-danger">
  						修改
  					</button>
  				</div>
  				
  			</div>
  		</form>
  			
  			<hr />	
<!--   			<p class="youlike">猜您喜欢</p> -->
  		</div>
  	
</body>
<script type="text/javascript">
	function viewImage(file){
		
		var preview = document.getElementById('preview');
	    if(file.files && file.files[0]){
	        //火狐下
	        preview.style.display = "block";
	        preview.style.width = "150px";
	        preview.style.height = "150px";
	        preview.src = window.URL.createObjectURL(file.files[0]);
	    }else{
	        //ie下，使用滤镜
	        file.select();
	        var imgSrc = document.selection.createRange().text;
	        var localImagId = document.getElementById("localImag"); 
	        //必须设置初始大小 
	        localImagId.style.width = "150px"; 
	        localImagId.style.height = "150px"; 
	        try{ 
	        localImagId.style.filter="progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
	        locem("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc; 
	        }catch(e){ 
	        alert("您上传的图片格式不正确，请重新选择!"); 
	        return false; 
	        } 
	        preview.style.display = 'none'; 
	        document.selection.empty(); 
	        } 
	        return true; 
	}
</script>
</html>