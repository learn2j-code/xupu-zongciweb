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
	<title>宗祠网—最全中国宗祠、祠堂、祭祀、姓氏、百家姓综合网站</title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/font-awesome.css">
	<link rel="stylesheet" type="text/css" href="css/swiper.min.css">
	<link rel="stylesheet" type="text/css" href="css/index.css">
</head>
<body class="gray-bg">
	<%@ include file="public/header.jsp"%>
	<%@ include file="public/nav.jsp"%>
	<main class="container">
		<ol class="breadcrumb mt15">
		  <li><a href="/index">首页</a></li>
		  <li><a href="javascript:void(0)" class="active" target="_blank">资讯列表</a></li>
		</ol>
		<%@ include file="public/banner.jsp"%>
		<div class="xupu-surnames-wrap mt25 text-center" style="background: #fff;padding-top: 15px;">
			<ul class="xupu-suranme-infor clearfix js-surname-infor">
				<li class="active" data-id="2"><a href="javascript:void(0);">姓氏资讯</a></li>
				<li data-id="3"><a href="javascript:void(0)">寻祖资讯</a></li>
			</ul>
			<div class="mt15 js-infor-wrap">
				<div class="xupu-surname-infor-list-wrap">
					<ul class="xupu-surname-infor-list js-surname-list">
						
					</ul>
				</div>
				<div class="xupu-surname-infor-list-wrap">
					<ul class="xupu-surname-infor-list js-surname-list">
						
					</ul>
				</div>
			</div>
			<ul class="pagination" id="pagination"></ul>
		</div>
	</main>
	<%@ include file="public/footer.jsp"%>
	<script type="text/javascript" src="js/public/jquery-2.1.4.min.js"></script>
	<script type="text/javascript" src="js/public/swiper-4.1.6.min.js"></script>
	<script type="text/javascript" src="js/public/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/public/bootstrap-paginator.js"></script>
	<script src="js/public/calendar-converter.js"></script>
	<script type="text/javascript" src="js/public/common.js"></script>
	<script type="text/javascript" src="js/moreInformation.js" defer="true"></script>
</body>
</html>