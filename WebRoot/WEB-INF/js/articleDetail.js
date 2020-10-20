$(function(){
	//兼容手机端配置
	if(window.screen.width < 700){  //wap
		$('head').append('<meta id="wapMeta" name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />');
		$('link').after('<link id="wapLink" rel="stylesheet" type="text/css" href="css/wapindex.css">');
	}else{  //pc
		if($("#wapMeta").length > 0){
		   $("#wapMeta").remove();
		   $("#wapLink").remove();

			
		}
	}
	
	var currentDate = getNowFormatDate();
	$(".js-current-date").text(currentDate);
	if(currentDate){
		var cc = new CalendarConverter;
		var currentDateSplit = currentDate.split('-');
		var result = cc.solar2lunar(new Date(parseInt(currentDateSplit[0]), parseInt(currentDateSplit[1]), parseInt(currentDateSplit[2])));
		$(".js-current-old-date").text(result.cYear+result.cMonth+result.lunarDay);
	}
	var swiper = new Swiper('.swiper-container', {
	      pagination: {
	        el: '.swiper-pagination',
	      },
	      navigation: {
	        nextEl: '.swiper-button-next',
	        prevEl: '.swiper-button-prev',
	      },
	      autoplay: {
	      	stopOnLastSlide: true,
	      },
	      loop: true
	    });
	$(".xupu-nav-items > .li").each(function(index){
		$(this).removeClass('active');
	});
	$(".xupu-nav-items > .li").eq(1).addClass('active');
	
	loadSurnameInformation();
	loadXuZuInformation();
	loadFriendLink();
	ifLogin();
	
	var params = {};
	var articleId = GetQueryString2()||'';
	var arr = [];
	if(articleId.indexOf('?') != -1){
		arr = articleId.split('?');
		params.id = arr[0];
	}else{
		params.id = articleId;
	}
	
	family_loading();
	$.ajax({
		url:URL+'findArticalContentByArticalId',
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
	
	$("#loginBtn").click(function(){
		localStorage.setItem('loginSource','http://www.100citang.cn');
		window.location.href= 'login';
	});
	$(".js-user-cancel").click(function(){
		if(localStorage.getItem('userName')){
			localStorage.setItem('userName','');
			localStorage.setItem('userId','');
			localStorage.setItem('userPic','');
			localStorage.setItem('uniqId','');
			localStorage.setItem('userSex','');
			localStorage.setItem('userFrom','');
			localStorage.setItem('userLastLoginTime','');
			window.location.reload();
		}
	});
	
	function ifLogin(){
		if(localStorage.getItem('userName') && localStorage.getItem('userName') != ""){
			if(!ifExpire(localStorage.getItem('userLastLoginTime'))){
				$("#userLogin").hide();
				$("#logged").show();
				$(".js-user-name").text(localStorage.getItem('userName'));
				$(".js-user-pic").css({
					'background-image':'url('+localStorage.getItem('userPic')+')',
					'background-repeat':'no-repeat',
					'background-size':'100% 100%'
				});
				
				//存放最新用户登录时间
				localStorage.setItem('userLastLoginTime',new Date());
			}else{
				$("#userLogin").show();
				$("#logged").hide();
			}
		}else{
			$("#userLogin").show();
			$("#logged").hide();
		}
	}
	function ifExpire(lastLoginTimeStr){ //用户是否过期，7天有效时间
		var lastLoginTime = new Date(lastLoginTimeStr);
		var curTime = new Date();
		
		if(curTime - lastLoginTime >= 604800000){  //七天时间
			localStorage.setItem('userName','');
			localStorage.setItem('userId','');
			localStorage.setItem('userPic','');
			localStorage.setItem('uniqId','');
			localStorage.setItem('userSex','');
			localStorage.setItem('userFrom','');
			localStorage.setItem('userLastLoginTime','');
			
			return true;  //需要注销
		}else{   //不需要注销
			return false;
		}
	}
	function loadSurnameInformation(){
		var params = {};
		var moduleId = 2;
		params.moduleId = moduleId;
		params.page = {};
		params.page.start = 1;
		params.page.count = 6;
		$.ajax({
			url:URL+'findArticalPageByModuleId',
			data:JSON.stringify(params),
			type: "POST",
			contentType: "application/json;charset=utf-8"
		}).done(function(json){
			if(json){
				json = json.entryList;
				var str = '';
				for(var i = 0;i<json.length;i++){
					str+='<li title="'+json[i].title+'"><a href="http://www.xupu168.com/news/articleDetail?id='+json[i].id+'" target="_blank">'+json[i].title+'</a></li>';
				}
				$(".js-surname-infor-list").html(str);
			}
		});
	}
	
	function loadXuZuInformation(){
		var params = {};
		var moduleId = 3;
		params.moduleId = moduleId;
		params.page = {};
		params.page.start = 1;
		params.page.count = 6;
		$.ajax({
			url:URL+'findArticalPageByModuleId',
			data:JSON.stringify(params),
			type: "POST",
			contentType: "application/json;charset=utf-8"
		}).done(function(json){
			if(json){
				var str = '';
				json = json.entryList;
				for(var i = 0;i<json.length;i++){
					str+='<li title="'+json[i].title+'"><a href="http://www.xupu168.com/news/articleDetail?id='+json[i].id+'" target="_blank">'+json[i].title+'</a></li>';
				}
				$(".js-xuzu-infor-list").html(str);
			}
		});
	}
	function loadFriendLink(){
		var params = {};
		params.websiteId = '2';
		family_loading();
		$.ajax({
			url:URL+'findSLinkurlListByWebsiteId',
			data:JSON.stringify(params),
			type: "POST",
			contentType: "application/json;charset=utf-8"
		}).done(function(json){
			if(json){
				var str = '';
				for(var i = 0;i<json.length;i++){
					if(json[i].delFlg != '1'){
						str+='<li><a href="http://'+json[i].weburl+'" target="_blank">'+json[i].stationName+'</a></li>';
					}
				}
				$(".js-friend-link").html(str);
			}
		}).always(function(){
			family_loading();
		});
	}
})