$(function(){
	
	var currentDate = getNowFormatDate();
	$(".js-current-date").text(currentDate);
	if(currentDate){
		var cc = new CalendarConverter;
		var currentDateSplit = currentDate.split('-');
		var result = cc.solar2lunar(new Date(parseInt(currentDateSplit[0]), parseInt(currentDateSplit[1]), parseInt(currentDateSplit[2])));
		$(".js-current-old-date").text(result.cYear+result.cMonth+result.lunarDay);
	}
	
	var params = {};
	var moduleId = GetQueryString('id')||'1';
	var moduleType = GetQueryString('moduleType')||'1';
	
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
	
	if(moduleType == 1){
		$(".js-surname-infor > li").eq(0).addClass('active');
		$(".js-surname-infor > li").eq(1).removeClass('active');
		
		$(".js-infor-wrapï¿½ï¿½ > div").eq(0).css('display','block');
		$(".js-infor-wrap > div").eq(1).css('display','none');
		loadInformationData(2);
	}else{
		$(".js-surname-infor > li").eq(1).addClass('active');
		$(".js-surname-infor > li").eq(0).removeClass('active');
		
		$(".js-infor-wrap > div").eq(1).css('display','block');
		$(".js-infor-wrap > div").eq(0).css('display','none');
		loadInformationData(3);
	}
	
	$('body').on('click','.js-surname-infor > li',function(){
		var moduleId = $(this).attr('data-id');
		$(this).addClass('active').siblings().removeClass('active');
		loadInformationData(moduleId);
	})
	
	loadFriendLink();
	ifLogin();
	
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
			}else{
				$("#userLogin").show();
				$("#logged").hide();
			}
		}else{
			$("#userLogin").show();
			$("#logged").hide();
		}
	}
	function ifExpire(lastLoginTimeStr){ //ÓÃ»§ÊÇ·ñ¹ýÆÚ£¬7ÌìÓÐÐ§Ê±¼ä
		var lastLoginTime = new Date(lastLoginTimeStr);
		var curTime = new Date();
		
		if(curTime - lastLoginTime >= 604800000){  //ÆßÌìÊ±¼ä
			localStorage.setItem('userName','');
			localStorage.setItem('userId','');
			localStorage.setItem('userPic','');
			localStorage.setItem('uniqId','');
			localStorage.setItem('userSex','');
			localStorage.setItem('userFrom','');
			localStorage.setItem('userLastLoginTime','');
			
			return true;  //ÐèÒª×¢Ïú
		}else{   //²»ÐèÒª×¢Ïú
			return false;
		}
	}
	function loadInformationData(moduleId){
		params.moduleId = moduleId;
		params.page = {};
		params.page.start = 1;
		params.page.count = 10;
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
						str+='<li class="js-articl-item" data-id="'+data[i].id+'" title="'+data[i].title+'"><a href="javascript:void(0);">'+data[i].title+'</a><span>2018-3-21</span></li>'
					}
					$(".js-surname-list").html(str);
					
					var pageTotal = json.page.totalPage;
					var currentPage = json.page.start;
					var pageCount = json.page.count;

					var options = {
		                            bootstrapMajorVersion: 3, //ï¿½æ±¾
		                            currentPage: currentPage, //ï¿½ï¿½Ç°Ò³ï¿½ï¿½
		                            totalPages: pageTotal, //ï¿½ï¿½Ò³ï¿½ï¿½
		                            numberOfPages: pageCount,
		                            itemTexts: function (type, page, current) {
		                                switch (type) {
		                                    case "prev":
		                                        return '<a href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a>';
		                                    case "first":
		                                        return "ï¿½ï¿½Ò³";
		                                    case "last":
		                                        return "Î²Ò³";
		                                    case "next":
		                                        return '<a href="#" aria-label="Next"><span aria-hidden="true">&raquo;</span></a>';
		                                    case "page":
		                                        return page;
		                                }
		                            },//ï¿½ï¿½ï¿½ï¿½Â¼ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½Í¨ï¿½ï¿½Ajaxï¿½ï¿½Ë¢ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½listï¿½Ð±ï¿½
		                            onPageClicked: function (event, originalEvent, type, page) {
		                            	var p = {};

		                            	p.moduleId = moduleId;
		                        		p.page = {};
		                        		p.page.start = page;
		                        		p.page.count = 10;

		                                $.ajax({
		                                     url: URL+'findArticalPageByModuleId',
		                                     type: 'POST',
		                                     data: JSON.stringify(p),
		                                     contentType: "application/json;charset=utf-8",
		                                     success: function(json2){
		                                    	 if(json2.entryList.length > 0){
		                                    		var data = json2.entryList;
		                             				var str = '';
		                             				for(var i = 0;i<data.length;i++){
		                             					var dateStr = data[i].releaseDate.substring(0,9);
		                             					str+='<li class="js-articl-item" data-id="'+data[i].id+'" title="'+data[i].title+'"><a href="javascript:void(0);">'+data[i].title+'</a><span>'+dateStr+'</span></li>'
		                             				}
		                             				$(".js-surname-list").html(str);
		                                    	 }
		                                    }
		                                });
		                            }
		                        };
		                        $('#pagination').bootstrapPaginator(options);
				}
			}
		}).always(function(){
			family_loading();
		});
	}
	
	
	$("body").on('click','.js-articl-item',function(){
		var id = $(this).attr('data-id');
		
		//window.location.href="wenzhang/"+id;
		window.open("wenzhang/"+id);
	})
	
	function loadFriendLink(){
		var params = {};
		params.websiteId = '1';
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
		});
	}
})