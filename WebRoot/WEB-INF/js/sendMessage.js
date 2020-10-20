$(function(){
	/*$('#summernote').summernote({
        height: 500,
        tabsize: 2,
        lang: 'zh-CN',
        focus: true
    });*/
	var um = UM.getEditor('myEditor',{
		autoHeightEnabled: true
	});
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
	
	findBbsSelect();//加载出主题选择框
	ifLogin();
	
	$(".xupu-nav-items > .li").each(function(index){
		$(this).removeClass('active');
	});
	$(".xupu-nav-items > .li").eq(4).addClass('active');
	$("#submitInfo").click(function(){
		uploadInfo();
	});
	$("#cancelBtn").click(function(){
		window.location.href = 'luntans';
	});
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
	function findBbsSelect(){
		$.ajax({
			url:URL+'findAllBbsTypeList',
			data:{},
			type: "POST",
			contentType: "application/json;charset=utf-8"
		}).done(function(json){
			if(json){
				var str = '<option selected value="">选择主题</option>';
				for(var i = 0;i<json.length;i++){
					str += '<option value="'+json[i].id+'">'+json[i].typeName+'</option>';
				}
				$(".js-Bbs-select").append(str);
			}
		})
	}
	function uploadInfo(){
		var params = getInfo();
		family_loading();
		$.ajax({
			url:URL+'addBbsArticle',
			data:JSON.stringify(params),
			type: "POST",
			contentType: "application/json;charset=utf-8"
		}).done(function(json){
			if(json.success=='1'){
				window.location.href = 'luntans';
			}
		}).always(function(){
			family_loading();
		});
	};
	function getInfo(){
		var params = {};
		params.typeId = $(".js-Bbs-select option:selected").val();
		if(params.typeId == ''){
			alert('请选择一个主题');
			return false;
		}
		params.typeName = $(".js-Bbs-select option:selected").text();
		params.bbsTitle = $.trim($(".js-Bbs-title").val());
		params.bbsContent = um.getContent(); //$("#summernote").summernote('code');
		params.nymFlag = $(".js-Bbs-nymFlag").prop('checked')?'1':'0';
		if(params.nymFlag == '0'){
			params.userId = localStorage.getItem('userId');;
			params.userName = localStorage.getItem('userName');
		}
		
		return params;
	}
})