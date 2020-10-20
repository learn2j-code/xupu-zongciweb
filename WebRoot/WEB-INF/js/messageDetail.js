$(function(){
	var messageId = GetQueryString2()||'';
	var currentDate = getNowFormatDate();
	var commentListParams = {};
	commentListParams.count = 6;
	commentListParams.start = 1;
	
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

	loadFriendLink();
	loadCommentList(messageId);
	ifLogin();
	
	$(".xupu-nav-items > .li").each(function(index){
		$(this).removeClass('active');
	});
	$(".xupu-nav-items > .li").eq(4).addClass('active');
	
	$("#submitInfo").click(function(){
		if(localStorage.getItem('userName')){
			var params = {};
			params.parentId = '0';
			params.bbsId = messageId;
			params.userId = localStorage.getItem('userId');
			params.userName = localStorage.getItem('userName');
			var commentContent = $.trim($(".js-comment-content").val());
			if(commentContent == ''){
				showMsg('评论内容不能为空.');
				return false;
			}
			params.commentContent = commentContent;
			
			uploadComment(params);
		}else{
			localStorage.setItem('loginSource','http://www.100citang.cn/zongciweb/luntan/'+messageId);
			window.location.href = 'login';
		}
	});
	
	$(".js-comment-list").on('click','.button',function(){
		if(localStorage.getItem('userName')){
			var params = {};
			params.parentId = $(this).attr('data-commentId');
			params.bbsId = $(this).attr('data-BbsId');
			params.userId = localStorage.getItem('userId');
			params.userName = localStorage.getItem('userName');
			params.commentContent = $(this).parents('.clanhall-video-comment-input').find('.input').val();
			params.commentContent = $.trim(params.commentContent);
			if(params.commentContent == ''){
				showMsg('评论内容不能为空.');
				return false;
			}
			uploadComment(params);
		}else{
			localStorage.setItem('loginSource','http://www.100citang.cn/zongciweb/luntan/'+messageId);
			window.location.href = 'login';
		}
		
	})
	
	$(".js-comment-list").on('click','.js-comment-btn',function(){
		$(this).next().css('display','flex');
	})
	
	$(".js-comment-list").on('click','.js-zan-up',function(){
		var params = {};
		params.id = $(this).parent().parent().parent().attr('data-commentId');
		updateAgreeInfo(params,$(this));
	})
	
	$(".js-comment-list").on('click','.js-zan-down',function(){
		var params = {};
		params.id = $(this).parent().parent().parent().attr('data-commentId');
		updateDisagreeInfo(params,$(this));
	})
	$("#moreBtn").click(function(){
		commentListParams.start++;
		loadCommentList(messageId);
	});
	
	/*var params = {};
	params.id = messageId;
	family_loading();
	$.ajax({
		url:URL+'findBbsArticleDetail',
		data:JSON.stringify(params),
		type: "POST",
		contentType: "application/json;charset=utf-8"
	}).done(function(json){
		if(json){
			$(".js-message-title").html(json.bbsTitle);
			$(".js-message-content").html(json.bbsContent);
			$(".js-message-author").html(json.userName);
			$(".js-message-view-num").html(json.viewNum);
			//$(".js-comment-num").html(json.commentNum);
			if(json.createTime){
				var timeStr = json.createTime.substr(0,10)
				$(".js-message-date").html(timeStr);
			}
		}
	}).always(function(){
		family_loading();
	});*/
	
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
	function uploadComment(params){
		family_loading();
		$.ajax({
			url:URL+'addBbsComment',
			data:JSON.stringify(params),
			type: "POST",
			contentType: "application/json;charset=utf-8"
		}).done(function(json){
			if(json.success == '1'){
				$(".js-comment-list").children().remove()
				commentListParams.start = 1;
				loadCommentList(messageId);
			}else{
				showMsg('抱歉,发表评论失败,请重新发表');
			}
		}).always(function(){
			family_loading();
		});
	}
	
	function loadCommentList(id){   //全部留言
		var params = {};
		params.id = id;
		params.page = {};
		params.page.start = commentListParams.start;
		params.page.count = commentListParams.count;
		family_loading();
		$.ajax({
			url:URL+'findAllBbsCommentList',
			data:JSON.stringify(params),
			type: "POST",
			contentType: "application/json;charset=utf-8"
		}).done(function(json){
			if(json){
				var str = '';
				var data = json.bbsCommentList;
				if(data.length > 0){
				$(".js-comment-num").text(json.page.total);
				if(json.page.totalPage>1){
					$(".clanhall-more").show();
				}else{
					$(".clanhall-more").hide();
				}
				for(var i = 0;i<data.length;i++){
					if(data[i].bannedFlag == '0'){
					if(!data[i].userName){
						data[i].userName = '游客';
					}
					if(!data[i].agreeNum){
						data[i].agreeNum = 0;
					}
					if(!data[i].disAgreeNum){
						data[i].disAgreeNum = 0;
					}
					
					if(data[i].parentId && data[i].parentId!='0'){//二级评论  需寻找一级评论
						for(var j=0;j<data.length;j ++){
							if(data[j].bannedFlag == '0'){
								if(data[i].parentId == data[j].id){
									if(!data[j].userName){
										data[j].userName = '游客';
									}
									if(!data[j].agreeNum){
										data[j].agreeNum = 0;
									}
									if(!data[j].disAgreeNum){
										data[j].disAgreeNum = 0;
									}
									str+='<div class="bb-1 pb15 mt15" data-commentId="'+data[i].id+'" data-BbsId="'+data[i].bbsId+'"><div class="flex clanhall-video-comment-list"><div class="clearflex zan"><div class="up js-zan-up"><i class="fa fa-thumbs-o-up"></i>'+
									 '<span>'+data[i].agreeNum+'</span></div><div class="down js-zan-down"><i class="fa fa-thumbs-o-down"></i><span>'+data[i].disagreeNum+'</span></div></div><div class="content">'+
									 '<div class="name">'+data[i].userName+'</div><div class="mt15">'+
									 '<div class="clanhall-video-reply-item"><div class="user"><font>“　</font>'+data[j].userName+'</div>'+
									 '<div class="reply-content"> '+data[j].commentContent+'<font>&emsp;&ensp;”</font></div></div></div><div class="text"><div>'+data[i].commentContent+'</div></div></div>'+
								     '<div class="clearflex time">'+data[i].createTime+'</div></div><div class="mt15"><div class="clanhall-video-reply js-comment-btn"><i class="fa fa-commenting-o"></i><span>回复</span></div>'+
								     '<div class="flex mt15 clanhall-video-comment-input" style="display: none;"><div class="position-relative"><input class="input" placeholder="说点什么呢" maxlength="1000"><span class="text">1000</span></div>'+
									 '<div class="clearflex ml20"><button type="button" class="button"  data-commentId="'+data[i].id+'" data-BbsId="'+data[i].bbsId+'">发 表</button></div></div></div></div>';
								}
							}
						}
					}else{
						str+='<div class="bb-1 pb15 mt15" data-commentId="'+data[i].id+'" data-BbsId="'+data[i].bbsId+'"><div class="flex clanhall-video-comment-list"><div class="clearflex zan"><div class="up js-zan-up"><i class="fa fa-thumbs-o-up"></i>'+
						 '<span>'+data[i].agreeNum+'</span></div><div class="down js-zan-down"><i class="fa fa-thumbs-o-down"></i><span>'+data[i].disagreeNum+'</span></div></div><div class="content">'+
						 '<div class="name">'+data[i].userName+'</div><div class="text">'+data[i].commentContent+'</div></div>'+
					     '<div class="clearflex time">'+data[i].createTime+'</div></div><div class="mt15"><div class="clanhall-video-reply js-comment-btn"><i class="fa fa-commenting-o"></i><span>回复</span></div>'+
					     '<div class="flex mt15 clanhall-video-comment-input" style="display: none;"><div class="position-relative"><input class="input" placeholder="说点什么呢" maxlength="1000"><span class="text">1000</span></div>'+
						 '<div class="clearflex ml20"><button type="button" class="button"  data-commentId="'+data[i].id+'" data-BbsId="'+data[i].bbsId+'">发 表</button></div></div></div></div>';
						}
					}
				}
				$(".js-comment-list").append(str);
				}else{
					$(".js-comment-num").text('0');
					$(".clanhall-more").hide();
					//alert('已无更多评论');
				}
			}
		}).always(function(){
			family_loading();
		});
	}
	function updateAgreeInfo(params,$dom){
		$.ajax({
			url:URL+'updateAgreeNum',
			data:JSON.stringify(params),
			type: "POST",
			contentType: "application/json;charset=utf-8"
		}).done(function(json){
			if(json.success == '1'){
				$dom.addClass('active');
				var number = parseInt($dom.find('span').text())+1;
				$dom.find('span').text(number);
				$dom.removeClass('js-zan-up');
			}
		});
	}
	function updateDisagreeInfo(params,$dom){
		$.ajax({
			url:URL+'updateDisagreeNum',
			data:JSON.stringify(params),
			type: "POST",
			contentType: "application/json;charset=utf-8"
		}).done(function(json){
			if(json.success == '1'){
				$dom.addClass('active');
				var number = parseInt($dom.find('span').text())+1;
				$dom.find('span').text(number);
				$dom.removeClass('js-zan-down');
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
