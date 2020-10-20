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
		  <li><a href="baijiaxing" class="active">商品详情</a></li>
		</ol>
		<div class="xupu-surnames-wrap mt25">
			<div class="flex product-detail-product-wrap p20 white-bg">
				<div class="clearflex img">
					<img class="js-product-img default-img" src="images/default.png">
				</div>
				<div>
					<div class="content">
						<div class="info">
							<div class="product-detail-title js-product-title"><a href="javascript:void(0);">max破产都要买的口红</a></div>
							<!-- <div class="product-detail-abs js-product-sub-title"></div> -->
							<div class="product-detail-proposer js-product-proposer">1111</div>
							<div class="product-detail-reason js-product-reason">1111</div>
						</div>
						<div class="product-detail-button clearflex">
							<button type="button" class="price-button">￥<span class="js-product-price">188</span></button>
							<button type="button" class="find-product js-product-link" data-url="">查看宝贝 ></button>
						</div>
					</div>
				</div>
			</div>
			<div class="recommend-product-wrap">
				<div class="recommend-product-title">猜你喜欢</div>
				<div class="recommend-product-list row mhn js-recommend-product-list">
					<!-- <div class="col-lg-3 col-md-4 col-sm-6 col-xs-6 mt10">
						<div class="recommend-product">
							<p class="image"><img src="http://image.100citang.cn:9880/seo/media/null/20190507/174742_1557222462470.jpg"></p>
							<div class="title">破产姐妹,破产也要卖的口红</div>
							<div class="abs">1111</div>
							<div class="price">￥<span>60</span></div>
						</div>
					</div> -->
				</div>
			</div>
		</div>
	</main>
	<%@ include file="public/footer.jsp"%>
	<script type="text/javascript" src="js/public/jquery-2.1.4.min.js"></script>
	<script type="text/javascript" src="js/public/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/public/swiper-4.1.6.min.js"></script>
	<script src="js/public/calendar-converter.js"></script>
	<script type="text/javascript" src="js/public/common.js"></script>
	<script type="text/javascript" src="js/productDetail.js" defer="true"></script>
</body>
</html>