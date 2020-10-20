$(function(){
	var swiper = new Swiper('.swiper-container', {
	      pagination: {
	        el: '.swiper-pagination',
	      },
	    });
	initClanHallInfo('4');
	initClanHallShow();
	initFriendLink();

	$(".js-clanhall-show-list").on('click','.js-clanhall-item',function(){
		var id = $(this).attr('data-id');
		window.location.href = '../../html/clanHallDetail.html?id='+id;
	})

	$(".js-clanhall-info-list").on('click','.js-clanhall-info-item',function(){
		var id = $(this).attr('data-id');
		window.location.href = 'http://www.100citang.cn/news/articleDetail?id='+id;
	})

	$(".js-clanhall-info-more").click(function(){
		window.location.href = "../../html/clanHallInfo.html";
	});

	$(".js-clanhall-show-more").click(function(){
		window.location.href = "../../html/clanHallShow.html";
	});
	function initClanHallInfo(moduleId){
		var params = {};
		params.moduleId = moduleId;
		params.page = {};
		params.page.start = 1;
		params.page.count = 5;
		family_loading();
		$.ajax({
			url:URL+'findArticalPageByModuleId',
			data:JSON.stringify(params),
			type: "POST",
			contentType: "application/json;charset=utf-8"
		}).done(function(json){
			if(json){
			var str = '';
			var data = json.entryList;
			if(data.length > 0){
				for(var i = 0;i<data.length;i++){
					if(data[i].imageUrl){
						str+='<div class="flex clanhall-info-list js-clanhall-info-item" data-id="'+data[i].id+'"><div>'+
						'<div class="title">'+data[i].title+'</span></div>'+
						'<div class="desc"><span>'+data[i].articalAbstract+'</span></div>'+
						'</div><div class="clearflex pic"><img src="'+data[i].imageUrl+'" alt=""></div></div>';
					}else{
						str+='<div class="flex clanhall-info-list" data-id="'+data[i].id+'"><div>'+
						'<div class="title">>'+data[i].title+'</span></div>'+
						'<div class="desc"><span>'+data[i].articalAbstract+'</span></div>'+
						'</div><div class="clearflex pic"><div><img src="images/default.png"></div></div></div>';
					}
				}
				$(".js-clanhall-info-list").html(str);
			}
		}
		}).always(function(){
			family_loading();
		});
	}
	function initClanHallShow(){
		var params = {};
		params.page = {};
		params.page.start = 1;
		params.page.count = 5;
		$.ajax({
			url:URL+'findNewClanHallListByPage',
			data:JSON.stringify(params),
			type: "POST",
			contentType: "application/json;charset=utf-8"
		}).done(function(json){
			if(json){
				var str = '';
				var data = json.clanHallList;
				if(data.length > 0){
					for(var i = 0;i<data.length;i++){
						if(data[i].imageAddress){
							str = '<div class="js-clanhall-item flex clanhall-show-list" data-id="'+data[i].id+'"><div><h5 class="title">'+data[i].name+'</h5>'+
							      '<div class="content"><span>'+data[i].synopsis+'</span></div>'+
							      '<div class="address"><span>'+data[i].address+'</span></div></div>'+
						          '<div class="clearflex pic"><img src="'+IMAGEURL+data[i].imageAddress+'" alt=""></div></div>';
						}else{
							str = '<div class="flex clanhall-show-list"><div><h5 class="title">'+data[i].name+'</h5>'+
							      '<div class="content"><span>'+data[i].synopsis+'</span></div>'+
							      '<div class="address"><span>'+data[i].address+'</span></div></div>'+
						          '<div class="clearflex pic"><div><img src="images/default.png" alt=""></div></div></div>';
						}
					}
					$(".js-clanhall-show-list").html(str);
				}
			}
		})
	}
	function initClanHallVideo(){
		$.ajax({
			url:URL+'findArticalPageByModuleId',
			data:JSON.stringify(params),
			type: "POST",
			contentType: "application/json;charset=utf-8"
		}).done(function(json){
			if(json){
				if(json){
				var str = '';
				var data = json.entryList;
				if(data.length > 0){
					for(var i = 0;i<data.length;i++){
						if(data[i].imageUrl){
							str+='<div class="flex clanhall-info-list" data-id="'+data[i].id+'"><div>'+
							'<div class="title">>'+data[i].title+'</span></div>'+
							'<div class="desc"><span>'+data[i].articalAbstract+'</span></div>'+
							'</div><div class="clearflex pic"><img src="'+data[i].imageUrl+'" alt=""></div></div>';
						}else{
							str+='<div class="flex mt15 hall-information-item js-hall-information-item" data-id="'+data[i].id+'">'+
							'<div class="clearflex"><a href="javascript:void(0)"><div class="default-img-wrap"><img src="images/default.png"></div></a></div>'+
							'<div class="pl15 content">'+
							'<a href="javascript:void(0)">'+
							'<h5>'+data[i].title+'</h5>'+
							'<p>'+data[i].articalAbstract+'</p></a></div></div>';
							str+='<div class="flex clanhall-info-list" data-id="'+data[i].id+'"><div>'+
							'<div class="title">>'+data[i].title+'</span></div>'+
							'<div class="desc"><span>'+data[i].articalAbstract+'</span></div>'+
							'</div><div class="clearflex pic"><img src="../images/default.png"></div></div>';
						}
						
					}
					$(".js-clanhall-info-list").html(str);
				}
			}
		}
		})
	}
	function initFriendLink(){
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
					str+='<li><a href="http://'+json[i].weburl+'" target="_blank">'+json[i].stationName+'</a></li>';
				}
				$(".js-clanhall-friend-list").html(str);
			}
		});
	}
})