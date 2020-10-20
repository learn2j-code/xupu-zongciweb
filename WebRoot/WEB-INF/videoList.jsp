<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
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
		  <li><a href="javascript:void(0);" class="active">宗祠视频</a></li>
		</ol>
		<div class="hall-main mt25">
			<!-- <div class="col-lg-3 col-md-4 col-sm-6 col-xs-12 mt15">
				<div class="clanhall-video-item">
					<div id="youku" class="youku"> 
						<video class="video-js vjs-default-skin" controls    preload="auto" width="100%" height="100%" poster=""    data-setup="{}">
							<source src="images/1.mp4" type='video/mp4' />
						</video> 
					</div>
					<div class="p10">
						<h5 class="name">汪氏宗祠</h5>
						<p class="content">就那丽黄宗祠始建於清朝嘉庆末年。 宗祠倚那雾灵山之龙气，面朝戥...</p>
					</div>
				</div>
			</div> -->
			<c:choose><c:when test="${fn:length(mvideoList)>0}">
				<c:forEach items="${mvideoList}" var="item">
					<div class="col-lg-3 col-md-4 col-sm-6 col-xs-12 mt15 pln"><div class="clanhall-video-item">
					<a href="shipin/${item.id}&start=1&count=8" target="_blank" class="clanhall-default-a">
					<div id="youku" class="youku"><embed src="${item.videoAddress}" allowFullScreen="true" quality="high" width="100%" height="100%" align="middle" allowScriptAccess="always" type="application/x-shockwave-flash"></embed></div>
					<div class="p10 body js-video-item" data-id="${item.id}"><h5 class="name">${item.videoTitle}</h5><p class="content">${item.videoTitle}</p></div></div></a></div>;
				</c:forEach>
			</c:when>
			<c:otherwise>
				<div class="text-center mt15">很抱歉，暂无相关信息</div>
			</c:otherwise>
			</c:choose>
		</div>
		<div id="output"></div>
		<div class="text-center mt30">
		  <c:forEach items="${mvideoList}" var="item" end="0">
			  	<ul class="clanhall-pagination" id="autoPagination">
			  		<li><a href="shipins/1/${page.count}">首页</a></li>
				  	<c:choose><c:when test="${page.start == 1}"><li class="disabled"><a href="javascript:void(0);">上一页</a></li></c:when>
					<c:otherwise><li><li><a href="shipins/${page.start-1}/${page.count}">上一页</a></li></c:otherwise>
					</c:choose>
			  		
			  		<c:choose><c:when test="${page.start == page.totalPage}"><li class="disabled"><a href="javascript:void(0);">下一页</a></li></c:when>
					<c:otherwise><li><a href="shipins/${page.start+1}/${page.count}">下一页</a></li></c:otherwise>
					</c:choose>
					<li><a href="shipins?/${page.totalPage}/${page.count}">尾页</a></li>
			  	</ul>
		  </c:forEach>
		  </div>
	</main>
	<%@ include file="public/footer.jsp"%>
	<script type="text/javascript" src="js/public/jquery-2.1.4.min.js"></script>
	<script type="text/javascript" src="js/public/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/public/bootstrap-paginator.js"></script>
	<script type="text/javascript" src="js/public/swiper-4.1.6.min.js"></script>
	<script src="js/public/calendar-converter.js"></script>
	<script type="text/javascript" src="js/public/common.js"></script>
	<script type="text/javascript" src="js/videoList.js" defer="true"></script>
</body>
</html>