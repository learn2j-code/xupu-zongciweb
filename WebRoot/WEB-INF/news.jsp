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
	<link rel="stylesheet" type="text/css" href="css/public.css">
	<link rel="stylesheet" type="text/css" href="css/index.css">
	<style>
		.pagination a{
			color: #A37042!important;
		}
	</style>
</head>
<body class="gray-bg">
	<%@ include file="public/header.jsp"%>
	<%@ include file="public/nav.jsp"%>
	<main class="container">
	<ol class="breadcrumb mt15">
		  <li><a href="/">首页</a></li>
		  <li><a href="javascript:void(0)" class="active" target="_blank">宗祠资讯</a></li>
		</ol>
		<div class="hall-main mt25">
			<div class="row" style="margin-right: 0px;">
			<div class="hall-infomation-wrap col-lg-12 col-md-12 col-sm-6 col-xs-12 bt-1">
				<div class="js-clan-hall-infor-list">
					<!-- <div class="flex mt15 hall-information-item">
						<div class="clearflex"><a href="javascript:void(0)"><img src="images/img6.png"></a></div>
						<div class="pl15 content">
							<a href="javascript:void(0)">
								<h5>吃素的营养食谱</h5>
								<p>吃饭能不能修福?吃饭会不会造恶?也能造悲，你杀鸡杀鸭，吃鱼吃肉，是不是造恶?</p>
							</a>
						</div>
					</div> -->
				</div>
				<div class="text-center">
					<ul class="pagination" id="pagination"></ul>
				</div>
			</div>
			</div>
		</div>
	</main>
	<%@ include file="public/footer.jsp"%>
	<script type="text/javascript" src="js/public/jquery-2.1.4.min.js"></script>
	<script type="text/javascript" src="js/public/swiper-4.1.6.min.js"></script>
	<script type="text/javascript" src="js/public/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/public/bootstrap-paginator.js"></script>
	<script src="js/public/calendar-converter.js"></script>
	<script type="text/javascript" src="js/public/common.js"></script>
	<script type="text/javascript" src="js/information.js" defer="true"></script>
</body>
</html>