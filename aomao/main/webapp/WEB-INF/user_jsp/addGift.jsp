<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-cn">
<html>
	<head>
		<meta charset="utf-8" />
		<!--在移动设备端访问的时候，不会进行缩放，以100%的比例显示在移动设备中
		<meta name="viewport" content="width=device-width, initial-scale=1.0”>-->
		<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
		<title>添加礼物界面</title>
		<link rel="stylesheet" href="css/bootstrap.min.css"/>
		<link rel="stylesheet" href="css/addGift.css">
	</head>
	<body>
		<!--相对定位绝对定位再把input窗口消失实现在中间-->
		<!--礼物详情-->
		<form action="${pageContext.request.contextPath }/GiftinfoServlet?method=addgift&f=2" method="post" enctype="multipart/form-data">
	  	<div id="">
	  		<div class="container">
	  			<div class="row">
	  				<!--左侧商品图片-->
	  				<div class="col-md-6">
	  					<div class="row">
	  						<!--左边的大图-->
	  						<div class="col-md-9">
	  							<div id="leftimage" class="thumbnail" style="position: relative;">
	  								<img src="../../images/添加图片.png" id="preview" name="preview"/>
	  								<input style="position:absolute; left:40%; top:39%; opacity:0;" type="file" id="img1" name="img1" onchange="viewImage(this)" accept="image/jpg,image/png,image/PNG">
	  							</div>
	  						</div>
	  					</div>
	  				</div>
	  	
	  				<!--右侧商品信息-->
	  				<div id="leftgift" class="col-md-6">
	  					<!--外面都放上div-->
	  					<p class="giftName"><input type="text" name="giftname" id="giftname" value="" placeholder="请输入商品名称" /></p>
	  					<p class="giftDescribe"><input type="text" name="intro" id="intro" value="" placeholder="请输入商品描述" /></p>
	  					<!--下拉菜单-->
	  					<p class="giftSelect">赠送对象： 
	  						<select name="tosb" id="tosb">
	  						<option value="男朋友">男朋友</option>
	  						<option value="女朋友">女朋友</option>
	  						<option value="男性朋友">男性朋友</option>
	  						<option value="女性朋友">女性朋友</option>
	  						<option value="男性长辈">男性长辈</option>
	  						<option value="女性长辈">女性长辈</option>
	  						</select>
	  					</p>
	  					<p class="giftSelect" >送礼场合：
	  						<select name="atsp" id="atsp">
	  						<option value="生日">生日</option>
	  						<option value="表白">表白</option>
	  						<option value="约会">约会</option>
	  						<option value="订婚">订婚</option>
	  						<option value="久别重逢">久别重逢</option>
	  						<option value="结婚纪念">结婚纪念</option>
	  						</select>
	  					</p>
	  					<p class="giftSelect">送礼节日：
	  						<select name="fest" id="fest">
	  						<option value="春节">春节</option>
	  						<option value="元宵节">元宵节</option>
	  						<option value="端午节">端午节</option>
	  						<option value="中秋节">中秋节</option>
	  						<option value="国庆节">国庆节</option>
	  						<option value="情人节">情人节</option>
	  						<option value="圣诞节">圣诞节</option>
	  						</select>
	  					</p>
	  					<hr />
	  					<div id="from">
	  						<p class="text-primary" style="font-size: 18px;">获取来源</p>
	  						<input type="text" name="from" id="from" style="width:400px;height:100px;" value="" placeholder="请输入礼物来源" />
	  					</div>
	  				</div>
	  			</div >
	  			<input class="btn btn-lg btn-danger"  type="submit" id="buy" value="上传您的创意礼物"/>
	  		</div>
	  	</div>
	  	</form>
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
