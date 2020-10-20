$(function(){
	var clanHallId = GetQueryString('id')||'';
	var AbstractIsShow = true;
    
    loadClanHallInfo(clanHallId);
    loadFriendLink();

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
    function loadClanHallInfo(){
		var params = {};
		params.id = clanHallId;
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
								
								str+= '<div class="swiper-slide" style="background-image:url('+IMAGEURL+imgArr[i].imageUrl+')"></div>';
								str2+='<div class="swiper-slide" style="background-image:url('+IMAGEURL+imgArr[i].imageUrl+')"></div>'
							}else{
								str+= '<div class="swiper-slide" style="background-image:url('+IMAGEURL+imgArr[i].imageUrl+')"></div>';
								str2+='<div class="swiper-slide" style="background-image:url('+IMAGEURL+imgArr[i].imageUrl+')"></div>'
							}
							
						}
				}
				$(".js-swiper-wrapper").html(str);
				$(".gallery-top").append(str3);
				$(".js-thumbs-wrapper").html(str2);
				$(".hall-detail-content").html(json.details);
				$(".js-clan-hall-title").text(json.name);
				
				var index = Math.floor(imgArr.length/2);
				var galleryTop = new Swiper('.gallery-top', {  
					  spaceBetween: 10,
				      navigation: {
				        nextEl: '.swiper-button-next',
				        prevEl: '.swiper-button-prev',
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
		params.websiteId = '1';
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
					str+='<li><a href="http://'+json[i].weburl+'">'+json[i].stationName+'</a></li>';
				}
				$(".js-friend-link").html(str);
			}
		}).always(function(){
			family_loading();
		});
	}
})