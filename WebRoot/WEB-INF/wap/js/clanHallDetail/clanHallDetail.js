$(function(){
	var clanHallId = GetQueryString('id')||'';

	initClanHallInfo();

	function initClanHallInfo(){
		var params = {};
		params.id = clanHallId;;
		family_loading();
		$.ajax({
			url:URL+'findClanHallById',
			data:JSON.stringify(params),
			type: "POST",
			contentType: "application/json;charset=utf-8"
		}).done(function(json){
			if(json){
			var str = '';
			var data = json.imageList;
			if(data.length > 0){
				for(var i = 0;i<data.length;i++){
					if(data[i].imageUrl){
						str+= '<div class="swiper-slide" style="background-image:url('+IMAGEURL+data[i].imageUrl+');background-size: 100% 100%"></div>';
					}
				}
			}
			$(".js-clanhall-banner").html(str);
			var swiper = new Swiper('.swiper-container', {
		      pagination: {
		        el: '.swiper-pagination',
		        type: 'fraction',
		      },
		    });
			$(".js-clanhall-name").text(json.name);
			$(".js-clanhall-content").html(json.details);
			json.contacts = json.contacts == ''?'暂无':json.contacts;
			json.tel = json.tel == ''?'暂无':json.tel;
			json.address = json.address == ''?'暂无':json.address;
			$(".js-claninfo-manager").text(json.contacts);
			$(".js-claninfo-tel").text(json.tel);
			$(".js-claninfo-address").text(json.address);
		}
		}).always(function(){
			family_loading();
		});
	}
})