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
	<title>${bbsArticle.bbsTitle }</title>
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
		<ol class="breadcrumb mt15">
		  <li><a href="/">首页</a></li>
		  <li><a href="luntans" class="active">祠堂论坛</a></li>
		  <li><a href="javascript:void(0);">帖子详情</a></li>
		</ol>
		<div class="mt15 clanhall-body">
			<h5 class="xupu-surname-title"><strong class="f24">${bbsArticle.bbsTitle }</strong></h5>
			<div class="xupu-surname-intro">
				<span><font>作者:</font>&ensp;<font>${bbsArticle.userName }</font></span>
				<span><font>时间:</font>&ensp;<font><fmt:formatDate value="${bbsArticle.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></font></span>
				<span><font>浏览数:</font>&ensp;<font>${bbsArticle.viewNum }</font></span>
				<span><i class="fa fa-commenting-o"></i>&ensp;<font class="js-comment-num"></font></span>
			</div>
			<div class="mt15">
				${bbsArticle.bbsContent }
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
			<div class="mt45 js-comment-list">
				<%-- <c:forEach items="${bbsCommentList}" var="item">
					<div class="bb-1 pb15 mt15" data-commentId="${item.id }" data-BbsId="${item.bbsId }">
						<div class="flex clanhall-video-comment-list">
							<div class="clearflex zan">
								<div class="up js-zan-up" id="zan">
									<i class="fa fa-thumbs-o-up"></i>
									<span>${item.agreeNum }</span>
								</div>
								<div class="down js-zan-down" id="buzan">
									<i class="fa fa-thumbs-o-down"></i>
									<span>${item.disagreeNum }</span>
								</div>
							</div>
							<div class="content">
								<div class="name">${item.userName }</div>
								<div class="mt15">
									<div class="clanhall-video-reply-item">
										<div class="user">${item.userName }</div>
										<div class="reply-content">${item.commentContent }</div>
									</div>
								</div>
								<div class="text">${item.commentContent }</div>
								
							</div>
							<div class="clearflex time">${item.createTime }</div>
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
									<button type="button" class="button" data-commentId="${item.id }" data-BbsId="${item.bbsId }">发 表</button>
								</div>
							</div>
						</div>
					</div>
				</c:forEach> --%>
			</div>
			<!-- <div class="text-center"><ul class="pagination" id="pagination"></ul></div> -->
			<div class="mt25 text-center clanhall-more">
				<a href="javascript:void(0);" id="moreBtn">查看更多</a>
			</div>
			<%-- <div class="text-center mt30 clearfix">
				  <c:forEach items="${bbsCommentList}" var="item" end="0">
					  	<ul class="clanhall-pagination" id="autoPagination">
					  		<li><a href="messageBorad?id=${bbsArticle.id}&start=1&count=${page.count}">首页</a></li>
						  	<c:choose><c:when test="${page.start == 1}"><li class="disabled"><a href="javascript:void(0);">上一页</a></li></c:when>
							<c:otherwise><li><li><a href="messageBorad?id=${bbsArticle.id}&start=${page.start-1}&count=${page.count}">上一页</a></li></c:otherwise>
							</c:choose>
					  		
					  		<c:choose><c:when test="${page.start == page.totalPage}"><li class="disabled"><a href="javascript:void(0);">下一页</a></li></c:when>
							<c:otherwise><li><a href="messageBorad?id=${bbsArticle.id}&start=${page.start+1}&count=${page.count}">下一页</a></li></c:otherwise>
							</c:choose>
							<li><a href="messageBorad?id=${bbsArticle.id}&start=${page.totalPage}&count=${page.count}">尾页</a></li>
					  	</ul>
				  </c:forEach>
			</div> --%>
		</div>
	</main>
	<%@ include file="public/footer.jsp"%>
	<script type="text/javascript" src="js/public/jquery-2.1.4.min.js"></script>
	<script type="text/javascript" src="js/public/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/public/swiper-4.1.6.min.js"></script>
	<script type="text/javascript" src="js/public/bootstrap-paginator.js"></script>
	<script src="js/public/calendar-converter.js"></script>
	<script type="text/javascript" src="js/public/common.js"></script>
	<script type="text/javascript" src="js/messageDetail.js" defer="true"></script>
</body>
</html>