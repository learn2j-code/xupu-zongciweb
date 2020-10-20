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
	<link href="css/city-picker.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" type="text/css" href="css/index.css">
</head>
<body class="gray-bg">
	<%@ include file="public/header.jsp"%>
	<%@ include file="public/nav.jsp"%>
	<main class="container">
		<ol class="breadcrumb mt15">
		  <li><a href="/">首页</a></li>
		  <li><a href="javascript:void(0)" class="active" target="_blank">宗祠地图</a></li>
		</ol>
		<div class="hall-main mt25">
			<div class="row mhn">
				<div class="flex hall-find-clan-hall">
					<div class="clearflex title"><i class="fa fa-search color1 f18"></i><font class="hall-find-title">查询宗祠</font></div>
					<div class="clearflex input">
						<div class="flex">
							<!-- <input type="text" name="" class="form-control" placeholder="请输入省或市或区" id="searchVal"> -->
							<input id="city-picker3" class="form-control js-livePlace" readonly type="text" value="" data-toggle="city-picker" placeholder="宗祠地址">
							<input type="text" class="form-control ml10" placeholder="宗祠名字" id="searchName">
						</div>
					</div>
					<div class="clearflex button">
						<input type="button" name="" class="search-btn" value="查询" id="searchBtn">
					</div>
				</div>
			</div>
			<div class="row mhn mt15">
				<div class="col-lg-9 col-md-8 col-sm-12 col-xs-12 phn">
					<div class="hall-map-wrap" id="gasMap">
						<img src="images/map.png">
					</div>
				</div>
				<div class="col-lg-3 col-md-4 col-sm-12 col-xs-12 phn">
					<div class="hall-map-result-list hall-map-wrap">
						<div class="hall-result-list-title">查询结果</div>
						<div class="ph15 hall-result-item-wrap js-hall-result-wrap">
							<p style="margin-top: 15px;color: #dbdbdb;text-align: center;font-size: 14px;"><i class="fa fa-exclamation-circle" style="margin-right: 3px;font-size: 14px;"></i>有点小尴尬,暂无查询结果</p>
						</div>
					</div>
				</div>
			</div>
			<div class="mt25">
				<font class="hall-index-title">宗祠推荐</font>
			</div>
			<div class="row mt15 js-recomment-list-wrap" style="margin-right: 0px;">
				
			</div>
			<div class="mt45 text-center">
				<a href="citang" class="hall-map-more-btn" target="_blank">查看更多</a>
			</div>
			</div>
		</div>
	</main>
	<%@ include file="public/footer.jsp"%>
	<script type="text/javascript" src="js/public/jquery-2.1.4.min.js"></script>
	<script type="text/javascript" src="js/public/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/public/swiper-4.1.6.min.js"></script>
	<script src="js/public/calendar-converter.js"></script>
	<script type="text/javascript" src="http://webapi.amap.com/maps?v=1.4.6&key=67e175805065f1bd8103b4444d9cfb6b&plugin=AMap.Geocoder"></script>
	<script type="text/javascript" src="js/public/common.js"></script>
	<script src="js/public/city-picker.data.js"></script>
	<script src="js/public/city-picker.js"></script>
	<script type="text/javascript" src="js/clanHallMap.js" defer="true"></script>
</body>
</html>