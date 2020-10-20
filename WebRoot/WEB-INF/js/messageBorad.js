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
	
	$(".xupu-nav-items > .li").each(function(index){
		$(this).removeClass('active');
	});
	$(".xupu-nav-items > .li").eq(4).addClass('active');
	
	$('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
		  var tabName = $(this).attr('href');
		  
		  switch(tabName){
		    case '#whole': window.location.reload(); break;
		    case '#upToDate': findUpToUpdateMessageList(); break;
		    case '#essence': findEssenceMessageList();break;
		    case '#discuss': findOthersMessageList('1');break;
		    case '#help': findOthersMessageList('2');break;
		    case '#original': findOthersMessageList('3');break;
		    case '#share': findOthersMessageList('4');break;
		  }
		  
	})
	
	$("#sendMessage").click(function(){
		if(!localStorage.getItem('userName')){
			localStorage.setItem('loginSource','http://www.100citang.cn/zongciweb/luntan');
			window.location.href = 'login';
		}else{
			window.open('sendMessage');
		}
	});
	
	$("body").on('click','.js-clanhall-message-list',function(){
		var id = $(this).attr('data-id');
		
		window.open('luntan/'+id);
	})
	
	//findAllMessageList();    //查找所有留言
	loadSurnameInformation();
	loadXuZuInformation();
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
	function findAllMessageList(){   //全部留言
		var params = {};
		params.page = {};
		params.page.start = 1;
		params.page.count = 6;
		family_loading();
		$.ajax({
			url:URL+'findAllBbsArticleList',
			data:JSON.stringify(params),
			type: "POST",
			contentType: "application/json;charset=utf-8"
		}).done(function(json){
			if(json){
				var str = '';
				var data = json.bbsArticleList;
				if(data.length > 0){
					for(var i = 0;i<data.length;i++){
					if(!data[i].userName){
						data[i].userName = '游客';
					}
					str+='<div class="flex clanhall-message-list mt15" data-id="'+data[i].id+'"><div class="clearflex status"><span>'+data[i].typeName+'</span></div>'+
			    	 '<div class="ml20"><h5 class="title">'+data[i].bbsTitle+'</h5>'+
			    	 '<div class="content">'+data[i].bbsContent+'</div><div class="flex info">'+
			    	 '<div class="user">'+data[i].userName+'</div><div class="clearflex add-comment">'+
			    	 '<a href="javascript:void(0)"><i class="fa fa-commenting-o"></i>'+
			    	 '<font>添加评论</font></a></div><div class="clearflex browse">'+
			    	 '<a href="javascript:void(0)"><font>浏览数</font> <font>'+data[i].viewNum+'</font></a></div></div>'+
			    	 '<div class="flex mt15 clanhall-video-comment-input" style="display: none;">'+
					 '<div class="position-relative"><input class="input" placeholder="说点什么呢" maxlength="1000">'+
					 '<span class="text">1000</span></div><div class="clearflex ml20"><button type="button" class="button">发 表</button></div></div></div></div>';
					}
					$(".js-message-all-list").html(str);
					
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

		                        		p.page = {};
		                        		p.page.start = page;
		                        		p.page.count = 6;

		                                $.ajax({
		                                     url: URL+'findAllBbsArticleList',
		                                     type: 'POST',
		                                     data: JSON.stringify(p),
		                                     contentType: "application/json;charset=utf-8",
		                                     success: function(json2){
		                                    	 if(json2){
		                             				var str = '';
		                             				var data2 = json2.bbsArticleList;
		                             				for(var i = 0;i<data2.length;i++){
		                             					if(!data2[i].userName){
		                            						data2[i].userName = '游客';
		                            					}
		                             					str+='<div class="flex clanhall-message-list js-clanhall-message-list mt15" data-id="'+data2[i].id+'"><div class="clearflex status"><span>'+data2[i].typeName+'</span></div>'+
		                           			    	 '<div class="ml20"><h5 class="title">'+data2[i].bbsTitle+'</h5>'+
		                           			    	 '<div class="content">'+data2[i].bbsContent+'</div><div class="flex info">'+
		                           			    	 '<div class="user">'+data2[i].userName+'</div><div class="clearflex add-comment">'+
		                           			    	 '<a href="javascript:void(0)"><i class="fa fa-commenting-o"></i>'+
		                           			    	 '<font>添加评论</font></a></div><div class="clearflex browse">'+
		                           			    	 '<a href="javascript:void(0)"><font>浏览数</font> <font>'+data2[i].viewNum+'</font></a></div></div>'+
		                           			    	 '<div class="flex mt15 clanhall-video-comment-input" style="display: none;">'+
		                           					 '<div class="position-relative"><input class="input" placeholder="说点什么呢" maxlength="1000">'+
		                           					 '<span class="text">1000</span></div><div class="clearflex ml20"><button type="button" class="button">发 表</button></div></div></div></div>';
		                             				}
		                             				$(".js-message-all-list").html(str);
		                                    	 }
		                                    }
		                                });
		                                
		                                $('#pagination a').attr('href','javascript:void(0);')
		                            }
		                        };
								$('#pagination').show();
								$("#autoPagination").hide();
		                        $('#pagination').bootstrapPaginator(options);
		                        $('#pagination a').attr('href','javascript:void(0);')
				}else{
					$('#pagination').hide();
					$(".js-message-all-list").html('<div style="margin-top: 15px;text-align: center;">非常抱歉,暂无帖子</div>');
				}
			}
		}).always(function(){
			family_loading();
		});
	}
	function findUpToUpdateMessageList(){   //最新留言
		var params = {};
		params.page = {};
		params.page.start = 1;
		params.page.count = 6;
		family_loading();
		$.ajax({
			url:URL+'findLastestBbsArticleList',
			data:JSON.stringify(params),
			type: "POST",
			contentType: "application/json;charset=utf-8"
		}).done(function(json){
			if(json){
				var str = '';
				var data = json.bbsArticleList;
				if(data.length > 0){
					for(var i = 0;i<data.length;i++){
						if(!data[i].userName){
							data[i].userName = '游客';
						}
						str+='<div class="flex clanhall-message-list js-clanhall-message-list mt15" data-id="'+data[i].id+'"><div class="clearflex status"><a href="javascript:void(0)">'+data[i].typeName+'</a></span></div>'+
				    	 '<div class="ml20"><h5 class="title"><a href="javascript:void(0)">'+data[i].bbsTitle+'</a></h5>'+
				    	 '<a href="javascript:void(0);" class="content">'+data[i].bbsContent+'</a><div class="flex info">'+
				    	 '<div class="user"><a href="javascript:void(0)">'+data[i].userName+'</a></div><div class="clearflex add-comment">'+
				    	 '<a href="javascript:void(0)"><i class="fa fa-commenting-o"></i>'+
				    	 '<font>添加评论</font></a></div><div class="clearflex browse">'+
				    	 '<a href="javascript:void(0)"><font>浏览数</font> <font>'+data[i].viewNum+'</font></a></div></div>'+
				    	 '<div class="flex mt15 clanhall-video-comment-input" style="display: none;">'+
						 '<div class="position-relative"><input class="input" placeholder="说点什么呢" maxlength="1000">'+
						 '<span class="text">1000</span></div><div class="clearflex ml20"><button type="button" class="button">发 表</button></div></div></div></div>';
					}
					$(".js-uptodate-message-list").html(str);
					$("#pagination").show();
					$("#autoPagination").hide();
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

		                        		p.page = {};
		                        		p.page.start = page;
		                        		p.page.count = 6;

		                                $.ajax({
		                                     url: URL+'findLastestBbsArticleList',
		                                     type: 'POST',
		                                     data: JSON.stringify(p),
		                                     contentType: "application/json;charset=utf-8",
		                                     success: function(json2){
		                                    	 if(json2){
		                             				var str = '';
		                             				var data2 = json2.bbsArticleList;
		                             				for(var i = 0;i<data2.length;i++){
		                             					if(!data2[i].userName){
		                            						data2[i].userName = '游客';
		                            					}
		                             					str+='<div class="flex clanhall-message-list js-clanhall-message-list mt15" data-id="'+data2[i].id+'"><div class="clearflex status"><a href="javascript:void(0)">'+data2[i].typeName+'</a></div>'+
		                           			    	 '<div class="ml20"><h5 class="title"><a href="javascript:void(0)">'+data2[i].bbsTitle+'</a></h5>'+
		                           			    	 '<a href="javascript:void(0)" class="content">'+data2[i].bbsContent+'</a><div class="flex info">'+
		                           			    	 '<div class="user"><a href="javascript:void(0)">'+data2[i].userName+'</a></div><div class="clearflex add-comment">'+
		                           			    	 '<a href="javascript:void(0)"><i class="fa fa-commenting-o"></i>'+
		                           			    	 '<font>添加评论</font></a></div><div class="clearflex browse">'+
		                           			    	 '<a href="javascript:void(0)"><font>浏览数</font> <font>'+data2[i].viewNum+'</font></a></div></div>'+
		                           			    	 '<div class="flex mt15 clanhall-video-comment-input" style="display: none;">'+
		                           					 '<div class="position-relative"><input class="input" placeholder="说点什么呢" maxlength="1000">'+
		                           					 '<span class="text">1000</span></div><div class="clearflex ml20"><button type="button" class="button">发 表</button></div></div></div></div>';
		                             				}
		                             				$(".js-uptodate-message-list").html(str);
		                                    	 }
		                                    }
		                                });
		                                $('#pagination a').attr('href','javascript:void(0);')
		                            }
		                        };
							    $('#pagination').show();
							    $("#autoPagination").hide();
		                        $('#pagination').bootstrapPaginator(options);
		                        $('#pagination a').attr('href','javascript:void(0);')
				}else{
					$('#pagination').hide();
					$(".js-uptodate-message-list").html('<div style="margin-top: 15px;text-align: center;">非常抱歉,暂无帖子</div>');
				}
			}
		}).always(function(){
			family_loading();
		});
	}
	function findEssenceMessageList(){   //精华留言
		var params = {};
		params.page = {};
		params.page.start = 1;
		params.page.count = 6;
		family_loading();
		$.ajax({
			url:URL+'findBestBbsArticleList',
			data:JSON.stringify(params),
			type: "POST",
			contentType: "application/json;charset=utf-8"
		}).done(function(json){
			if(json){
				var str = '';
				var data = json.bbsArticleList;
				if(data.length > 0){
					for(var i = 0;i<data.length;i++){
						if(!data[i].userName){
							data[i].userName = '游客';
						}
						str+='<div class="flex clanhall-message-list js-clanhall-message-list mt15" data-id="'+data[i].id+'"><div class="clearflex status"><a href="javascript:void(0)">'+data[i].typeName+'</a></div>'+
				    	 '<div class="ml20"><h5 class="title"><a href="javascript:void(0)">'+data[i].bbsTitle+'</a></h5>'+
				    	 '<a href="javascript:void(0)" class="content">'+data[i].bbsContent+'</a><div class="flex info">'+
				    	 '<div class="user">'+data[i].userName+'</div><div class="clearflex add-comment">'+
				    	 '<a href="javascript:void(0)"><i class="fa fa-commenting-o"></i>'+
				    	 '<font>添加评论</font></a></div><div class="clearflex browse">'+
				    	 '<a href="javascript:void(0)"><font>浏览数</font> <font>'+data[i].viewNum+'</font></a></div></div>'+
				    	 '<div class="flex mt15 clanhall-video-comment-input" style="display: none;">'+
						 '<div class="position-relative"><input class="input" placeholder="说点什么呢" maxlength="1000">'+
						 '<span class="text">1000</span></div><div class="clearflex ml20"><button type="button" class="button">发 表</button></div></div></div></div>';
					}
					$(".js-essence-message-list").html(str);
					$("#pagination").show();
					$("#autoPagination").hide();
					
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

		                        		p.page = {};
		                        		p.page.start = page;
		                        		p.page.count = 6;

		                                $.ajax({
		                                     url: URL+'findBestBbsArticleList',
		                                     type: 'POST',
		                                     data: JSON.stringify(p),
		                                     contentType: "application/json;charset=utf-8",
		                                     success: function(json2){
		                                    	 if(json2){
		                             				var str = '';
		                             				var data2 = json2.bbsArticleList;
		                             				for(var i = 0;i<data2.length;i++){
		                             					if(!data2[i].userName){
		                            						data2[i].userName = '游客';
		                            					}
		                             					str+='<div class="flex clanhall-message-list js-clanhall-message-list mt15" data-id="'+data2[i].id+'"><div class="clearflex status"><a href="javascript:void(0)">'+data2[i].typeName+'</a></div>'+
		                           			    	 '<div class="ml20"><h5 class="title"><a href="javascript:void(0)">'+data2[i].bbsTitle+'</a></h5>'+
		                           			    	 '<a href="javascript:void(0)" class="content">'+data2[i].bbsContent+'</a><div class="flex info">'+
		                           			    	 '<div class="user">'+data2[i].userName+'</div><div class="clearflex add-comment">'+
		                           			    	 '<a href="javascript:void(0)"><i class="fa fa-commenting-o"></i>'+
		                           			    	 '<font>添加评论</font></a></div><div class="clearflex browse">'+
		                           			    	 '<a href="javascript:void(0)"><font>浏览数</font> <font>'+data2[i].viewNum+'</font></a></div></div>'+
		                           			    	 '<div class="flex mt15 clanhall-video-comment-input" style="display: none;">'+
		                           					 '<div class="position-relative"><input class="input" placeholder="说点什么呢" maxlength="1000">'+
		                           					 '<span class="text">1000</span></div><div class="clearflex ml20"><button type="button" class="button">发 表</button></div></div></div></div>';
		                             				}
		                             				$(".js-essence-message-list").html(str);
		                                    	 }
		                                    }
		                                });
		                                $('#pagination a').attr('href','javascript:void(0);')
		                            }
		                        };
								$('#pagination').show();
								$("#autoPagination").hide();
		                        $('#pagination').bootstrapPaginator(options);
		                        $('#pagination a').attr('href','javascript:void(0);')
				}else{
					$('#pagination').hide();
					$(".js-essence-message-list").html('<div style="margin-top: 15px;text-align: center;">非常抱歉,暂无帖子</div>');
				}
			}
		}).always(function(){
			family_loading();
		});
	}
	function findOthersMessageList(typeId){   //精华留言
		var params = {};
		params.typeId = typeId;
		params.page = {};
		params.page.start = 1;
		params.page.count = 6;
		family_loading();
		$.ajax({
			url:URL+'findBbsArticleListByType',
			data:JSON.stringify(params),
			type: "POST",
			contentType: "application/json;charset=utf-8"
		}).done(function(json){
			if(json){
				var str = '';
				var data = json.bbsArticleList;
				if(data.length > 0){
					for(var i = 0;i<data.length;i++){
						if(!data[i].userName){
							data[i].userName = '游客';
						}
					str+='<div class="flex clanhall-message-list js-clanhall-message-list mt15" data-id="'+data[i].id+'"><div class="clearflex status"><a href="javascript:void(0)">'+data[i].typeName+'</a></div>'+
			    	 '<div class="ml20"><h5 class="title"><a href="javascript:void(0)">'+data[i].bbsTitle+'</a></h5>'+
			    	 '<a href="javascript:void(0)" class="content">'+data[i].bbsContent+'</a><div class="flex info">'+
			    	 '<div class="user">'+data[i].userName+'</div><div class="clearflex add-comment">'+
			    	 '<a href="javascript:void(0)"><i class="fa fa-commenting-o"></i>'+
			    	 '<font>添加评论</font></a></div><div class="clearflex browse">'+
			    	 '<a href="javascript:void(0)"><font>浏览数</font> <font>'+data[i].viewNum+'</font></a></div></div>'+
			    	 '<div class="flex mt15 clanhall-video-comment-input" style="display: none;">'+
					 '<div class="position-relative"><input class="input" placeholder="说点什么呢" maxlength="1000">'+
					 '<span class="text">1000</span></div><div class="clearflex ml20"><button type="button" class="button">发 表</button></div></div></div></div>';
					}
					if(typeId=='1'){//讨论
						$(".js-discuss-message-list").html(str);
					}else if(typeId == '2'){//求助
						$(".js-help-message-list").html(str);
					}else if(typeId == '3'){//原创
						$(".js-original-message-list").html(str);
					}else if(typeId == '4'){//分享
						$(".js-share-message-list").html(str);
					}
					$("#pagination").show();
					$("#autoPagination").hide();
					
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

		                        		p.page = {};
		                        		p.page.start = page;
		                        		p.page.count = 6;
		                        		p.typeId = typeId;

		                                $.ajax({
		                                     url: URL+'findBbsArticleListByType',
		                                     type: 'POST',
		                                     data: JSON.stringify(p),
		                                     contentType: "application/json;charset=utf-8",
		                                     success: function(json2){
		                                    	 if(json2){
		                             				var str = '';
		                             				var data2 = json2.bbsArticleList;
		                             				for(var i = 0;i<data2.length;i++){
		                             					if(!data2[i].userName){
		                            						data2[i].userName = '游客';
		                            					}
		                             					str+='<div class="flex clanhall-message-list js-clanhall-message-list mt15" data-id="'+data2[i].id+'"><div class="clearflex status"><a href="javascript:void(0)">'+data2[i].typeName+'</a></div>'+
		                           			    	 '<div class="ml20"><h5 class="title"><a href="javascript:void(0)">'+data2[i].bbsTitle+'</a></h5>'+
		                           			    	 '<a href="javascript:void(0)" class="content">'+data2[i].bbsContent+'</a><div class="flex info">'+
		                           			    	 '<div class="user">'+data2[i].userName+'</div><div class="clearflex add-comment">'+
		                           			    	 '<a href="javascript:void(0)"><i class="fa fa-commenting-o"></i>'+
		                           			    	 '<font>添加评论</font></a></div><div class="clearflex browse">'+
		                           			    	 '<a href="javascript:void(0)"><font>浏览数</font> <font>'+data2[i].viewNum+'</font></a></div></div>'+
		                           			    	 '<div class="flex mt15 clanhall-video-comment-input" style="display: none;">'+
		                           					 '<div class="position-relative"><input class="input" placeholder="说点什么呢" maxlength="1000">'+
		                           					 '<span class="text">1000</span></div><div class="clearflex ml20"><button type="button" class="button">发 表</button></div></div></div></div>';
		                             				}
		                             				if(typeId=='1'){//讨论
		                        						$(".js-discuss-message-list").html(str);
		                        					}else if(typeId == '2'){//求助
		                        						$(".js-help-message-list").html(str);
		                        					}else if(typeId == '3'){//原创
		                        						$(".js-original-message-list").html(str);
		                        					}else if(typeId == '4'){//分享
		                        						$(".js-share-message-list").html(str);
		                        					}
		                                    	 }
		                                    }
		                                });
		                                
		                                $('#pagination a').attr('href','javascript:void(0);')
		                            }
		                        };
							    $('#pagination').show();
							    $("#autoPagination").hide();
		                        $('#pagination').bootstrapPaginator(options);
		                        $('#pagination a').attr('href','javascript:void(0);')
		                        
				}else{
					$('#pagination').hide();
					if(typeId=='1'){//讨论
						$(".js-discuss-message-list").html('<div style="margin-top: 15px;text-align: center;">非常抱歉,暂无帖子</div>');
					}else if(typeId == '2'){//求助
						$(".js-help-message-list").html('<div style="margin-top: 15px;text-align: center;">非常抱歉,暂无帖子</div>');
					}else if(typeId == '3'){//原创
						$(".js-original-message-list").html('<div style="margin-top: 15px;text-align: center;">非常抱歉,暂无帖子</div>');
					}else if(typeId == '4'){//分享
						$(".js-share-message-list").html('<div style="margin-top: 15px;text-align: center;">非常抱歉,暂无帖子</div>');
					}
				}
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
					str+='<li title="'+json[i].title+'"><a href="http://www.xupu168.com/news/articleDetail?id='+json[i].id+'" target="_blank">'+json[i].title+'</a></li>';
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
					str+='<li title="'+json[i].title+'"><a href="http://www.xupu168.com/news/articleDetail?id='+json[i].id+'" target="_blank">'+json[i].title+'</a></li>';
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