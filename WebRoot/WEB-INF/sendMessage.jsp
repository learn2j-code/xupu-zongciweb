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
	<meta name="keywords" content="${webInfo.swebsite.keyword}">
	<meta name="description" content="${webInfo.swebsite.websiteAbstract}">
	<meta name="baidu-site-verification" content="yZGHTwCIsG" />
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/font-awesome.css">
	<link rel="stylesheet" type="text/css" href="css/swiper.min.css">
	<link rel="stylesheet" type="text/css" href="css/public.css">
	<link rel="stylesheet" type="text/css" href="css/editor/_css/umeditor.css">
	<link rel="stylesheet" type="text/css" href="css/index.css">
	<script>
	var _hmt = _hmt || [];
	(function() {
	  var hm = document.createElement("script");
	  hm.src = "https://hm.baidu.com/hm.js?9314bb3153d97caba927fa965a336da4";
	  var s = document.getElementsByTagName("script")[0]; 
	  s.parentNode.insertBefore(hm, s);
	})();
	</script>
</head>
<body class="gray-bg">
	<%@ include file="public/header.jsp"%>
	<%@ include file="public/nav.jsp"%>
	<main class="container">
		<ol class="breadcrumb mt15">
		  <li><a href="/">首页</a></li>
		  <li><a href="luntans" class="active">祠堂论坛</a></li>
		  <li><a href="javascript:void(0);">发帖</a></li>
		</ol>
		<div class="hall-main mt25">
			<div class="clanhall-send-message-title"><span class="title">发布帖子</span><font class="desc">发布你想要发布的问题、经验、感想、心得</font></div>
			<div class="clanhall-message-title"><font class="title">帖子标题</font><font class="desc">简短的标题（1~40字）</font></div>
			<div class="flex clanhall-message-title-form">
				<div class="clearflex">
					<select class="form-control js-Bbs-select select">
					</select>
				</div>
				<div class="ml15">
					<input type="text" class="form-control js-Bbs-title input" placeholder="标题">
				</div>
			</div>
			<div class="clanhall-message-title"><font class="title">帖子内容</font></div>
			<div class="clanhall-message-content">
				<!-- <textarea rows="10" cols="" class="content form-control js-bbs-content"></textarea> -->
				<!-- <div id="summernote"></div> -->
				<script type="text/plain" id="myEditor" style="width:100%;height:240px;">
    				<p>请输入内容</p>
				</script>
			</div>
			<div class="clanhall-message-submit flex">
				<div class="clearflex">
					<input type="checkbox" class="js-Bbs-nymFlag">
					<label for="" class="label">匿名发布</label>
				</div>
				<div class="text-right">
					<button type="button" class="cancel" id="cancelBtn">取消</button>
					<button type="button" class="submit" id="submitInfo">发布</button>
				</div>
			</div>
		</div>
	</main>
	<%@ include file="public/footer.jsp"%>
	<script type="text/javascript" src="js/public/jquery-2.1.4.min.js"></script>
	<script type="text/javascript" src="js/public/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/public/swiper-4.1.6.min.js"></script>
	<script src="js/editor/umeditor.config.js"></script>
	<script src="js/editor/editor_api.js"></script>
	<script src="js/editor/zh-cn.js"></script>
	<script src="js/public/calendar-converter.js"></script>
	<script type="text/javascript" src="js/public/common.js"></script>
	<script type="text/javascript" src="js/sendMessage.js" defer="true"></script>
</body>
</html>