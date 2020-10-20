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
	$(".xupu-nav-items > .li").eq(7).addClass('active');
	
	loadFriendLink();
	ifLogin();
	
	var params = {};
	var productId = GetQueryString('productId')||'';
	var arr = [];
	family_loading();
	params.id = productId;
	$.ajax({
		url:URL+'/productinfo/findById',
		data:JSON.stringify(params),
		type: "POST",
		contentType: "application/json;charset=utf-8"
	}).done(function(json){
		if(json.success){
			if(json.data.productInfo){
				var productInfo = json.data.productInfo;
				$(".js-product-title > a").text(productInfo.title);
				$(".js-product-sub-title").text(productInfo.subtitle);
				$(".js-product-price").text(productInfo.price);
				if(productInfo.link && productInfo.link.length > 7){
					$(".js-product-link").attr('data-url',productInfo.link);	
				}
				if(productInfo.productPicList && productInfo.productPicList.length>0){
					$(".js-product-img").removeClass('default-img');
					$(".js-product-img").attr('src',NEWIMAGEURL+productInfo.productPicList[0].picAddress);
				}
				$(".js-product-proposer").text('来自'+productInfo.proposer+'推荐');
				$(".js-product-reason").text(productInfo.reason);
			}
		}
	}).always(function(){
		family_loading();
	});
	
	loadLikeProduct();
	
	$("#loginBtn").click(function(){
		localStorage.setItem('loginSource','http://www.100citang.cn');
		window.location.href= 'login';
	});
	$(".js-product-link").click(function(){
		window.open($(this).attr('data-url'));
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
	$("body").on('click','.js-product-item',function(){
		var productId = $(this).attr('data-id');
		window.open('productDetail?productId='+productId);
	})
	function loadLikeProduct(){
		var params = {};
		params.page = {};
		params.page.start = 1;
		params.page.count = 8;
		params.productInfo = {};
		params.productInfo.hotFlag = 1;
		params.productInfo.typeId = 0;
		family_loading();
		$.ajax({
			url:PRO_URL+'/productinfo/findProductInfoInConditionByPage',
			data:JSON.stringify(params),
			type: "POST",
			contentType: "application/json;charset=utf-8"
		}).done(function(json){
			if(json.success){
				var str = '';
				var data = json.data.productInfoList;
				if(data.length > 0){
					for(var i = 0;i<data.length;i++){
						if(data[i].coverImageAddress){
						    str+= '<div class="col-lg-3 col-md-4 col-sm-6 col-xs-6 mt10 js-product-item" data-id="'+data[i].id+'"><div class="recommend-product">'+
								  '<p class="image"><img src="'+NEWIMAGEURL+data[i].coverImageAddress+'" alt="'+data[i].title+'"></p>'+
								  '<div class="title" title="'+data[i].title+'">'+data[i].title+'</div><div class="abs"title="'+data[i].subtitle+'">'+data[i].subtitle+'</div><div class="price">￥<span>'+data[i].price+'</span></div></div></div>';
						}else{
							 str+= '<div class="col-lg-3 col-md-4 col-sm-6 col-xs-6 mt10 js-product-item"  data-id="'+data[i].id+'"><div class="recommend-product">'+
							  '<p class="image"><div class="default-img-wrap"><img src="images/default.png" alt="'+data[i].title+'"></div></p>'+
							  '<div class="title" title="'+data[i].title+'">'+data[i].title+'</div><div class="abs"title="'+data[i].subtitle+'">'+data[i].subtitle+'</div><div class="price">￥<span>'+data[i].price+'</span></div></div></div>';
						}
					}
					$(".js-recommend-product-list").html(str);

				}else{
					$(".js-recommend-product-list").html('<p class="text-center" style="height:50px;line-height: 50px;background: #fff;">暂无商品</p>');
				}
			}
		}).always(function(){
			family_loading();
		});
	}
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