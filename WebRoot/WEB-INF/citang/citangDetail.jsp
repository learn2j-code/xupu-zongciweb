<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
	<base href="<%=basePath%>">
	<link rel="shortcut icon" href="favicon.ico">
	<title>${clanHall.name}</title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/font-awesome.css">
	<link rel="stylesheet" type="text/css" href="css/swiper.min.css">
	<link rel="stylesheet" type="text/css" href="css/public.css">
	<link rel="stylesheet" type="text/css" href="css/index.css">
	<style type="text/css">
	.swiper-container {
      width: 100%;
      height: 130px!important;
      margin-left: auto;
      margin-right: auto;
    }
    .swiper-slide {
    	position: relative;
      background-size: cover;
      background-position: center;
    }
    .swiper-slide img{
    	width: 100%;
    	height: 100%;
    }
    .gallery-top {
      height: 6.24rem!important;
      width: 100%;
    }
    .gallery-thumbs {
      height: 20%;
      box-sizing: border-box;
      padding: 10px 0;
    }
    .gallery-thumbs .swiper-slide {
      height: 100%;
      position: relative;
    }
    .gallery-thumbs .swiper-slide img{
    	width: 100%;
    	height: 100%;
    }
    .gallery-thumbs .swiper-slide:before{
    	content:"";
    	position: absolute;
    	width: 100%;
    	height: 100%;
    	left: 0;
    	top: 0;
    	background:rgba(0,0,0,.7);
    }
    .gallery-thumbs .swiper-slide-active:before {
      background:rgba(0,0,0,0);
    }

	</style>
</head>
<body class="gray-bg">
	<%@ include file="../public/header.jsp"%>
	<%@ include file="../public/nav.jsp"%>
	<main class="container">
		<ol class="breadcrumb mt15">
		  <li><a href="/" target="_blank">首页</a></li>
		  <li><a href="citangji" class="active">祠堂大全</a></li>
		  <li>祠堂详情</li>
		</ol>
		<div class="hall-main mt25">
			<div>
				<font class="hall-index-title">${clanHall.name}</font>
			</div>
			<div class="mt25" style="position:relative;">
				<div class="swiper-button-prev-big"><i class="fa fa-angle-left"></i></div>
				<div class="swiper-button-next-big"><i class="fa fa-angle-right"></i></div>
				<div class="swiper-container gallery-top">
				    <div class="swiper-wrapper js-swiper-wrapper">
					    	<c:forEach items="${clanHall.imageList}" var="item">
					            <div class="swiper-slide"><img id="img'+(i+1)+'" class="js-add-blob" src="http://image.100citang.cn:9880/seo${item.imageUrl}" alt="${clanHall.name}"></div>'
					        </c:forEach>
				    </div>
					<div class="hall-detail-img-text left js-hall-detail-wrap">
    				<p class="content">${clanHall.synopsis}</p>
    				<div class="contract"><div>
					<i class="fa fa-user"></i>
					<font class="contacts">${clanHall.contacts}</font>
					<i class="fa fa-tty ml30"></i>
					<font class="tel">${clanHall.tel}</font></div>
					<div class="mt10">
					<i class="fa fa-map-marker"></i>
					<font class="address">${clanHall.address}</font></div></div></div>
				    <div class="swiper-pagination"></div>
				    <!-- Add Arrows -->
				</div>
				  <div class="swiper-container gallery-thumbs">
				    <div class="swiper-wrapper js-thumbs-wrapper">
				    	<c:forEach items="${clanHall.imageList}" var="item">
				            <!-- <div class="swiper-slide" style="background-image:url(images/b1.png)"></div> -->
				            <div class="swiper-slide"><img id="img'+(i+1)+'" class="js-add-blob" src="http://image.100citang.cn:9880/seo${item.imageUrl}" alt="${clanHall.name}"></div>'
				        </c:forEach>
				    </div>
				    <div class="swiper-button-next"><i class="fa fa-angle-right"></i></div>
					<div class="swiper-button-prev"><i class="fa fa-angle-left"></i></div>
				  </div>
			</div>
			<div class="mt25 hall-detail-content-wrap">
				<h5 class="title"><font style="background: url('images/detailText.png') no-repeat center center;width: 1.5rem;height: auto;display: inline-block;">详细介绍</font></h5>
				<div class="xupu-surname-intro text-right">
					<span>来源:<font>宗祠网</font></span>
					<span>作者:<font>${clanHall.nickname}</font></span>
				</div>
				<div class="hall-detail-content">
					${clanHall.details}
				</div>
				<!-- <div class="text-center clanhall-show-all-content">
					<a href="javascript:void(0)" id="showALlContent">阅读全文</a>
				</div> -->
			</div>
			<div class="xupu-surnames-wrap mt25 p10 white-bg">
				<div class="name">姓氏: ${xsInfo.title}</div>
				<div class="content">${xsInfo.articalAbstract}</div>
			</div>
			<div class="xupu-surnames-wrap mt25 p10 white-bg">
				<h3 class="xupu-surnames-title">热门资讯</h3>
				<ul class="xupu-surnames-hot-list clearfix">
					<c:if test = "${not empty xszyList}">
					<c:forEach items="${xszyList }" var="item">
						<li><a href="wenzhang/${item.id}" target="_blank">${item.title}</a></li>
					</c:forEach>
					</c:if>
					<c:if test = "${empty xszyList}">
						<div><p>暂无热门资讯，请联系小编添加(电话:0731-85358183     手机号：15200844395)</p></div>
					</c:if>
				</ul>
			</div>
		</div>
	</main>
	<%@ include file="../public/footer.jsp"%>
	<script type="text/javascript" src="js/public/jquery-2.1.4.min.js"></script>
	<script type="text/javascript" src="js/public/swiper-4.1.6.min.js"></script>
	<script src="js/public/calendar-converter.js"></script>
	<script type="text/javascript" src="js/public/common.js"></script>
	<script type="text/javascript" src="js/clanHallDetail.js"></script>
</body>
</html>