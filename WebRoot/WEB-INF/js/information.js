$(function(){
	var currentDate = getNowFormatDate();
	$(".js-current-date").text(currentDate);
	if(currentDate){
		var cc = new CalendarConverter;
		var currentDateSplit = currentDate.split('-');
		var result = cc.solar2lunar(new Date(parseInt(currentDateSplit[0]), parseInt(currentDateSplit[1]), parseInt(currentDateSplit[2])));
		$(".js-current-old-date").text(result.cYear+result.cMonth+result.lunarDay);
	}
	
	loadFriendLink();
	loadInformationData('4');
	ifLogin();
	
	$(".xupu-nav-items > .li").each(function(index){
		$(this).removeClass('active');
	});
	$(".xupu-nav-items > .li").eq(1).addClass('active');
	
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
	function loadInformationData(moduleId){
		var params = {};
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
						if(data[i].imageUrl){
							str+='<div class="flex mt15 hall-information-item js-hall-information-item" data-id="'+data[i].id+'">'+
							'<div class="clearflex"><a href="wenzhang/'+data[i].id+'" target="_blank"><img src="'+IMAGEURL+data[i].imageUrl+'" alt="'+data[i].title+'"></a></div>'+
							'<div class="pl15 content">'+
							'<a href="wenzhang/'+data[i].id+'" target="_blank">'+
							'<h5>'+data[i].title+'</h5>'+
							'<p>'+data[i].articalAbstract+'</p></a></div></div>';
						}else{
							str+='<div class="flex mt15 hall-information-item js-hall-information-item" data-id="'+data[i].id+'">'+
							'<div class="clearflex"><a href="wenzhang/'+data[i].id+'" target="_blank"><div class="default-img-wrap"><img src="images/default.png" alt="'+data[i].title+'"></div></a></div>'+
							'<div class="pl15 content">'+
							'<a href="wenzhang/'+data[i].id+'">'+
							'<h5>'+data[i].title+'</h5>'+
							'<p>'+data[i].articalAbstract+'</p></a></div></div>';
						}
						
					}
					$(".js-clan-hall-infor-list").html(str);
					$('img').error(function(){
				        $(this).attr('src', "images/default.png");
				        $(this).addClass('clanhall-default-img');
				     });
					var pageTotal = json.page.totalPage;
					var currentPage = json.page.start;
					var pageCount = json.page.count;

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
		                             					if(data[i].imageUrl){
		                        							str+='<div class="flex mt15 hall-information-item js-hall-information-item" data-id="'+data[i].id+'">'+
		                        							'<div class="clearflex"><a href="wenzhang/'+data[i].id+'" target="_blank"><img src="http://image.100citang.cn:9880/seo'+data[i].imageUrl+'"></a></div>'+
		                        							'<div class="pl15 content">'+
		                        							'<a href="wenzhang/'+data[i].id+'" target="_blank">'+
		                        							'<h5>'+data[i].title+'</h5>'+
		                        							'<p>'+data[i].articalAbstract+'</p></a></div></div>';
		                        						}else{
		                        							str+='<div class="flex mt15 hall-information-item js-hall-information-item" data-id="'+data[i].id+'">'+
		                        							'<div class="clearflex"><a href="wenzhang/'+data[i].id+'"><div class="default-img-wrap"><img src="images/default.png"></div></a></div>'+
		                        							'<div class="pl15 content">'+
		                        							'<a href="wenzhang/'+data[i].id+'">'+
		                        							'<h5>'+data[i].title+'</h5>'+
		                        							'<p>'+data[i].articalAbstract+'</p></a></div></div>';
		                        						}
		                             				}
		                             				$(".js-clan-hall-infor-list").html(str);
		                             				$('img').error(function(){
		                        				        $(this).attr('src', "images/default.png");
		                        				        $(this).addClass('clanhall-default-img');
		                        				     });
		                                    	 }
		                                    }
		                                });
		                                
		                                $('#pagination a').attr('href','javascript:void(0);')
		                            }
		                        };
		                        $('#pagination').bootstrapPaginator(options);
		                        $('#pagination a').attr('href','javascript:void(0);')
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