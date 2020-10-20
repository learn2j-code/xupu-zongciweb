$(function(){
	if($("#userName").val()){
		sessionStorage.setItem('userName',$("#userName").val());
		sessionStorage.setItem('userId',$("#userId").val());
		sessionStorage.setItem('userPic',$("#userPic").val());
		sessionStorage.setItem('uniqId',$("#uniqId").val());
		sessionStorage.setItem('userSex',$("#userSex").val());
		sessionStorage.setItem('userFrom',$("#userFrom").val());
		
		window.history.go(-1);
	}else{
		$("#loginDom").css('display','block');
	}
	
})