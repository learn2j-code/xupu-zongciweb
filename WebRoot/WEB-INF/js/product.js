$(function(){
	
	var currentDate = getNowFormatDate();
	$(".js-current-date").text(currentDate);
	if(currentDate){
		var cc = new CalendarConverter;
		var currentDateSplit = currentDate.split('-');
		var result = cc.solar2lunar(new Date(parseInt(currentDateSplit[0]), parseInt(currentDateSplit[1]), parseInt(currentDateSplit[2])));
		$(".js-current-old-date").text(result.cYear+result.cMonth+result.lunarDay);
	}
	
	loadProductList(4);
	loadProductList(6);
	loadProductList(7);
	loadProductList(8);
	loadProductList(9);
	loadProductList(10);
	loadHotProduct();
	loadFriendLink();
	ifLogin();
	
	$(".xupu-nav-items > .li").each(function(index){
		$(this).removeClass('active');
	});
	$(".xupu-nav-items > .li").eq(7).addClass('active');
	
	$("#loginBtn").click(function(){
		localStorage.setItem('loginSource','http://www.100citang.cn');
		window.location.href= 'login';
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
	$("body").on('click','.js-product-item',function(){
		var productId = $(this).attr('data-id');
		window.open('productDetail?productId='+productId);
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
	function loadHotProduct(){
		var params = {};
		params.page = {};
		params.page.start = 1;
		params.page.count = 4;
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
						    str+='<div class="col-lg-3 col-md-4 col-sm-6 col-xs-12 phn js-product-item" data-id="'+data[i].id+'">'+
						    	 '<div class="hot-product"><div class="flex info">'+
								 '<div class="clearflex image"><img src="'+NEWIMAGEURL+data[i].coverImageAddress+'" alt="'+data[i].title+'"></div>'+
								 '<div class="content"><div class="name" title="'+data[i].title+'">'+data[i].title+'</div><div class="abs" title="'+data[i].subtitle+'">'+data[i].subtitle+'</div><span class="price">￥'+data[i].price+'</span></div></div></div></div>';
						}else{
							 str+='<div class="col-lg-3 col-md-4 col-sm-6 col-xs-12 phn js-product-item" data-id="'+data[i].id+'">'+
					    	 '<div class="hot-product"><div class="flex info">'+
							 '<div class="clearflex image"><div class="default-img-wrap"><img src="images/default.png" alt="'+data[i].title+'"></div></div>'+
							 '<div class="content"><div class="name" title="'+data[i].title+'">'+data[i].title+'</div><div class="abs" title="'+data[i].subtitle+'">'+data[i].subtitle+'</div><span class="price">￥'+data[i].price+'</span></div></div></div></div>';
						}
					}
					$(".js-hot-product-list").html(str);

				}else{
					$(".js-hot-product-list").html('<p class="text-center" style="margin: 30px auto;">暂无商品</p>');
				}
			}
		}).always(function(){
			family_loading();
		});
	}
	function loadProductList(typeId){
		var params = {};
		params.page = {};
		params.page.start = 1;
		params.page.count = 6;
		params.productInfo = {};
		params.productInfo.typeId = typeId;
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
							str+='<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 ph5 js-product-item" data-id="'+data[i].id+'">'+
								 '<div class="product-item">'+
								 '<div class="product-image"><img src="'+NEWIMAGEURL+data[i].coverImageAddress+'" alt="'+data[i].title+'"></div>'+
								 '<div class="product-title"><span title="'+data[i].title+'">'+data[i].title+'</span></div>'+
								 '<div class="product-abs"><span title="'+data[i].subtitle+'">'+data[i].subtitle+'</span></div></div></div>'
						}else{
							str+='<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 ph5 js-product-item" data-id="'+data[i].id+'">'+
							 '<div class="product-item">'+
							 '<div class="product-image"><div class="default-img-wrap"><img src="images/default.png" alt="'+data[i].title+'"></div></div>'+
							 '<div class="product-title"><span title="'+data[i].title+'">'+data[i].title+'</span></div>'+
							 '<div class="product-abs"><span title="'+data[i].subtitle+'">'+data[i].subtitle+'</span></div></div></div>'
						}
					}
					//$(".js-jiancai-list").html(str);
					switch(typeId){
						case 4:$('.js-jiancai-list').html(str);break;
						case 6:$('.js-diaolan-list').html(str);break;
						case 7:$('.js-zhuangshi-list').html(str);break;
						case 8:$('.js-fengshui-list').html(str);break;
						case 9:$('.js-jishi-list').html(str);break;
						case 10:$('.js-huiwu-list').html(str);break;
					};
					
					/*var pageTotal = json.data.page.totalPage;
					var currentPage = json.data.page.start;
					var pageCount = json.data.page.count;

					var options = {
		                            bootstrapMajorVersion: 3, //版本
		                            currentPage: currentPage, //当前页数
		                            totalPages: pageTotal, //总页数
		                            numberOfPages: pageCount,
		                            itemTexts: function (type, page, current) {
		                                switch (type) {
		                                    case "prev":
		                                        return '<a href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a>';
		                                    case "first":
		                                        return "首页";
		                                    case "last":
		                                        return "尾页";
		                                    case "next":
		                                        return '<a href="#" aria-label="Next"><span aria-hidden="true">&raquo;</span></a>';
		                                    case "page":
		                                        return page;
		                                }
		                            },//点击事件，用于通过Ajax来刷新整个list列表
		                            onPageClicked: function (event, originalEvent, type, page) {
		                            	var p = {};

		                        		p.page = {};
		                        		p.page.start = page;
		                        		p.page.count = 16;

		                                $.ajax({
		                                     url: PRO_URL+'/productinfo/findProductInfoInConditionByPage',
		                                     type: 'POST',
		                                     data: JSON.stringify(p),
		                                     contentType: "application/json;charset=utf-8",
		                                     success: function(json2){
		                                    	 var str = '';
		                         				 var data = json2.data.productInfoList;
		                         				 if(data.length > 0){
		                         					for(var i = 0;i<data.length;i++){
		                         						if(data[i].coverImageAddress){
		                         							str+='<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 ph5">'+
		                         								 '<div class="product-item">'+
		                         								 '<div class="product-image"><img src="'+NEWIMAGEURL+data[i].coverImageAddress+'" alt="'+data[i].title+'"></div0>'+
		                         								 '<div class="product-title"><span>'+data[i].title+'</span></div>'+
		                         								 '<div class="product-abs"><span>'+data[i].subtitle+'</span></div></div></div>'
		                         						}else{
		                         							str+='<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 ph5">'+
		                         							 '<div class="product-item">'+
		                         							 '<div class="product-image"><div class="default-img-wrap"><img src="images/default.png" alt="'+data[i].title+'"></div></div0>'+
		                         							 '<div class="product-title"><span>'+data[i].title+'</span></div>'+
		                         							 '<div class="product-abs"><span>'+data[i].subtitle+'</span></div></div></div>'
		                         						}
		                         					}
		                         					$(".js-jiancai-list").html(str);
		                                    }
		                                   }
		                                });
		                                
		                                $('#pagination a').attr('href','javascript:void(0);')
		                            }
		                        };
		                        $('#pagination').bootstrapPaginator(options);
		                        $('#pagination a').attr('href','javascript:void(0);')*/
				}else{
					//$(".js-jiancai-list").html('<p class="text-center">暂时商品</p>');
					switch(typeId){
						case 4:$('.js-jiancai-list').html('<p class="text-center" style="margin: 30px auto;">暂无商品</p>');break;
						case 6:$('.js-diaolan-list').html('<p class="text-center" style="margin: 30px auto;">暂无商品</p>');break;
						case 7:$('.js-zhuangshi-list').html('<p class="text-center" style="margin: 30px auto;">暂无商品</p>');break;
						case 8:$('.js-fengshui-list').html('<p class="text-center" style="margin: 30px auto;">暂无商品</p>');break;
						case 9:$('.js-jishi-list').html('<p class="text-center" style="margin: 30px auto;">暂无商品</p>');break;
						case 10:$('.js-huiwu-list').html('<p class="text-center" style="margin: 30px auto;">暂无商品</p>');break;
					};
				}
			}
		}).always(function(){
			family_loading();
		});
	}
	function loadFriendLink(){
		var params = {};
		params.websiteId = '2';
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
		});
	}
})