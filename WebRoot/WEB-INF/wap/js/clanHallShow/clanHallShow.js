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
				contentnomore:'已无宗祠',
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
						if(data[i].imageAddress){
						    str+= '<div class="clearflex js-clanhall-item" data-id="'+data[i].id+'"><div class="pic"><img src="'+IMAGEURL+data[i].imageAddress+'" alt=""></div>'+
								  '<span class="title">'+data[i].name+'</span></div>';
						}else{
						    str+= '<div class="clearflex"><div class="pic"><div><img src="../images/default.png" alt=""></div></div>'+
								  '<span class="title">'+data[i].name+'</span></div>';
						}
					}
					$(".js-clanhall-show-list").append(str);

					mui('body').on('tap', '.js-clanhall-item', function() { //给li添加点击事件，直接写普通的a标签或者在元素上加onclick事件不成功
                        var id = $(this).attr('data-id');
						window.location.href = 'clanHallDetail.html?id='+id;
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
	}, 1000);
}
})