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
	<meta name="360-site-verification" content="e5669e1e8d2eb27b14a3f16bd6388dd2" />
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/font-awesome.css">
	<link href="css/city-picker.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" type="text/css" href="css/swiper.min.css">
	<link rel="stylesheet" type="text/css" href="css/public.css">
	<link rel="stylesheet" type="text/css" href="css/index.css">
	<script>
	
	if(window.screen.width < 700){
		window.location.href = 'http://wap.100citang.cn/';
	}
	
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
	<!-- <div class="hall-top-bg"></div>
	<header class="container">
		<div class="hall-logo pull-left"></div>
		<div class="pull-left xupu-logo-title">宗祠万里，千年传承</div>
		<div class="hall-logo-right pull-right">
			
			<div class="hall-date flex pull-right">
				<div class="clearflex"><i class="fa fa-calendar"></i></div>
				<div>
					<div class="f12 js-current-date"></div>
					<div class="js-current-old-date"></div>
				</div>
			</div>
			<div class="hall-serarch-wrap pull-right xupu-search-wrap">
				<input type="text" name="" class="hall-serarch-input">
			</div>
		</div>
	</header> -->
	<%@ include file="public/header.jsp"%>
	<%@ include file="public/nav.jsp"%>
	<main class="container">
		<%@ include file="public/banner.jsp"%>
		<div class="hall-main mt25">
			<div class="row" style="margin-right: 0px;">
			<div class="hall-infomation-wrap col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<div class="mt10mb15">
					<font class="hall-index-title">宗祠资讯</font>
					<a href="news" class="pull-right hall-more-a" target="_blank">
						更多
					</a>
				</div>
				<div>
					<c:forEach items="${zczxList}" var="zczxList">
					<div class="flex mt15 hall-information-item">
						<div class="clearflex"><a href="wenzhang/${zczxList.id}" target="_blank">
						<c:choose><c:when test="${zczxList.imageUrl == null}"><div class="default-img-wrap"><img src="images/default.png" alt="${zczxList.title}"></div></c:when>
						<c:otherwise><img src="http://image.100citang.cn:9880/seo${zczxList.imageUrl}" alt="${zczxList.title}"></c:otherwise>
						</c:choose>
						</a></div>
						<div class="pl15 content">
							<a href="wenzhang/${zczxList.id}" target="_blank">
								<h5>${zczxList.title}</h5>
								<p>${zczxList.articalAbstract}</p>
							</a>
						</div>
					</div>
					</c:forEach>
				</div>
			</div>
			<%-- <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 phn text-center">
					<div class="xupu-right-article wap-mt15">
						<h5><font  class="hall-index-title">姓氏资讯</font><a href="http://www.xupu360.com/news?moduleType=1&id=6" target="_blank" class="pull-right hall-more-a">更多</a></h5>
						<ul>
							<c:forEach items="${xszyList}" var="xszyList">
							<li  title="${xszyList.title}"><a href="http://www.xupu360.com/news/articleDetail?id=${xszyList.id}">${xszyList.title}</a></li>
							</c:forEach>
						</ul>
					</div>
					<div class="xupu-right-article mt15 wap-mtn">
						<h5><font  class="hall-index-title">寻祖资讯</font><a href="http://www.xupu360.com/news?moduleType=2&id=6" target="_blank" class="pull-right hall-more-a">更多</a></h5>
						<ul>
							<c:forEach items="${xzzxList}" var="xzzxList">
							<li  title="${xzzxList.title}"><a href="http://www.xupu360.com/news/articleDetail?id=${xzzxList.id}">${xzzxList.title}</a></li>
							</c:forEach>
						</ul>
					</div>
				</div> --%>
			</div>
			<div class="hall-advertise-banner mt25">
				<img src="images/advertise.png">
			</div>
			<div class="mt25">
				<h4 class="hall-index-title mt35mb25">祠堂赏析<a href="citang" class="pull-right hall-more-a" target="_blank">更多</a></h4>
				<div class="row mhn">
					<c:forEach items="${clanHallList}" var="item">
						<div class="col-lg-3 col-md-4 col-sm-6 col-xs-12 phn">
								<div class="hall-old-hall-top-show">
									<div class="hall1">
										<c:choose><c:when test="${item.imageAddress == ''}"><img src="images/default.png" class="clanhall-default-img" alt="${item.name }"></c:when>
										<c:otherwise><img src="http://image.100citang.cn:9880/seo${item.imageAddress }" class="images" alt="${item.name }"></c:otherwise>
										</c:choose>
										<div class="hall-more-layer">
											<font class="title">${item.name }</font><br>
											<span class="desc">${item.synopsis }</span>
											<a href="citang/${item.id }" class="morebtn" target="_blank">查看详情>></a>
										</div>
									</div>
								</div>
						 </div>
					 </c:forEach>
				 </div>
			</div>
			<div class="mt25">
				<h4 class="hall-index-title mt35mb25">祠堂地图<a href="ditu" class="pull-right hall-more-a" target="_blank">更多</a></h4>
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
			</div>
			<div class="mt25 xupu-surnames-wrap">
				<h4 class="hall-index-title mt50 mb25">姓氏文化<a href="baijiaxing" class="pull-right hall-more-a" target="_blank">更多</a></h4>
				<div class="flex mhn gray-bg ba-1" style="margin-top: 15px;">
					<div class="flex xupu-surnames phn">
						<c:forEach items="${bjxList}" var="bjxList">
							<div class="clearflex js-surname-item" data-info='${bjxList.articalAbstract}'><a href="baijiaxing/${bjxList.id}" target="_blank">${bjxList.title}</a></div>
						</c:forEach>
					</div>
					<div class="clearflex xupu-surname-info ">
						<h4 class="text-center"><strong>姓氏渊源</strong></h4>
						<div class="js-surname-info">
							${bjxList[0].articalAbstract}
						</div>
					</div>
				</div>
			</div>
			<div class="mt25">
				<h4 class="hall-index-title mt35mb25">祠堂论坛<a href="luntans" class="pull-right hall-more-a" target="_blank">更多</a></h4>
				<div class="row">
					<c:forEach items="${bbsArticleList}" var="item">
						<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
							<div class="flex clanhall-message-list-index mt15">
					    		<div class="clearflex status">
					    			<a href="luntan/${item.id }" target="_blank">${item.typeName }</a>
					    		</div>
					    		<div class="ml20">
					    			<h5 class="title"><a href="luntan/${item.id }" target="_blank">${item.bbsTitle }</a></h5>
					    			<a href="luntan/${item.id }" target="_blank" class="content">${item.bbsContent }</a></p>
					    			<div class="flex info">
					    				<div class="user"><a href="luntan/${item.id }" target="_blank">${item.userName }</a></div>
					    				<div class="clearflex browse">
					    					<a href="luntan/${item.id }" target="_blank">
					    						<font>浏览数</font>
					    						<font>${item.viewNum }</font>
					    					</a>
					    				</div>
					    			</div>
					    		</div>
					    	</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</main>
	<%@ include file="public/footer.jsp"%>
	<script type="text/javascript" src="js/public/jquery-2.1.4.min.js"></script>
	<script type="text/javascript" src="js/public/swiper-4.1.6.min.js"></script>
	<script type="text/javascript" src="http://webapi.amap.com/maps?v=1.4.6&key=67e175805065f1bd8103b4444d9cfb6b&plugin=AMap.Geocoder"></script>
	<script src="js/public/calendar-converter.js"></script>
	<script src="js/public/city-picker.data.js"></script>
	<script src="js/public/city-picker.js"></script>
	<script type="text/javascript" src="js/public/common.js"></script>
	<script type="text/javascript" src="js/index.js" defer="true"></script>
</body>
</html>