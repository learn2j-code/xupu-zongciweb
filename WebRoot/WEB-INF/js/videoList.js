$(function(){
	var video, output;
    var scale = 0.8;
    
	var currentDate = getNowFormatDate();
	$(".js-current-date").text(currentDate);
	if(currentDate){
		var cc = new CalendarConverter;
		var currentDateSplit = currentDate.split('-');
		var result = cc.solar2lunar(new Date(parseInt(currentDateSplit[0]), parseInt(currentDateSplit[1]), parseInt(currentDateSplit[2])));
		$(".js-current-old-date").text(result.cYear+result.cMonth+result.lunarDay);
	}
	loadFriendLink();
	
	$(".xupu-nav-items > .li").each(function(index){
		$(this).removeClass('active');
	});
	$(".xupu-nav-items > .li").eq(6).addClass('active');
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
	$('.js-video-list').on('click','.js-video-item',function(){
		var id = $(this).attr('data-id');
		
		window.open('shipins?id='+id);
	})
	ifLogin();
	//loadClanHallVideoList();
	
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
	function loadClanHallVideoList(){
		var params = {};
		params.page = {};
		params.page.start = 1;
		params.page.count = 8;
		family_loading();
		$.ajax({
			url:URL+'findAllMVideoList',
			data:JSON.stringify(params),
			type: "POST",
			contentType: "application/json;charset=utf-8"
		}).done(function(json){
			if(json){
				var str = '';
				var data = json.mvideoList;
				if(data.length > 0){
					for(var i = 0;i<data.length;i++){
					/*str+='<div class="col-lg-3 col-md-4 col-sm-6 col-xs-12 mt15 pln"><div class="clanhall-video-item"><div id="youku" class="youku">'+ 
						 '<video id="my_video_'+(i+1)+'" class="video-js vjs-default-skin" controls  preload="auto" width="100%" height="100%" poster="images/default.png"  data-setup="{}">'+
						 '<source src="'+data[i].videoAddress+'" type="video/mp4"/></video></div>'+
						 '<div class="p10 body js-video-item" data-id="'+data[i].id+'"><h5 class="name">'+data[i].videoTitle+'</h5>'+
						 '<p class="content">'+data[i].videoTitle+'</p></div></div></div>';
					*/
						str+='<div class="col-lg-3 col-md-4 col-sm-6 col-xs-12 mt15 pln"><div class="clanhall-video-item"><div id="youku" class="youku">'+ 
						 '<embed src="'+data[i].videoAddress+'"'+
						 'allowFullScreen="true" quality="high" width="100%" height="100%" align="middle" allowScriptAccess="always" type="application/x-shockwave-flash"></embed></div>'+
						 '<div class="p10 body js-video-item" data-id="'+data[i].id+'"><h5 class="name">'+data[i].videoTitle+'</h5>'+
						 '<p class="content">'+data[i].videoTitle+'</p></div></div></div>';
					}
					$(".js-video-list").html(str);
					
					setVideoCover(data); //设置视频封面
					
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
		                        		p.page.count = 8;

		                                $.ajax({
		                                     url: URL+'findAllBbsArticleList',
		                                     type: 'POST',
		                                     data: JSON.stringify(p),
		                                     contentType: "application/json;charset=utf-8",
		                                     success: function(json2){
		                                    	 if(json2){
		                             				var str = '';
		                             				var data = json2.mvideoList;
		                             				for(var i = 0;i<data.length;i++){
		                             					str+='<div class="col-lg-3 col-md-4 col-sm-6 col-xs-12 mt15 pln"><div class="clanhall-video-item"><div id="youku" class="youku">'+ 
		                       						 '<embed src="'+data[i].videoAddress+'"'+
		                       						 'allowFullScreen="true" quality="high" width="100%" height="100%" align="middle" allowScriptAccess="always" type="application/x-shockwave-flash"></embed></div>'+
		                       						 '<div class="p10 body js-video-item" data-id="'+data[i].id+'"><h5 class="name">'+data[i].videoTitle+'</h5>'+
		                       						 '<p class="content">'+data[i].videoTitle+'</p></div></div></div>';
		                             				}
		                             				$(".js-video-list").html(str);
		                             				
		                             				setVideoCover(data); //设置视频封面
		                                    	 }
		                                    }
		                                });
		                                $('#pagination a').attr('href','javascript:void(0);')
		                            }
		                        };
								$('#pagination').show();
		                        $('#pagination').bootstrapPaginator(options);
		                        $('#pagination a').attr('href','javascript:void(0);')
				}else{
					$('#pagination').hide();
					$(".js-video-list").html('<div style="margin-top: 15px;text-align: center;">非常抱歉,暂无视频</div>');
				}
			}
		}).always(function(){
			family_loading();
		});
	}

    function setVideoCover(data){
    	for(var j=0; j<data.length; j++) {
            $("#my_video_"+(j+1)).on("loadeddata", function (e) {
                var obj = e.target;
                var scale = 0.8;
                var canvas = document.createElement("canvas");
                canvas.width = obj.videoWidth * scale;
                canvas.height = obj.videoHeight * scale;
                canvas.getContext('2d').drawImage(obj, 0, 0, canvas.width, canvas.height);
                obj.setAttribute("poster", canvas.toDataURL("image/png"));
                obj.setAttribute("width",$(this).parent().width()-5);
                obj.setAttribute("height",$(this).parent().height()-35);
            } )
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