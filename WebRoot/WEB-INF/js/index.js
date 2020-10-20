$(function(){
	var currentDate = getNowFormatDate();
	var apiAuthList = getApiAuth();
	
	$(".js-current-date").text(currentDate);
	if(currentDate){
		var cc = new CalendarConverter;
		var currentDateSplit = currentDate.split('-');
		var result = cc.solar2lunar(new Date(parseInt(currentDateSplit[0]), parseInt(currentDateSplit[1]), parseInt(currentDateSplit[2])));
		$(".js-current-old-date").text(result.cYear+result.cMonth+result.lunarDay);
	}
	
	var $citypicker3 = $('#city-picker3');
	
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
	$(".xupu-nav-items > .li").eq(0).addClass('active');
	
	$("body").on('click','.xupu-surnames > div',function(){
		$(this).addClass('active').siblings().removeClass('active');;
	})
	$("body").on('mouseover','.js-surname-item',function(){
		var content = $(this).attr('data-info');

		$(".js-surname-info").html(content);
	})
	//loadShowHallList();
	//findEssenceMessageList();
	ifLogin();
	//loadClanHallShowList();
	
	$("body").on('click','.js-hall-tuijian',function(){
		var id = $(this).attr('data-id');
		//window.location.href = "../citang/citangDetail?id="+id;
		window.open("../citang/"+id);
	})
	$("#searchBtn").click(function(){
		var addressStr = $.trim($("#city-picker3").val());
		var addressArr = addressStr.split('/');
		var addressParam = addressArr[addressArr.length-1];
		var name = $.trim($("#searchName").val());
		
		addressParam=addressParam.substring(0,addressParam.length-1);
		findClanHallList(addressParam,name);
	});
	
	$(".js-uptodate-message-list").on('click','.clanhall-message-list',function(){
		var id = $(this).attr('data-id');
		
		window.open('messageDetail?id='+id);
	})
	
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
	function findClanHallList(_address,_name){
		family_loading();
		var params = {};
		params.address = _address;
		params.name = _name;
		$.ajax({
			url:URL+'findClanHallByAddress',
			data:JSON.stringify(params),
			type: "POST",
			contentType: "application/json;charset=utf-8"
		}).done(function(json){
			if(json){
				if(json.length>0){
					appendClanHallHtml(json);
					dataMapClick(json,_address);
				}
			}
		}).always(function(){
			family_loading();
		});
	}
	function appendClanHallHtml(data){
		var str = '';
		for(var i = 0;i<data.length;i++){
			str += '<div class="hall-result-item mt15 pb15">'+
					'<div class="title"><a href="citang/'+data[i].id+'" target="_blank">'+data[i].name+'</a></div>'+
					'<div class="flex mt15">'+
					'<div class="clearflex">地&emsp;址:</div>'+
					'<div>&ensp;'+data[i].fulladdress+'</div></div></div>';
			
					/*'<div class="flex mt15">'+
					'<div class="clearflex">电&emsp;话:</div>'+
					'<div>&ensp;'+data[i].tel+'</div></div>'+
					'<div class="flex mt15">'+
					'<div class="clearflex">联系人:</div>'+
					'<div>&ensp;'+data[i].contacts+'</div></div>*/
		}
		$(".js-hall-result-wrap").html(str);
	}
	function dataMapClick(data_info,areaAdd) {
        /*var map = new BMap.Map("gasMap");
        //var point = new BMap.Point(115.8645218847,28.6876884562);
        map.centerAndZoom('江西');
        map.enableScrollWheelZoom(true);*/
        
        //var map = new BMap.Map("gasMap");    
   
        //map.centerAndZoom(areaAdd);    
        //map.enableScrollWheelZoom(true);
		
		var marker, map = new AMap.Map('gasMap', {
		        resizeEnable: true,
		        zoomEnable:true,
		        dragEnable: true
		 });
		if(areaAdd){
			map.setCity(areaAdd);
		}else{
			map.setCity('中国');
			
		}
		

		function select(e){
			if(e.poi && e.poi.location) {
				map.setZoom(11);
				map.setCenter(e.poi.location);
			}
		};
        
		addMarker();
		function addMarker() {
	        if (marker) {
	            return;
	        }
	        for(let i = 0;i<data_info.length;i++){
	        	var locationArr = data_info[i].coordinate.split(',');
	        	marker = new AMap.Marker({
		            icon: "http://webapi.amap.com/theme/v1.3/markers/n/mark_b.png",
		            position: [parseFloat(locationArr[0]), parseFloat(locationArr[1])]
		        });
	        	marker.setMap(map);
	        	
	        	marker.on( 'click', handler);
	        	function handler(){
	        		var content = [
	        		    '<div class="clanhall-map-window"><div class="name">'+data_info[i].name+'</div><div class="address"><span>地址:</span><span>'+data_info[i].fulladdress+'</span></div></div>',
	        		];
	        		var infoWindow = new AMap.InfoWindow({
	        			   content: content.join("<br>")  //传入 dom 对象，或者 html 字符串
	        			});
	        		var locationArr = data_info[i].coordinate.split(',');
	        		var position = new AMap.LngLat(parseFloat(locationArr[0]), parseFloat(locationArr[1]));
	        		
	        		infoWindow.open(map, position);
	        	}
	        }
	    }
        /*var nowCity = new BMap.LocalCity();
 	    nowCity.get(myFun);*/
        //for (var i = 0; i < data_info.length; i++) {
        	/*var myIcon = new BMap.Icon("http://7xic1p.com1.z0.glb.clouddn.com/markers.png", new BMap.Size(23, 25), {
                // 指定定位位置
                offset: new BMap.Size(10, 25),
                // 当需要从一幅较大的图片中截取某部分作为标注图标时，需要指定大图的偏移位置   
                imageOffset: new BMap.Size(0, 0 - i * 25) // 设置图片偏移  
            });*/
            /*var locationArr = data_info[i].coordinate.split(',');
            
            var point = new BMap.Point(parseFloat(locationArr[0]),parseFloat(locationArr[1]));//28.6880827201,115.8935121488
            var marker = new BMap.Marker(point);  
            var title = data_info[i].name;
            var content = data_info[i].name;  
            map.addOverlay(marker);
            addClickHandler(title, content, marker)*/
            
           /* var marker = new BMap.Marker(new BMap.Point( '28.6876884562','115.8645218847'),{icon: myIcon});
            var title = data_info[i].name;
            var content = data_info[i].name;
            map.addOverlay(marker);
            addClickHandler(title, content, marker);*/
        //}
        function myFun(result){
    	    var cityName = result.name;
    	    map.setCenter(cityName);
    	}
    }
	function loadShowHallList(){
		var params = {};
		params.page = {};
		params.page.count = 12;
		params.page.start = 1;
		family_loading();
		$.ajax({
			url:URL+'findNewClanHallListByPage',
			data:JSON.stringify(params),
			type: "POST",
			contentType: "application/json;charset=utf-8"
		}).done(function(json){
			if(json){
				json = json.clanHallList;
				if(json.length>0){
					var str = '';
					for(var i = 0;i<json.length;i++){
					 if(json[i].coverImageThumb && json[i].coverImageThumb != ''){
							str+= '<div class="col-lg-3 col-md-4 col-sm-6 col-xs-12 phn"><div class="hall-old-hall-top-show"><div class="hall1">'+
								  '<img src="'+json[i].coverImageThumb+'" alt="'+json[i].name+'" class="images"><div class="hall-more-layer">'+
								  '<font class="title">'+json[i].name+'</font><br>'+
								  '<span class="desc">'+json[i].synopsis+'</span>'+
								  '<a href="citang/'+json[i].id+'" class="morebtn" target="_blank">查看详情>></a></div></div></div></div>';
					 }else{
						 if(json[i].imageAddress){
								str+= '<div class="col-lg-3 col-md-4 col-sm-6 col-xs-12 phn"><div class="hall-old-hall-top-show"><div class="hall1">'+
									  '<img src="'+IMAGEURL+json[i].imageAddress+'" alt="'+json[i].name+'" class="images"><div class="hall-more-layer">'+
									  '<font class="title">'+json[i].name+'</font><br>'+
									  '<span class="desc">'+json[i].synopsis+'</span>'+
									  '<a href="citang/'+json[i].id+'" class="morebtn" target="_blank">查看详情>></a></div></div></div></div>';
							}else{
								str+= '<div class="col-lg-3 col-md-4 col-sm-6 col-xs-12 phn"><div class="hall-old-hall-top-show"><div class="hall1">'+
								  '<span style="display:block;text-align: center;line-height: 2.5rem;"><img src="images/default.png" alt="'+json[i].name+'" class="images" style="width: auto;height: auto;"></span><div class="hall-more-layer">'+
								  '<font class="title">'+json[i].name+'</font><br>'+
								  '<span class="desc">'+json[i].synopsis+'</span>'+
								  '<a href="citang/'+json[i].id+'" class="morebtn" target="_blank">查看详情>></a></div></div></div></div>';
							}
					 }
					 
					}
					$(".js-hall-tuijian-wrap").html(str);
				}
			}
		}).always(function(){
			family_loading();
		});
	}
	function findEssenceMessageList(){   //最新留言
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
				var json = json.bbsArticleList;
				if(json.length > 0){
					for(var i = 0;i<json.length;i++){
						if(!json[i].userName){
							json[i].userName = '游客';
						}
						str+='<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12 mt15"><div class="flex clanhall-message-list" data-id="'+json[i].id+'"><div class="clearflex status"><span>'+json[i].typeName+'</span></div>'+
				    	 '<div class="ml20"><h5 class="title index-t">'+json[i].bbsTitle+'</h5>'+
				    	 '<div class="content h60">'+json[i].bbsContent+'</div><div class="flex info">'+
				    	 '<div class="user">'+json[i].userName+'</div><div class="clearflex browse">'+
				    	 '<a href="javascript:void(0)"><font>浏览数</font> <font>'+json[i].viewNum+'</font></a></div></div></div></div></div>';
					}
					$(".js-uptodate-message-list").html(str);
				}
			}
		}).always(function(){
			family_loading();
		});
	}
})