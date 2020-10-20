var URL = 'http://www.100citang.cn/zongciweb/';    //http://localhost:8088/zongciweb/   http://www.100citang.cn/zongciweb/
var IMAGEURL = 'http://image.100citang.cn:9880/seo';
var PRO_URL= 'http://www.100citang.cn/zongciweb';
var NEWIMAGEURL = 'http://image.xupu360.com:9280/';

var curDate = new Date();
$(".js-copyright-cur-date").val(curDate.getFullYear());

function GetQueryString(name)
{
     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
     var r = window.location.search.substr(1).match(reg);
     if(r!=null)return  unescape(r[2]); return null;
}
function GetQueryString2()
{
	
	var index = window.location.href.lastIndexOf('/');
	var param = null;
	if(index>-1){
		param = window.location.href.substr(index+1);
	}
	if(param!=null){
		return param;
	}
	
	return null;
}
function getNowFormatDate() {
    var date = new Date();
    var seperator1 = "-";
    var year = date.getFullYear();
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = year + seperator1 + month + seperator1 + strDate;
    return currentdate;
}

function family_loading(){
	var _loading = $("#family_loading");
	var load_html ='<div class="family-loading-wrap"  id="family_loading"><div class="family-loading"><div class="family-loading-container"><img src="images/loading.svg"></div></div></div>';


	if(_loading.length <=0){
		_loading = $(load_html);
		$(document.body).append(_loading);
	}else{
		_loading.toggle();
	}
}

function showMsg(mes,callback,speed){
	var message_html = '<div class="modal fade" tabindex="-1" role="dialog" id="msgModal"><div class="modal-dialog"><div class="modal-content"><div class="modal-header"><h5 class="modal-title">提示</h5></div><div class="modal-body"><span class="text-danger"></span></div></div></div></div>';

	if(!speed){
		speed = 2000;
		}
		
		var $alert = $("#msgModal") ;
		if($alert.length <=0){
		$(document.body).append(message_html);
		$alert = $("#msgModal") ;
		}
		$alert.find(".modal-body span").html(mes);
		$alert.modal('show');
		
		setTimeout(function(){
		$alert.modal('hide');
		if(callback){
			callback();
		}
		},speed);
		
		$alert.on("hidden.bs.modal", function () {
		var index = 0;
		$(".modal").each(function(){
			if($(this).css("display") !== "none") index += 1;
		});
		if(index > 0){
			$("body").addClass("modal-open");
		}else{
			$("body").removeClass("modal-open");
		}
		$alert.off("hidden.bs.modal");
		});
}
function getCookie(name)
{
	var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
	if(arr=document.cookie.match(reg))
	return unescape(arr[2]);
	else
	return null;
}
function getApiAuth(){
	var data = [
		{
		name:'name',
		id:'111',
		address:'update',
		checked: true
		},
		{
		name:'name',
		id:'111',
		address:'add',
		checked: true
		},
		{
		name:'name',
		id:'111',
		address:'delete',
		checked: true
		},
	]
	return data;
}