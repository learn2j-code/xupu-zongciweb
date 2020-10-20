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
	<style>
		.pagination a{
			color: #A37042!important;
		}
	</style>
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
		<%@ include file="public/banner.jsp"%>
		<div class="hall-main mt25">
			<div class="row" style="margin-right: 0px;">
			<div class="hall-infomation-wrap col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<ol class="breadcrumb mt15">
				  <li><a href="/">首页</a></li>
				  <li><a href="javascript:void(0);" class="active">祠堂论坛</a></li>
				</ol>
				<div class="flex">
				  <ul class="nav nav-tabs clanhall-messageBorad-tab" role="tablist">
				    <li role="presentation" class="active"><a href="#whole" aria-controls="whole" role="tab" data-toggle="tab">全部</a></li>
				    <li role="presentation"><a href="#upToDate" aria-controls="upToDate" role="tab" data-toggle="tab">最新</a></li>
				    <li role="presentation"><a href="#essence" aria-controls="essence" role="tab" data-toggle="tab">精华</a></li>
				    <li role="presentation"><a href="#discuss" aria-controls="discuss" role="tab" data-toggle="tab">讨论</a></li>
				    <li role="presentation"><a href="#help" aria-controls="help" role="tab" data-toggle="tab">求助</a></li>
				    <li role="presentation"><a href="#original" aria-controls="original" role="tab" data-toggle="tab">原创</a></li>
				    <li role="presentation"><a href="#share" aria-controls="share" role="tab" data-toggle="tab">分享</a></li>
				  </ul>
				  <div class="clearflex"><span class="clanhall-publish-message" id="sendMessage">发 帖</span></div>
				 </div>
				  <!-- Tab panes -->
				  <div class="tab-content mt25">
				    <div role="tabpanel" class="tab-pane active" id="whole">
				    	<div>
				    		<c:choose>
				    		<c:when test="${fn:length(bbsArticleList)>0}">
				    			<c:forEach items="${bbsArticleList}" var="item">
							    	<div class="flex clanhall-message-list mt15">
							    		<div class="clearflex status">
							    			<a href="luntan/${item.id}" target="_blank">${item.typeName }</a>
							    		</div>
							    		<div class="ml20">
							    			<h5 class="title"><a href="luntan/${item.id}" target="_blank">${item.bbsTitle }</a></h5>
							    			<a href="luntan/${item.id}" target="_blank" class="content"><p>${item.bbsContent }</p></a>
							    			<div class="flex info">
							    				<div class="user"><a href="luntan/${item.id}" target="_blank">${item.userName }</a></div>
							    				<div class="clearflex add-comment">
							    					<a href="luntan/${item.id}" target="_blank">
							    						<i class="fa fa-commenting-o"></i>
							    						<font>添加评论</font>
							    					</a>
							    				</div>
							    				<div class="clearflex browse">
							    					<a href="luntan/${item.id}" target="_blank">
							    						<font>浏览数</font>
							    						<font>${item.viewNum }</font>
							    					</a>
							    				</div>
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
							    	</div>
							    	</a>
						    	</c:forEach>
				    		</c:when>
							<c:otherwise>
								<div class="text-center mt15">很抱歉，暂无相关信息</div>
							</c:otherwise>
							</c:choose>
				    		
				    	</div>
				    </div>
				    <div role="tabpanel" class="tab-pane" id="upToDate">
				    	<div class="js-uptodate-message-list"></div>
				    </div>
				    <div role="tabpanel" class="tab-pane" id="essence"><div class="js-essence-message-list"></div></div>
				    <div role="tabpanel" class="tab-pane" id="discuss"><div class="js-discuss-message-list"></div></div>
				    <div role="tabpanel" class="tab-pane" id="help"><div class="js-help-message-list"></div></div>
				    <div role="tabpanel" class="tab-pane" id="original"><div class="js-original-message-list"></div></div>
				    <div role="tabpanel" class="tab-pane" id="share"><div class="js-share-message-list"></div></div>
				  </div>
				  <div class="text-center mt30">
				  <ul class="pagination" id="pagination" style="display: none;"></ul>
				  <c:forEach items="${bbsArticleList}" var="item" end="0">
					  	<ul class="clanhall-pagination" id="autoPagination">
					  		<li><a href="luntans/1/${page.count}">首页</a></li>
						  	<c:choose><c:when test="${page.start == 1}"><li class="disabled"><a href="javascript:void(0);">上一页</a></li></c:when>
							<c:otherwise><li><li><a href="luntans/${page.start-1}/${page.count}">上一页</a></li></c:otherwise>
							</c:choose>
					  		
					  		<c:choose><c:when test="${page.start == page.totalPage}"><li class="disabled"><a href="javascript:void(0);">下一页</a></li></c:when>
							<c:otherwise><li><a href="luntans/${page.start+1}/${page.count}">下一页</a></li></c:otherwise>
							</c:choose>
							<li><a href="luntans/${page.totalPage}/${page.count}">尾页</a></li>
					  	</ul>
				  </c:forEach>
				  </div>
			</div>
			<!-- <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 phn text-center">
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
	</main>
	<%@ include file="public/footer.jsp"%>
	<script type="text/javascript" src="js/public/jquery-2.1.4.min.js"></script>
	<script type="text/javascript" src="js/public/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/public/bootstrap-paginator.js"></script>
	<script type="text/javascript" src="js/public/swiper-4.1.6.min.js"></script>
	<script src="js/public/calendar-converter.js"></script>
	<script type="text/javascript" src="js/public/common.js"></script>
	<script type="text/javascript" src="js/messageBorad.js" defer="true"></script>
</body>
</html>