$(function(){
	var clanHallId = GetQueryString2()||'';
	var AbstractIsShow = true;
    
    loadClanHallInfo(clanHallId);
    loadFriendLink();
    ifLogin();
    
    $(".xupu-nav-items > .li").each(function(index){
		$(this).removeClass('active');
	});
	$(".xupu-nav-items > .li").eq(3).addClass('active');
	
    $("body").on('click','.hall-detail-img-text.right',function(){
      $(this).animate({"right":"0rem"});
      $(this).addClass('left').removeClass('right');
      AbstractIsShow = true;
    })
    $("body").on('click','.hall-detail-img-text.left',function(){
      $(this).animate({"right":"-3rem"});
      $(this).addClass('right').removeClass('left');
      AbstractIsShow = false;
    })
    $(".swiper-button-prev-big").click(function(){
    	$(".swiper-button-prev").trigger('click');
    })
    $(".swiper-button-next-big").click(function(){
    	$(".swiper-button-next").trigger('click');
    });
    $("#loginBtn").click(function(){
		localStorage.setItem('loginSource','http://www.100citang.cn');
		window.location.href= 'login';
	});
    $('#showALlContent').click(function(){
    	localStorage.setItem('loginSource','http://www.100citang.cn/zongciweb/citang/'+clanHallId);
		window.location.href = 'login';
    });
    $('img').error(function(){
        $(this).attr('src', "images/default.png");
        $(this).addClass('clanhall-default-img');
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
    function loadClanHallInfo(){
		var params = {};
		var arr = [];
		if(clanHallId.indexOf('?') != -1){
			arr = clanHallId.split('?');
			params.id = arr[0];
		}else{
			params.id = clanHallId;
		}
		
		family_loading();
		$.ajax({
			url:URL+'findClanHallById',
			data:JSON.stringify(params),
			type: "POST",
			contentType: "application/json;charset=utf-8"
		}).done(function(json){
			if(json){
				var imgArr = json.imageList;
				var str = '';
				var str2 = '';
				var str3 = '';
				if(imgArr.length<=0){
					str+= '<div class="swiper-slide" style="background-color:#dbdbdb;">'+
					'<div class="hall-detail-img-text right js-hall-detail-wrap">'+
    				'<p class="content">无</p>'+
    				'<div class="contract"><div>'+
					'<i class="fa fa-user"></i>'+
					'<font class="contacts">无</font>'+
					'<i class="fa fa-tty ml30"></i>'+
					'<font class="tel">无</font></div>'+
					'<div class="mt10">'+
					'<i class="fa fa-map-marker"></i>'+
					'<font class="address">无</font></div></div></div></div>';
					str2+='<div class="swiper-slide" style="background-color:#dbdbdb;"></div>'
				}else{
					for(var i = 0;i<imgArr.length;i++){
							if(i==0){
								str3+='<div class="hall-detail-img-text left js-hall-detail-wrap">'+
		            				'<p class="content">'+json.synopsis+'</p>'+
		            				'<div class="contract"><div>'+
									'<i class="fa fa-user"></i>'+
									'<font class="contacts">&ensp;'+json.contacts+'</font>'+
									'<i class="fa fa-tty ml30"></i>'+
									'<font class="tel">&ensp;'+json.tel+'</font></div>'+
									'<div class="mt10">'+
									'<font class="address" title="'+json.address+'"><i class="fa fa-map-marker"></i>&ensp;'+json.address+'</font></div></div></div>';
								
								str+= '<div class="swiper-slide"><img id="img'+(i+1)+'" class="js-add-blob" src="'+IMAGEURL+imgArr[i].imageUrl+'" alt="'+json.name+'"></div>';
								str2+='<div class="swiper-slide"><img id="img'+(i+1)+'" class="js-add-blob" src="'+IMAGEURL+imgArr[i].imageUrl+'" alt="'+json.name+'"></div>'
							}else{
								str+= '<div class="swiper-slide"><img id="img'+(i+1)+'" class="js-add-blob" src="'+IMAGEURL+imgArr[i].imageUrl+'" alt="'+json.name+'"></div>';
								str2+='<div class="swiper-slide"><img id="img'+(i+1)+'" class="js-add-blob" src="'+IMAGEURL+imgArr[i].imageUrl+'" alt="'+json.name+'"></div>'
							}
							
						}
				}
				//$(".js-swiper-wrapper").html(str);
				//$(".gallery-top").append(str3);
				//$(".js-thumbs-wrapper").html(str2);
				/*if(json.protectedFlag == null || json.protectedFlag == undefined ||　json.protectedFlag == ''){  //保护字段不存在
					$(".hall-detail-content").html(json.details);
					$("#showALlContent").parent().hide();
				}else{
					if(json.protectedFlag == '0'){  //不保护
						$(".hall-detail-content").html(json.details);
						$("#showALlContent").parent().hide();
					}else{  //开启了保护
						if(localStorage.getItem('userName') && localStorage.getItem('userName') != ''){   //如果用户已登录
							$(".hall-detail-content").html(json.details);
							$("#showALlContent").parent().hide();
						}else{
							$(".hall-detail-content").html(json.introduction);
						}
					}
					
				}*/
				//$(".hall-detail-content").html(json.details);
				$(".js-clan-hall-title").text(json.name);
				
				var index = Math.floor(imgArr.length/2);
				var galleryTop = new Swiper('.gallery-top', {  
					  spaceBetween: 10,
				      navigation: {
				        nextEl: '.swiper-button-next-big',
				        prevEl: '.swiper-button-prev-big',
				      },
				      on: {
				    	  slideChangeTransitionStart: function(){
				    	      /*if(AbstractIsShow){
				    	    	  $(this).animate({"right":"-3rem"});
				    	          $(this).addClass('left').removeClass('right');
				    	      }else{
				    	    	  $(this).animate({"right":"0rem"});
				    	          $(this).addClass('right').removeClass('left');
				    	      }*/
				    	    /*if(AbstractIsShow){
				    	    	  $(".js-hall-detail-wrap").eq(this.activeIndex).animate({"right":"-3rem"});
				    	    	  $(".js-hall-detail-wrap").eq(this.activeIndex).addClass('left').removeClass('right');
				    	    }else{
				    	    	  $(".js-hall-detail-wrap").eq(this.activeIndex).animate({"right":"0rem"});
				    	    	  $(".js-hall-detail-wrap").eq(this.activeIndex).addClass('right').removeClass('left');
				    	    }*/
				    	    },
				    	  },
				    	  pagination: {
				    	        el: '.swiper-pagination',
				    	        type: 'fraction',
				    	        nextEl: '.swiper-button-next-big',
						        prevEl: '.swiper-button-prev-big',
				    	      },
				    });
				var galleryThumbs = new Swiper('.gallery-thumbs', { 
					  spaceBetween: 10,
				      slidesPerView: 7,
				      touchRatio: 0.2,
				      centeredSlides: true,
				      slideToClickedSlide: true,
				      on: {
				    	    init: function(){
				    	      //$(".js-thumbs-wrapper").css({'position':'relative','left':'43%'});
				    	    }, 
				    	  },
				    });
				    galleryTop.controller.control = galleryThumbs;
				    galleryThumbs.controller.control = galleryTop;
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