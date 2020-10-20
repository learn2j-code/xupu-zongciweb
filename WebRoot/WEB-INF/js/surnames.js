$(function(){
	
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
	
	loadSurnamesList();
	loadSurnameInformation();
	loadXuZuInformation();
	loadFriendLink();
	$(".xupu-nav-items > .li").each(function(index){
		$(this).removeClass('active');
	});
	$(".xupu-nav-items > .li").eq(5).addClass('active');
	function loadSurnamesList(){
		var params = {};
		params.moduleName = '百家姓';
		family_loading();
		$.ajax({
			url:URL+'findBJXArticalListByModuleName',
			data:JSON.stringify(params),
			type: "POST",
			contentType: "application/json;charset=utf-8"
		}).done(function(json){
			if(json){
				var str = '';
				for(var key in json){
					var letter = key.toUpperCase();
					str+='<div class="bb-1 pv15">'+
					 '<span class="xupu-surnames-letter pull-left">'+letter+'</span>'+
					 '<div class="flex xupu-surnames-wrap">';
					for(var j = 0;j<json[key].length;j++){
						str+='<div class="clearflex"><a href="http://www.xupu168.com/articleDetail?id='+json[key][j].id+'">'+json[key][j].title+'</a></div>';
					}
					str+='</div></div>';
				}
				$(".js-surnames-wrap").html(str);
			}
		}).always(function(){
			family_loading();
		});
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
					str+='<li title="'+json[i].title+'"><a href="http://www.xupu168.com/articleDetail?id='+json[i].id+'">'+json[i].title+'</a></li>';
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
					str+='<li title="'+json[i].title+'"><a href="http://www.xupu168.com/articleDetail?id='+json[i].id+'">'+json[i].title+'</a></li>';
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
						str+='<li><a href="http://'+json[i].weburl+'">'+json[i].stationName+'</a></li>';
					}
				}
				$(".js-friend-link").html(str);
			}
		}).always(function(){
			family_loading();
		});
	}
	
})