<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<%@ include file="public/header.jsp"%>
	<%@ include file="public/nav.jsp"%>
	<main class="container">
		<ol class="breadcrumb mt15">
		  <li><a href="/" target="_blank">首页</a></li>
		  <li><a href="allClanHall" class="active">祠堂大全</a></li>
		  <li>祠堂列表</li>
		</ol>
		<div class="hall-main mt25">
			<div class="clanhall-letter-wrap clearfix">
				<div class="title">按省份拼音首字母查找：</div>
				<ul class="letter-wrap js-letter-list">
					<!-- <li><a href="javascript:void(0)" class="js-anchor-a" data-id="#anchorA">A</a></li> -->
				</ul>
			</div>
			<div class="clanhall-area-list-wrap mt15">
				<div class="mt15 clanhall-area-list"> <!--  js-clanhall-area-list -->
					<c:forEach items="${entryMap }" var="item">
						<div class="clanhall-area-item mt15" id="'anchor'+${ item.key}">
							<div class="title"><font>${ item.key}</font></div>
							<div class="row clanhall-list mhn">
								<c:forEach items="${item.value }" var="itemValue">
								<a href="citang/${ itemValue.id}" target="_blank">
									<div class="col-lg-2 col-md-3 col-sm-4 col-xs-12 col">
										<div class="clanhall-item js-clanhall-item">
											<div class="pic js-clanhall-pic">
												<c:choose><c:when test="${itemValue.coverImageThumb == ''}"><img src="images/default.png" class="clanhall-default-img" alt="${itemValue.name }"></c:when>
												<c:otherwise><img src="http://image.100citang.cn:9880/seo/${itemValue.coverImageThumb }" class="images" alt="${itemValue.name }"></c:otherwise>
												</c:choose>
												<div class="pic-enlarge js-pic-enlarge" style="display:none"><img src="" data-url="http://image.100citang.cn:9880/seo/${ itemValue.coverImage}"></div>
											</div>
											<div class="body">
												<h5 class="name">${ itemValue.name}</h5>
												<p class="address">${ itemValue.address}</p>
												<p class="desc" title="${ itemValue.synopsis}">${itemValue.synopsis}</p>
											</div>
										</div>
									</div>
								</a>
								</c:forEach>
							</div>
						</div>
					</c:forEach>
					<!-- <div class="clanhall-area-item mt15" id="anchorA">
						<div class="title"><font>A</font></div>
						<div class="row clanhall-list mhn">
							<div class="col-lg-2 col-md-3 col-sm-4 col-xs-12 col">
								<div class="clanhall-item js-clanhall-item">
									<div class="pic js-clanhall-pic">
										<img src="http://jpay.100jp.cn/seo/media/567/20180814/223929_1534257569038.jpg">
										<div class="pic-enlarge js-pic-enlarge" style="display:none"><img src="" data-url="http://jpay.100jp.cn/seo/media/567/20180814/223929_1534257569038.jpg"></div>
									</div>
									<div class="body">
										<h5 class="name">祠堂名称</h5>
										<p class="address"></p>
										<p class="desc" title="祠堂简介祠堂简介">祠堂简介祠堂简介祠堂简介祠堂简介祠堂简介祠堂简介祠堂简介祠堂简介祠堂简介祠堂简介</p>
									</div>
								</div>
							</div>
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
	<script type="text/javascript" src="js/allClanHall.js" defer="true"></script>
</body>
</html>