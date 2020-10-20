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
	<title>${mvideo.videoTitle}</title>
	<meta name="keywords" content="${webInfo.swebsite.keyword}">
	<meta name="description" content="${webInfo.swebsite.websiteAbstract}">
	<meta name="baidu-site-verification" content="yZGHTwCIsG" />
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/font-awesome.css">
	<link rel="stylesheet" type="text/css" href="css/swiper.min.css">
	<link rel="stylesheet" type="text/css" href="css/public.css">
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
		  <li><a href="shipins" class="active">宗祠视频</a></li>
		  <li><a href="javascript:void(0);">视频详情</a></li>
		</ol>
		<div class="hall-main mt15 clanhall-body js-clanhall-body">
			<h5 class="xupu-surname-title"><strong class="f24">${mvideo.videoTitle}</strong></h5>
			<div class="xupu-surname-intro">
				<span><font>时间:</font><font><fmt:formatDate value="${mvideo.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></font></span>
				<span><font>浏览数:</font><font>${mvideo.viewNum}</font></span>
				<span><i class="fa fa-commenting-o"></i>&ensp;<font class="js-comment-num"></font></span>
			</div>
			<div class="mt15 text-center">
				<div id="youku" class="youku clanhall-video-detail-youku">
					<embed id="my_video_1" src="${mvideo.videoAddress}" allowFullScreen="true" quality="high" width="100%" height="100%" align="middle" allowScriptAccess="always" type="application/x-shockwave-flash"></embed>
				</div>
			</div>
			<div class="mt15">
				${mvideo.videoDetail}
			</div>
		</div>
		<div class="mt15 clanhall-body">
			<div class="flex clanhall-video-comment-input">
				<div class="position-relative">
					<input class="input js-comment-content" placeholder="说点什么呢" maxlength="1000">
					<span class="text">1000</span>
				</div>
				<div class="clearflex ml20">
					<button type="button" class="button" id="submitInfo">发表</button>
				</div>
			</div>
			<div class="mt15">
				<div class="mt45 js-comment-list">
				<!-- <div class="bb-1 pb15 mt15">
					<div class="flex clanhall-video-comment-list">
						<div class="clearflex zan">
							<div class="up" id="zan">
								<i class="fa fa-thumbs-o-up"></i>
								<span>436</span>
							</div>
							<div class="down" id="buzan">
								<i class="fa fa-thumbs-o-down"></i>
								<span>436</span>
							</div>
						</div>
						<div class="content">
							<div class="name">测试</div>
							<div class="mt15">
								<div class="clanhall-video-reply-item">
									<div class="user">测试</div>
									<div class="reply-content">无论黑哨白哨，都不可能允许这么执法的，错也要错到底，退一万步也要在十几秒内纠正判罚法的，错也要错到底，退一万步也要在十几秒内纠</div>
								</div>
							</div>
							<div class="text">无论黑哨白哨，都不可能允许这么执法的，错也要错到底，退一万步也要在十几秒内纠正判罚</div>
							
						</div>
						<div class="clearflex time">2018-05-30 21:42:45</div>
					</div>
					<div class="mt15">
						<div class="clanhall-video-reply js-comment-btn">
							<i class="fa fa-commenting-o"></i>
							<span>回复</span>
						</div>
						<div class="flex mt15 clanhall-video-comment-input" style="display: none;">
							<div class="position-relative">
								<input class="input" placeholder="说点什么呢" maxlength="1000">
								<span class="text">1000</span>
							</div>
							<div class="clearflex ml20">
								<button type="button" class="button">发 表</button>
							</div>
						</div>
					</div>
				</div> -->
			</div>
			<!-- <div class="text-center"><ul class="pagination" id="pagination"></ul></div> -->
			<div class="mt25 text-center clanhall-more">
				<a href="javascript:void(0);" id="moreBtn">查看更多</a>
			</div>
		</div>
	</main>
	<%@ include file="public/footer.jsp"%>
	<script type="text/javascript" src="js/public/jquery-2.1.4.min.js"></script>
	<script type="text/javascript" src="js/public/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/public/swiper-4.1.6.min.js"></script>
	<script src="js/public/calendar-converter.js"></script>
	<script type="text/javascript" src="js/public/common.js"></script>
	<script type="text/javascript" src="js/videoDetail.js" defer="true"></script>
</body>
</html>