var URL = 'http://www.100citang.cn/zongciweb/';    //http://localhost:8088/zongciweb/   http://192.168.0.117:8580/zongciweb/
var IMAGEURL = 'http://jpay.100jp.cn/seo';

function GetQueryString(name)
{
     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
     var r = window.location.search.substr(1).match(reg);
     if(r!=null)return  unescape(r[2]); return null;
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
	var load_html ='<div class="family-loading-wrap"  id="family_loading"><div class="family-loading"><div class="family-loading-container"><img src="../images/loading.svg"></div></div></div>';


	if(_loading.length <=0){
		_loading = $(load_html);
		$(document.body).append(_loading);
	}else{
		_loading.toggle();
	}
}