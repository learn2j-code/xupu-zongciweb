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
		  <li><a href="baijiaxing" class="active">姓氏文化</a></li>
		</ol>
		<div class="xupu-surnames-wrap mt25 p20 white-bg">
			<div class="row mhn">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 phn">
					<h3 class="xupu-surnames-title">姓氏文化</h3>
					<div class="">
						<!-- <div class="bb-1 pv15">
							<span class="xupu-surnames-letter pull-left">A</span>
							<div class="flex xupu-surnames-wrap">
								<div class="clearflex">安</div>
								<div class="clearflex">敖</div>
								<div class="clearflex">艾</div>
							</div>
						</div> -->
						<div class="bb-1">
							<c:forEach items="${entryMap }" var="item">
								<span class="xupu-surnames-letter pull-left">${item.key}</span>
								<div class="flex xupu-surnames-wrap mv5">
								<c:forEach items="${item.value }" var="itemValue">
									<div class="clearflex"><a href="baijiaxing/${ itemValue.id}" target="_blank">${itemValue.title}</a></div>
								</a>
								</c:forEach>
							</div>
							</c:forEach>
						</div>
					</div>
				</div>
				<!-- <!-- <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 phn text-center">
					<div class="xupu-right-article">
						<h5><font  class="hall-index-title">姓氏资讯</font><a href="http://www.xupu168.com/news?moduleType=1&id=6" class="pull-right hall-more-a">更多</a></h5>
						<ul class="js-surname-infor-list">
							
						</ul>
					</div>
					<div class="xupu-right-article mt15">
						<h5><font  class="hall-index-title">寻祖资讯</font><a href="http://www.xupu168.com/news?moduleType=2&id=6" class="pull-right hall-more-a">更多</a></h5>
						<ul class="js-xuzu-infor-list">
						
						</ul>
					</div>
				</div> -->
			</div>
		</div>
	</main>
	<%@ include file="public/footer.jsp"%>
	<script type="text/javascript" src="js/public/jquery-2.1.4.min.js"></script>
	<script type="text/javascript" src="js/public/swiper-4.1.6.min.js"></script>
	<script src="js/public/calendar-converter.js"></script>
	<script type="text/javascript" src="js/public/common.js"></script>
	<script type="text/javascript" src="js/surnames.js"  defer="true"></script>
</body>
</html>