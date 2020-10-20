$(function(){
	var currentDate = getNowFormatDate();
	$(".js-current-date").text(currentDate);
	if(currentDate){
		var cc = new CalendarConverter;
		var currentDateSplit = currentDate.split('-');
		var result = cc.solar2lunar(new Date(parseInt(currentDateSplit[0]), parseInt(currentDateSplit[1]), parseInt(currentDateSplit[2])));
		$(".js-current-old-date").text(result.cYear+result.cMonth+result.lunarDay);
	}
	var $citypicker3 = $('#city-picker3');
    
    var map = new AMap.Map('gasMap', {
        resizeEnable: true,
        zoom:11,
    });
    map.setCity('中国');
	
	loadRecommendHallList();
	loadFriendLink();
	ifLogin();
	
	$(".xupu-nav-items > .li").each(function(index){
		$(this).removeClass('active');
	});
	$(".xupu-nav-items > .li").eq(2).addClass('active');
	
	$("#searchBtn").click(function(){
		var addressStr = $.trim($("#city-picker3").val());
		var addressArr = addressStr.split('/');
		var addressParam = addressArr[addressArr.length-1];
		var name = $.trim($("#searchName").val());
		
		addressParam=addressParam.substring(0,addressParam.length-1);
		findClanHallList(addressParam,name);
	});
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
        function addClickHandler(title, content, marker) {
            marker.addEventListener("click", function (e) {
            	alert('title');
                openInfo(title, content, e)
            }
            );
        }
        function openInfo(title, content, e) {
            var p = e.target;
            var point = new AMap.Point(p.getPosition().lng, p.getPosition().lat);
            var infoWindow = new AMap.InfoWindow(content, { width: 200, height: 100, title: title });
            map.openInfoWindow(infoWindow, point);
        }
    }
	function loadRecommendHallList(){
		var params = {};
		params.page = {};
		params.page.count = 6;
		params.page.start = 1;
		family_loading();
		$.ajax({
			url:URL+'findClanHallListByRecommendFlag',
			data:JSON.stringify(params),
			type: "POST",
			contentType: "application/json;charset=utf-8"
		}).done(function(json){
			if(json){
				json = json.clanHallList;
				if(json.length>0){
					var str = '';
					for(var i = 0;i<json.length;i++){
						if(json[i].imageAddress){
							str+='<div class="col-lg-4 col-md-6 col-sm-12 col-xs-12 mt15">'+
							'<div class="hall-recomment-list js-hall-recomment-list">'+
							'<p class="title"><a href="citang/'+json[i].id+'" target="_blank"><img src="'+IMAGEURL+json[i].imageAddress+'" alt="'+json[i].name+'"><font class="name">'+json[i].name+'</font></a></p>'+
							'<p class="content">'+json[i].synopsis+'</p>'+
							'<div class="contract"><div>'+
							'<i class="fa fa-user"></i>&ensp;'+
							'<font>'+json[i].contacts+'</font>'+
							'<i class="fa fa-tty ml30"></i>&ensp;'+
							'<font>'+json[i].tel+'</font></div>'+
							'<div class="mt10">'+
							'<i class="fa fa-map-marker"></i>&ensp;'+
							'<font>'+json[i].fulladdress+'</font></div></div></div></div>';
						}else{
							str+='<div class="col-lg-4 col-md-6 col-sm-12 col-xs-12 mt15">'+
							'<div class="hall-recomment-list js-hall-recomment-list">'+
							'<p class="title" style="background: #dbdbdb;"><a href="citang/'+json[i].id+'" target="_blank"><span style="display: block;text-align: center;line-height: 2.5rem;"><img src="images/default.png" alt="'+json[i].name+'" style="width: auto;height: auto;"></span><font class="name">'+json[i].name+'</font></a></p>'+
							'<p class="content">'+json[i].synopsis+'</p>'+
							'<div class="contract"><div>'+
							'<i class="fa fa-user"></i>&ensp;'+
							'<font>'+json[i].contacts+'</font>'+
							'<i class="fa fa-tty ml30"></i>&ensp;'+
							'<font>'+json[i].tel+'</font></div>'+
							'<div class="mt10">'+
							'<i class="fa fa-map-marker"></i>&ensp;'+
							'<font>'+json[i].fulladdress+'</font></div></div></div></div>';
						}
						
					}
					$(".js-recomment-list-wrap").html(str);
					$('img').error(function(){
				        $(this).attr('src', "images/default.png");
				        $(this).addClass('clanhall-default-img');
				     });
				}
			}
		}).always(function(){
			family_loading();
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
