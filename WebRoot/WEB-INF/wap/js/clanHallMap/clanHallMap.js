$(function(){
    
    var map = new AMap.Map('gasMap', {
        resizeEnable: true,
        zoom:11,
    });
    map.setCity('中国');
	
	$("#searchBtn").click(function(){
		var name = $.trim($("#searchName").val());
		
		findClanHallList(null,name);
	});
	$(".js-clanhall-list").on('click','.js-clanhall-item',function(){
		var id = $(this).attr('data-id');
		window.location.href = 'clanHallDetail.html?id='+id;
	})
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
				appendClanHallHtml(json);
				dataMapClick(json,_address);
			}
		}).always(function(){
			family_loading();
		});
	}
	function appendClanHallHtml(data){
		var str = '';
		if(data.length<=0){
			str = '<p style="margin-top: 15px;color: #dbdbdb;text-align: center;font-size: 14px;"><i class="fa fa-exclamation-circle" style="margin-right: 3px;font-size: 14px;"></i>有点小尴尬,暂无查询结果</p>';
			$(".js-clanhall-list").html(str);
			return false;
		}
		for(var i = 0;i<data.length;i++){
		    str += '<div class="flex clanhall-hall-list js-clanhall-item" data-id="'+data[i].id+'"><div class="icon clearflex"><i class="glyphicon glyphicon-map-marker"></i></div>'+
					'<div><h5 class="title">'+data[i].name+'</h5><ul class="contacts">'+
					'<li><span>地&ensp;&ensp;址:</span><span>&ensp;'+data[i].fulladdress+'</span></li>'+
					'<li><span>电&ensp;&ensp;话:</span><span>&ensp;'+data[i].tel+'</span></li>'+
					'<li><span>联系人:</span><span>&ensp;'+data[i].contacts+'</span></li></ul></div></div>';
		}
		$(".js-clanhall-list").html(str);
	}
	function dataMapClick(data_info,areaAdd) {
        /*var map = new BMap.Map("gasMap");
        //var point = new BMap.Point(115.8645218847,28.6876884562);
        map.centerAndZoom('江西');
        map.enableScrollWheelZoom(true);*/
        
        //var map = new BMap.Map("gasMap");    
   
        //map.centerAndZoom(areaAdd);    
        //map.enableScrollWheelZoom(true);
		
		var marker, map = new AMap.Map('clanHallMap', {
		        resizeEnable: true,
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
	        for(var i = 0;i<data_info.length;i++){
	        	var locationArr = data_info[i].coordinate.split(',');
	        	marker = new AMap.Marker({
		            icon: "http://webapi.amap.com/theme/v1.3/markers/n/mark_b.png",
		            position: [parseFloat(locationArr[0]), parseFloat(locationArr[1])]
		        });
	        	marker.setMap(map);
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
                openInfo(title, content, e)
            }
            );
        }
        function openInfo(title, content, e) {
            var p = e.target;
            var point = new BMap.Point(p.getPosition().lng, p.getPosition().lat);
            var infoWindow = new BMap.InfoWindow(content, { width: 200, height: 100, title: title });
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
							'<p class="title"><a href="citang/citangDetail?id='+json[i].id+'"><img src="'+IMAGEURL+json[i].imageAddress+'"><font class="name">'+json[i].name+'</font></a></p>'+
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
							'<p class="title" style="background: #dbdbdb;"><a href="javascript:void(0);"><font class="name">'+json[i].name+'</font></a></p>'+
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
				}
			}
		}).always(function(){
			family_loading();
		});
	}
})
