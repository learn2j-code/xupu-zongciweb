<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<footer class="mt45">
		<div class="container clearfix">
			<div class="xupu-frient-link-wrap clearfix">
				<h5 class="xupu-title">友情链接</h5>
				<ul class="xupu-friend-link clearfix js-friend-link">
					<c:forEach items="${webInfo.slinkurlList}" var="slinkurlList">
					<c:choose><c:when test="${slinkurlList.delFlg == 0}"> <li><a href="http://${slinkurlList.weburl}" target="_blank">${slinkurlList.stationName}</a></li>  </c:when>
					<c:otherwise></c:otherwise>
					</c:choose>
					</c:forEach>
				</ul>
			</div>
			<div class="xupu-footer-copyright">
				<span>© Copyright © 2017-<i id="js-copyright-cur-date">2018</i> 湖南叙谱文化传播有限公司 版权所有 <a href="http://beian.miit.gov.cn" target="_blank">湘ICP备17021134号-3</a></span>
			</div>
			<!-- <div class="flex">
				<div class="xupu-crop-info">
					<span>
						地址: 湖南省长沙岳麓区江岸景苑B座412室
					</span>
					<span>
						Copyright © 2018 湖南叙谱文化传播有限公司版权所有
					</span>
				</div>
				<div>
					<h5  class="xupu-title mt25">联系我们</h5>
					<ul class="xupu-contact mt15">
						<li><i class="fa fa-phone"></i>
							<div class="phone">
								<p><i class="fa fa-phone"></i>&ensp;15273121398</p>
							</div>
						</li>
						<li>
							<i class="fa fa-weixin"></i>
							<div class="weixin">
								<img src="images/weixin.png">
							</div>
						</li>
						<li>      <i class="fa fa-qq"></i>
							<div class="qq">
								<img src="images/qq.png">
							</div>
						</li>
					</ul>
				</div>
			</div> -->
		</div>
		<script>
			(function(){
    		var bp = document.createElement('script');
    		bp.src = "http://push.zhanzhang.baidu.com/push.js";
    		var s = document.getElementsByTagName("script")[0];
    		s.parentNode.insertBefore(bp, s);
    		var curDate = new Date();
    		var curYear = curDate.getFullYear();
    		document.getElementById("js-copyright-cur-date").innerHTML = curYear;
			})();
		</script>
		<script>
			(function(){
			var src = (document.location.protocotocol == "http:")?"http://js.passport.qihucdn.com/11.0.1.js?505fdeb3f675df10e025503d81fcb963":"https://jspassport.ssl.qhimg.com/11.0.1.js?505fdeb3f675df10e025503d81fcb963";
			document.write('<script src="' + src + '" id="sozz"><\/script>');
			})();
		</script>
	</footer>