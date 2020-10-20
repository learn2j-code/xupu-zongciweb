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
	<title>${article.title}</title>
	<meta charset="utf-8">
	<meta name="keywords" content="${article.keyword}">
	<meta name="description" content="${article.articalAbstract}">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/font-awesome.css">
	<link rel="stylesheet" type="text/css" href="css/swiper.min.css">
	<link rel="stylesheet" type="text/css" href="css/public.css">
	<link rel="stylesheet" type="text/css" href="css/index.css">
</head>
<body class="gray-bg">
	<div id="pcBody">
		<%@ include file="public/header.jsp"%>
		<%@ include file="public/nav.jsp"%>
		<main class="container">
			<%@ include file="public/banner.jsp"%>
			<ol class="breadcrumb mt15">
			  <li><a href="/" target="_blank">首页</a></li>
			  <li><a href="baijiaxing" class="active" target="_blank">姓氏文化</a></li>
			  <li>姓氏详情</li>
			</ol>
			<div class="xupu-surnames-wrap mt25 p20 white-bg">
				<div class="row mhn">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 phn">
						<h3 class="xupu-surname-title">${article.title}</h3>
						<div class="xupu-surname-intro">
							<span>时间:<font class="js-article-time"></font></span>
							<span>来源:<font>宗祠网</font></span>
							<span>作者:<font>${article.nickname}</font></span>
						</div>
						<div class="xupu-surname-content mt15"><!--  js-article-content -->
							${article.content}
						</div>
						<!-- <ul class="xupu-contact mt45 xupu-article-icon">
							<li><i class="fa fa-weixin"></i></li>
							<li><i class="fa fa-qq"></i></li>
							<li><i class="fa fa-weibo"></i></li>
						</ul> -->
						<!-- JiaThis Button BEGIN -->
						<!-- <ul class="xupu-contact mt45 xupu-article-icon">
							<li><a class="jiathis_button_weixin"><i class="fa fa-weixin"></i></a></li>
							<li><a class="jiathis_button_qzone"><i class="fa fa-qq"></i></a></li>
							<li><a class="jiathis_button_tsina"><i class="fa fa-weibo"></i></a></li>
						</ul> -->
						<div class="bdsharebuttonbox bdsharebuttonbox-mt25">
						<!-- <a href="#" class="bds_more" data-cmd="more"></a> -->
						<a href="#" class="bds_qzone" data-cmd="qzone"></a>
						<a href="#" class="bds_tsina" data-cmd="tsina"></a>
						<!-- <a href="#" class="bds_tqq" data-cmd="tqq"></a> -->
						<!-- <a href="#" class="bds_renren" data-cmd="renren"></a> -->
						<a href="#" class="bds_weixin" data-cmd="weixin"></a>
						</div>
	<script>window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"2","bdPic":"","bdStyle":"0","bdSize":"16"},"share":{},"image":{"viewList":["qzone","tsina","tqq","renren","weixin"],"viewText":"分享到：","viewSize":"16"},"selectShare":{"bdContainerClass":null,"bdSelectMiniList":["qzone","tsina","tqq","renren","weixin"]}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];</script>
						
						<span class="xupu-article-share-text">快去分享吧!</span>
						<!-- <div class="xupu-surname-intro pull-right">
							<span>来源:<font></font>宗祠网</span>
							<span>作者:<font></font>宗祠网</span>
						</div> -->
					</div>
					<!-- <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 phn text-center">
						<div class="xupu-right-article">
							<h5><font  class="hall-index-title">姓氏资讯</font><a href="http://www.xupu168.com/news?moduleType=1&id=2" target="_blank" class="pull-right hall-more-a">更多</a></h5>
							<ul class="js-surname-infor-list">
								
							</ul>
						</div>
						<div class="xupu-right-article mt15">
							<h5><font  class="hall-index-title">寻祖资讯</font><a href="http://www.xupu168.com/news?moduleType=2&id=2" target="_blank" class="pull-right hall-more-a">更多</a></h5>
							<ul class="js-xuzu-infor-list">
								
							</ul>
						</div>
					</div> -->
				</div>
			</div>
			<div class="xupu-surnames-wrap mt25 p20 white-bg">
				<h3 class="xupu-surnames-title">热门资讯</h3>
				<ul class="xupu-surnames-hot-list clearfix">
					<c:if test = "${not empty xszxList}">
					<c:forEach items="${xszxList }" var="item">
						<li><a href="wenzhang/${item.id}" target="_blank">${item.title}</a></li>
					</c:forEach>
					</c:if>
					<c:if test = "${empty xszxList}">
						<div><p>暂无热门资讯,请联系小编添加(电话:15200844395)</p></div>
					</c:if>
				</ul>
			</div>
			<div class="xupu-surnames-wrap mt25 p20 white-bg">
				<h3 class="xupu-surnames-title">热门宗祠</h3>
				<ul class="xupu-surnames-hot-list clearfix">
					<c:if test = "${not empty sclanHallList}">
					<c:forEach items="${sclanHallList }" var="item">
						<li><a href="citang/${item.id }" target="_blank">${item.name}</a></li>
					</c:forEach>
					</c:if>
					<c:if test = "${empty sclanHallList}">
						<div><p>暂无热门宗祠，请联系小编添加(电话:0731-85358183     手机号：15200844395)</p></div>
					</c:if>
				</ul>
			</div>
		</main>
		<%@ include file="public/footer.jsp"%>
		</div>
		<div id="wapBody">
			<div class="clanhall-header">
				<div class="title-head" style="padding-top: 0px;">
					<span><img src="images/title.png"></span>
					<i class="fa fa-search"></i>
				</div>
			</div>
			<nav class="clanhall-nav">
				<ul class="clanhall-nav-wrap">
					<li><a href="http://wap.100citang.cn/">首页</a></li>
					<li><a href="http://wap.100citang.cn/html/clanHallInfo.html">宗祠资讯</a></li>
					<li><a href="http://wap.100citang.cn/html/clanHallMap.html">祠堂地图</a></li>
					<li><a href="http://wap.100citang.cn/html/clanHallShow.html">祠堂赏析</a></li>
				</ul>
			</nav>
			<main>
				<h5 class="section-title ph15 js-surname-title"></h5>
				<div class="ph15"><span class="clanhall-video-date js-article-time">2018-08-05</span></div>
				<div class="clanhall-content ph15 mt15 js-article-content">
					
				</div>
				<div class="clanhall-detail-contacts mt15">
					<div class="bdsharebuttonbox bdsharebuttonbox-mt25">
						<!-- <a href="#" class="bds_more" data-cmd="more"></a> -->
						<a href="#" class="bds_qzone" data-cmd="qzone"></a>
						<a href="#" class="bds_tsina" data-cmd="tsina"></a>
						<!-- <a href="#" class="bds_tqq" data-cmd="tqq"></a> -->
						<!-- <a href="#" class="bds_renren" data-cmd="renren"></a> -->
						<a href="#" class="bds_weixin" data-cmd="weixin"></a>
					</div>
						<script>window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"2","bdPic":"","bdStyle":"0","bdSize":"16"},"share":{},"image":{"viewList":["qzone","tsina","tqq","renren","weixin"],"viewText":"分享到：","viewSize":"16"},"selectShare":{"bdContainerClass":null,"bdSelectMiniList":["qzone","tsina","tqq","renren","weixin"]}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];</script>
						
						<div class="xupu-article-share-text">快去分享吧!</div>
				</div>
			 </main>
		</div>
</body>
<script type="text/javascript" src="js/public/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="js/public/swiper-4.1.6.min.js"></script>
<script src="js/public/calendar-converter.js"></script>
<script type="text/javascript" src="js/public/common.js"></script>
<script type="text/javascript" src="js/baijiaxingDetail.js" defer="true"></script>
</html>