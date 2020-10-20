<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html style="width: 100%;height: 100%;">
<head>
	<title></title>
	<meta charset="utf-8">
	<script type="text/javascript" src="http://open.51094.com/user/myscript/15b6ebb3ed408f.html"></script>
	<style>
		html,body{
			margin: 0;
			padding: 0;
			overflow: hidden;
		}
		.clanhall-login-wrap{
			display: flex;
			width: 530px;
			height: 546px;
			background: #F6F6F6;
			box-shadow:1px 1px 6px #eee;
			position: relative;
			top: 50%;
			left: 50%;
			margin-left: -300px;
			margin-top: -300px;
			align-items: center;
			justify-content: center;
			text-align: center;
			flex-direction: column;
		}
		.clanhall-login{
			display: block;
			flex: 1;
			margin-top: -15px;
		}
		.clanhall-login > a{
			position: relative;
			display: block;
			width: 280px;
			height: 90px;
			margin: 15px auto!important;
		}
		.clanhall-login > a > img{
			position: relative;
			width: 100%;
			height: 100%;
			min-width: 100%;
			min-height: 100%;
		}
		.clanhall-login > a:before{
			content: '';
		    position: absolute;
		    top: 50%;
		    right: 10px;
		    width: 23px;
		    height: 20px;
		    background: url(http://image.100tp.cn/zongci/long-arrow-right.png) no-repeat;
		    z-index: 9;
		    margin-top: -10px;
		    opacity: 0;
		}
		.clanhall-login > a.active:before{
			content: '';
		    position: absolute;
		    top: 50%;
		    right: 10px;
		    width: 23px;
		    height: 20px;
		    background: url(http://image.100tp.cn/zongci/long-arrow-right.png) no-repeat;
		    z-index: 9;
		    margin-top: -10px;
		    opacity: 1;
		    transition: all .5s;
		}
		.clanhall-login-title{
			color: #515151;
			font-size: 18px;
			text-align: center;
			display: block;
			margin-top: 50px;
		}
	</style>
</head>
<body style="width: 100%;height: 100%;">
		<input type="hidden" value="${user.id}" id="userId">
		<!-- <input type="hidden" value="yuke" id="userName"> -->
		<input type="hidden" value="${user.nickname}" id="userName">
		<input type="hidden" value="${user.img}" id="userPic">
		<input type="hidden" value="${user.uniqId}" id="uniqId">
		<input type="hidden" value="${user.sex}" id="userSex">
		<input type="hidden" value="${user.loginFrom}" id="userFrom">
		<main class="" style="width: 100%;height: 100%;display: none;" id="loginDom">
			<div class="clanhall-login-wrap">
				<h5 class="clanhall-login-title">快速登录~</h5>
				<span class="clanhall-login" id="hzy_fast_login"></span>
			</div>
		</main>
		<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.js" integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60=" crossorigin="anonymous""></script>
	    <script type="text/javascript">
	    $(function(){
	    	if($("#userName").val()){
	    		/* sessionStorage.setItem('userName',$("#userName").val());
	    		sessionStorage.setItem('userId',$("#userId").val());
	    		sessionStorage.setItem('userPic',$("#userPic").val());
	    		sessionStorage.setItem('uniqId',$("#uniqId").val());
	    		sessionStorage.setItem('userSex',$("#userSex").val());
	    		sessionStorage.setItem('userFrom',$("#userFrom").val()); */
	    		
	    		localStorage.setItem('userName',$("#userName").val());
	    		localStorage.setItem('userId',$("#userId").val());
	    		localStorage.setItem('userPic',$("#userPic").val());
	    		localStorage.setItem('uniqId',$("#uniqId").val());
	    		localStorage.setItem('userSex',$("#userSex").val());
	    		localStorage.setItem('userFrom',$("#userFrom").val());
	    		
	    		localStorage.setItem('userLastLoginTime',new Date());

	    		window.location.href = localStorage.getItem('loginSource');

	    	}else{
	    		$("#loginDom").css('display','block');
	    		$(".open_login_1 img").attr('src',"http://image.100tp.cn/zongci/qqlogin.png");
	    		$(".open_login_2 img").attr('src',"http://image.100tp.cn/zongci/weibologin.png");
	    		$(".open_login_10 img").attr('src',"http://image.100tp.cn/zongci/weixinlogin.png");
	    		
	    		$("#hzy_fast_login").on('mouseover','a',function(){
	    			$(this).addClass('active').siblings().removeClass('active');
	    		})
	    	}
	    	function setCookie(name,value)
	    	{
		    	var Days = 7;
		    	var exp = new Date();
		    	exp.setTime(exp.getTime() + Days*24*60*60*1000);
		    	document.cookie = name + "="+ escape (value) + ";domain=http://www.100citang.cn;path=/;expires=" + exp.toGMTString();
	    	}
	    	function logined(){
	    		$.ajax({
	    			url:URL+'logined',
	    			data:JSON.stringify(params),
	    			type: "POST",
	    			contentType: "application/json;charset=utf-8"
	    		}).done(function(json){
	    			if(json.id){
	    				$(".js-surname-title").html(json.title);
	    				$(".js-article-content").html(json.content);
	    				var timeStr = json.articleTime.substr(0,10)
	    				$(".js-article-time").html(timeStr);
	    			}
	    		}).always(function(){
	    			family_loading();
	    		});
	    	}
	    })
	    </script>
</body>
</html>