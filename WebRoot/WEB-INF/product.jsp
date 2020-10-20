<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
	<base href="<%=basePath%>">
	<link rel="shortcut icon" href="favicon.ico">
	<title>宗祠网—最全中国宗祠、祠堂、祭祀、姓氏、百家姓综合网站</title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/font-awesome.css">
	<link rel="stylesheet" type="text/css" href="css/swiper.min.css">
	<link rel="stylesheet" type="text/css" href="css/public.css">
	<link rel="stylesheet" type="text/css" href="css/index.css">
</head>
<body class="gray-bg">
	<%@ include file="public/header.jsp"%>
	<%@ include file="public/nav.jsp"%>
	<main class="container">
		<%@ include file="public/banner.jsp"%>
		<ol class="breadcrumb mt15">
		  <li><a href="/">首页</a></li>
		  <li><a href="baijiaxing" class="active">宗祠商城</a></li>
		</ol>
		<div class="xupu-surnames-wrap mt25">
			<!-- <div class="product-search-wrap clearfix">
				<div class="flex product-search">
					<div class="input-wrap">
						<div class="input"><input type="text"></div>
					</div>
					<div class="button clearflex">
						<button class="" type="button">搜索</button>
					</div>
				</div>
			</div> -->
			<div class="flex product-main-wrap">
				<div>
					<div class="flex product-main-header">
						<div class="">
							<span class="header-logo">建筑耗材</span>
						</div>
						
						<!-- <div class="clearflex">
							<span class="header-change">换一换</span>
						</div> -->
					</div>
					<div class="row mhn js-jiancai-list">
						
					</div>
				</div>
				<div>
					<div class="flex product-main-header">
						<div class="">
							<span class="header-logo">雕栏画栋</span>
						</div>
						<!-- <div class="clearflex">
							<span class="header-change">换一换</span>
						</div> -->
					</div>
					<div class="row mhn js-diaolan-list">
						
					</div>
				</div>
			</div>
			<div class="hall-advertise-banner mt25">
				<img src="images/advertise.png">
			</div>
			<div class="flex product-main-wrap">
				<div>
					<div class="flex product-main-header">
						<div class="">
							<span class="header-logo">装饰园艺</span>
						</div>
						
						<!-- <div class="clearflex">
							<span class="header-change">换一换</span>
						</div> -->
					</div>
					<div class="row mhn js-zhuangshi-list">
						
					</div>
				</div>
				<div>
					<div class="flex product-main-header">
						<div class="">
							<span class="header-logo">风水文玩</span>
						</div>
						<!-- <div class="clearflex">
							<span class="header-change">换一换</span>
						</div> -->
					</div>
					<div class="row mhn js-fengshui-list">
						
					</div>
				</div>
			</div>
			<div class="hall-advertise-banner mt25">
				<img src="images/advertise.png">
			</div>
			<div class="flex product-main-wrap">
				<div>
					<div class="flex product-main-header">
						<div class="">
							<span class="header-logo">祭祀用品</span>
						</div>
						<!-- 
						<div class="clearflex">
							<span class="header-change">换一换</span>
						</div> -->
					</div>
					<div class="row mhn js-jishi-list">
						
					</div>
				</div>
				<div>
					<div class="flex product-main-header">
						<div class="">
							<span class="header-logo">会务用品</span>
						</div>
						<!-- <div class="clearflex">
							<span class="header-change">换一换</span>
						</div> -->
					</div>
					<div class="row mhn js-huiwu-list">
						
					</div>
				</div>
			</div>
			<div class="hot-product-wrap">
				<div class="hot-product-title">热门商品</div>
				<div class="hot-product-list row mhn js-hot-product-list">
					
				</div>
			</div>
		</div>
	</main>
	<%@ include file="public/footer.jsp"%>
	<script type="text/javascript" src="js/public/jquery-2.1.4.min.js"></script>
	<script type="text/javascript" src="js/public/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/public/swiper-4.1.6.min.js"></script>
	<script type="text/javascript" src="js/public/bootstrap-paginator.js"></script>
	<script src="js/public/calendar-converter.js"></script>
	<script type="text/javascript" src="js/public/common.js"></script>
	<script type="text/javascript" src="js/product.js" defer="true"></script>
</body>
</html>