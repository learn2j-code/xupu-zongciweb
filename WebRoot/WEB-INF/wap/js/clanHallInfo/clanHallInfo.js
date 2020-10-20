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
			params.moduleId = '4';
			params.page = {};
			params.page.start = pageStart;
			params.page.count = newCount;
			$.ajax({
				url:URL+'findArticalPageByModuleId',
				data:JSON.stringify(params),
				type: "POST",
				contentType: "application/json;charset=utf-8"
			}).done(function(json){
				if(json){
				var str = '';
				var data = json.entryList;
				if(data.length > 0){
					pageStart++;
					for(var i = 0;i<data.length;i++){
						if(data[i].imageUrl){
							str+='<div class="flex clanhall-info-list js-clanhall-info-item" data-id="'+data[i].id+'"><div>'+
							'<div class="title">'+data[i].title+'</span></div>'+
							'<div class="desc"><span>'+data[i].articalAbstract+'</span></div>'+
							'</div><div class="clearflex pic"><img src="'+data[i].imageUrl+'" alt=""></div></div>';
						}else{
							str+='<div class="flex clanhall-info-list" data-id="'+data[i].id+'"><div>'+
							'<div class="title">>'+data[i].title+'</span></div>'+
							'<div class="desc"><span>'+data[i].articalAbstract+'</span></div>'+
							'</div><div class="clearflex pic"><img src="../images/default.png"></div></div>';
						}
					}
					$(".js-clanhall-info-list").append(str);

					mui('.js-clanhall-info-list').on('tap', '.js-clanhall-info-item', function() { //给li添加点击事件，直接写普通的a标签或者在元素上加onclick事件不成功
                        var id = $(this).attr('data-id');
						window.location.href = 'http://www.100citang.cn/news/articleDetail?id='+id;
                    });

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