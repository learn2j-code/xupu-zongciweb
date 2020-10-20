$(function(){
	mui.init({
		pullRefresh: {
			container: '#pullrefresh',
			down: {
				style:'circle',
				callback: ''
			},
			up: {
				auto:true,
				contentrefresh: '正在加载...',
				contentnomore:'已无资讯',
				callback: pullupRefresh
			}
		}
	});

	var count = 0;
	var pageStart = 1;
	function pullupRefresh() {
		setTimeout(function() {
			mui('#pullrefresh').pullRefresh().endPullupToRefresh(false); //参数为true代表没有更多数据了。
			var table = document.body.querySelector('.mui-table-view');
			var cells = document.body.querySelectorAll('.mui-table-view-cell');
			var newCount = cells.length>0?3:10;//首次加载20条，满屏
			var params = {};
			params.page = {};
			params.page.start = pageStart;
			params.page.count = newCount;
			$.ajax({
				url:URL+'findNewClanHallListByPage',
				data:JSON.stringify(params),
				type: "POST",
				contentType: "application/json;charset=utf-8"
			}).done(function(json){
				if(json){
				var str = '';
				var data = json.clanHallList;
				if(data.length > 0){
					pageStart++;
					for(var i = 0;i<data.length;i++){
						if(data[i].imageUrl){
							str+='<div class="flex clanhall-info-list" data-id="'+data[i].id+'"><div>'+
							'<div class="title">'+data[i].title+'</span></div>'+
							'<div class="desc"><span>'+data[i].articalAbstract+'</span></div>'+
							'</div><div class="clearflex pic"><img src="'+data[i].imageUrl+'" alt=""></div></div>';
						}else{
							str+='<div class="flex mt15 hall-information-item js-hall-information-item" data-id="'+data[i].id+'">'+
							'<div class="clearflex"><a href="javascript:void(0)"><div class="default-img-wrap"><img src="images/default.png"></div></a></div>'+
							'<div class="pl15 content">'+
							'<a href="javascript:void(0)">'+
							'<h5>'+data[i].title+'</h5>'+
							'<p>'+data[i].articalAbstract+'</p></a></div></div>';
							str+='<div class="flex clanhall-info-list" data-id="'+data[i].id+'"><div>'+
							'<div class="title">>'+data[i].title+'</span></div>'+
							'<div class="desc"><span>'+data[i].articalAbstract+'</span></div>'+
							'</div><div class="clearflex pic"><img src="../../images/default.png"></div></div>';
						}
					}
					$(".js-clanhall-show-list").append(str);

					if(data.length<newCount){
						mui('#pullrefresh').pullRefresh().endPullupToRefresh(true); //参数为true代表没有更多数据了。
					}
				}else{
					mui('#pullrefresh').pullRefresh().endPullupToRefresh(true); //参数为true代表没有更多数据了。
				}
			}else{
				mui('#pullrefresh').pullRefresh().endPullupToRefresh(true); //参数为true代表没有更多数据了。
			}
		})
	}, 1500);
}
})