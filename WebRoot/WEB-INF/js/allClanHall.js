$(function(){
	
	var currentDate = getNowFormatDate();
	$(".js-current-date").text(currentDate);
	if(currentDate){
		var cc = new CalendarConverter;
		var currentDateSplit = currentDate.split('-');
		var result = cc.solar2lunar(new Date(parseInt(currentDateSplit[0]), parseInt(currentDateSplit[1]), parseInt(currentDateSplit[2])));
		$(".js-current-old-date").text(result.cYear+result.cMonth+result.lunarDay);
	}
	
	//loadAllClanHall();
	ifLogin();
	loadFriendLink();
	
	$(".xupu-nav-items > .li").each(function(index){
		$(this).removeClass('active');
	});
	$(".xupu-nav-items > .li").eq(3).addClass('active');
	
	$("#loginBtn").click(function(){
		localStorage.setItem('loginSource','http://www.100citang.cn');
		window.location.href= 'login';
	});
	$('img').error(function(){
        $(this).attr('src', "images/default.png");
        $(this).addClass('clanhall-default-img');
        $(this).css('margin-left','-41px');
     });
	$(".js-clanhall-enlarge").each(function(){
		$(this).removeClass('clanhall-default-img');
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
	
	$(".js-letter-list").on('click','.js-anchor-a',function(){
		var _self = $(this).parent();
		_self.addClass('active').siblings().removeClass('active');
	});
	
	$("body").on('click','.js-anchor-a',function(){
		var id = $(this).attr('data-id');
		var $letterWrap = $(".clanhall-letter-wrap").clone(true);
		var letterWrapWidth = $('.clanhall-area-list-wrap').width();
		var letterWrapHeight = $(".clanhall-letter-wrap").outerHeight(true);
		var areaListTop = $(id).offset().top - letterWrapHeight;
		var letterWrapLeft = $(id).offset().left;
		$letterWrap.css({
			"position": "fixed",
	    	"background": "#fff",
	    	"z-index": "10000",
	    	"top": "0",
	    	"left":letterWrapLeft + 'px',
	    	"width": letterWrapWidth + 'px'
		});
		$letterWrap.addClass('clone');
		$('body').append($letterWrap);
		//location.hash = id;
		$('html,body').animate({scrollTop: areaListTop}, 500);
	})
	$(document).scroll(function() {
        var scroH = $(document).scrollTop();  //滚动高度
        var viewH = $(window).height();  //可见高度 
        var contentH = $(document).height();  //内容高度
 
        if(scroH >50 && scroH < 100){  //距离顶部大于100px时
			var $letterWrap = $(".clanhall-letter-wrap").clone(true);
			var letterWrapWidth = $('.clanhall-area-list-wrap').width();
			var letterWrapLeft = $(".clanhall-letter-wrap").offset().left;
			var letterWrapHeight = $(".clanhall-letter-wrap").outerHeight(true);
			$letterWrap.css({
				"position": "fixed",
		    	"background": "#fff",
		    	"z-index": "10000",
		    	"top": "0",
		    	"left":letterWrapLeft + 'px',
		    	"width": letterWrapWidth + 'px'
			});
			$letterWrap.addClass('clone');
			$('body').append($letterWrap);
        }
	});
	 $(window).on('scroll',function(){
		 if($(window).scrollTop() <= 1){
			 $(".clanhall-letter-wrap.clone").remove();
		 }
	 })
	$("body").on('mouseenter mouseout','.js-clanhall-pic',function(e){
		var imgUrl = $(this).find('.js-pic-enlarge img').attr('data-url');
		$(this).find('.js-pic-enlarge img').attr('src',imgUrl);
		
		if(imgUrl && imgUrl!=''){
			if(e.type == 'mouseenter'){
				$(this).find('.js-pic-enlarge').fadeIn();
			}else{
				$(this).find('.js-pic-enlarge').fadeOut();
			}
		}
	})
	
	$(".js-clanhall-area-list").on('click','.js-clanhall-item',function(){
		var id = $(this).attr('data-id');
		
		window.open('citang/'+id);
	})
	
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
	function loadAllClanHall(){
		family_loading();
		$.ajax({
			url:URL+'findSClanHallListByAlpha ',
			data:{},
			type: "POST",
			contentType: "application/json;charset=utf-8"
		}).done(function(json){
				if(json){
					var letterListStr = '';
					var clanHallListStr = '';
					
					for(var key in json){
						var letter = key.toUpperCase();
						
						letterListStr += '<li><a href="javascript:void(0)" class="js-anchor-a" data-id="#anchor'+letter+'">'+letter+'</a></li>';
						
						clanHallListStr+='<div class="clanhall-area-item mt15" id="anchor'+letter+'">'+
										 '<div class="title"><font>'+letter+'</font></div>'+
										 '<div class="row clanhall-list mhn">';
						
						for(var j = 0;j<json[key].length;j++){
							
							if(json[key][j].coverImageThumb){
								clanHallListStr+='<div class="col-lg-2 col-md-3 col-sm-4 col-xs-12 col"><div class="clanhall-item js-clanhall-item" data-id="'+json[key][j].id+'"><div class="pic js-clanhall-pic">'+
					             '<img src="'+json[key][j].coverImageThumb+'">'+
					             '<div class="pic-enlarge js-pic-enlarge" style="display:none"><img src="" data-url="'+json[key][j].coverImage+'"></div>'+
				                 '</div><div class="body"><h5 class="name">'+json[key][j].name+'</h5><p class="address" title="'+json[key][j].address+'">'+json[key][j].address+'</p>'+
					             '<p class="desc" title="'+json[key][j].synopsis+'">'+json[key][j].synopsis+'</p></div></div></div>';
							}else{
								clanHallListStr+='<div class="col-lg-2 col-md-3 col-sm-4 col-xs-12 col"><div class="clanhall-item js-clanhall-item" data-id="'+json[key][j].id+'"><div class="pic default js-clanhall-pic">'+
					             '<img src="images/default.png">'+
					             '<div class="pic-enlarge-default js-pic-enlarge" style="display:none"><img src="" data-url=""></div>'+
				                 '</div><div class="body"><h5 class="name">'+json[key][j].name+'</h5><p class="address" title="'+json[key][j].address+'">'+json[key][j].address+'</p>'+
					             '<p class="desc" title="'+json[key][j].synopsis+'">'+json[key][j].synopsis+'</p></div></div></div>';
							}
						}
						
						clanHallListStr+='</div></div>';
					}
					
					$(".js-letter-list").html(letterListStr);
					$(".js-letter-list > li:first-child").addClass('active');
					$(".js-clanhall-area-list").html(clanHallListStr);
				}else{
					
				}
		}).always(function(){
			family_loading();
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