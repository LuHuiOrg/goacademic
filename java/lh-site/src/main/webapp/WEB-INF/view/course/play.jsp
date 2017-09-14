<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="../common/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1, maximum-scale=1">
<meta name="renderer" content="webkit">
<title>课程详情页</title>
<link rel="stylesheet" href="${ctx}/static/css/bootstrap.min.css">
<link rel="stylesheet" href="${ctx}/static/css/base.css">
<link rel="stylesheet" href="${ctx}/static/css/course/play.css">
</head>
<body>
	<%@ include file="../common/top.jsp" %>
	<!-- <video class="video" preload="auto" autobuffer src="http://47.92.123.48/images/cover/57edd2be-0682-4261-b093-264fc563cf0e.mp4" controls="controls"></video> -->
	<div id="tl_player" style="width: 100%; height: 450px;"></div>
	<div class="panel-group container" id="accordion" role="tablist" aria-multiselectable="true">
	  <c:forEach var="chapterMap" items="${chapterListMap }" varStatus="status">
      	<div class="panel panel-default">
      		<div class="panel-heading" role="tab" id="heading${status.index }">
      			<h4 class="panel-title">
		        	<a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapse${status.index }" aria-expanded="false" aria-controls="collapse${status.index }">第${status.index + 1}章 ${chapterMap.parentChapter.name }</a>
		        </h4>
		    </div>
		    <div id="collapse${status.index }" class="panel-collapse collapse" role="tabpanel" aria-labelledby="heading${status.index }">
		    	<c:if test="${not empty chapterMap.childrenList }">
		    		<ul class="list-group">
				    	<c:forEach var="sonChapter" items="${chapterMap.childrenList }" varStatus="sonstatus">
				      		<li class="list-group-item"><a href="javascript:course.playFlash(${course.id},${sonChapter.id });"><i class="glyphicon glyphicon-play-circle" aria-hidden="true"></i><span class="help-inline">第${sonstatus.index + 1}节 ${sonChapter.name }</span></a></li>
				      	</c:forEach>
			      	</ul>
		    	</c:if>
		    </div>
		</div>
      </c:forEach>
	</div>
	<%@ include file="../common/bottom.jsp" %>
	<script type="text/javascript" src="${ctx }/static/plugin/flowplayer/flowplayer-3.2.11.min.js"></script>
	<script src="${ctx }/static/js/course.js"></script>
	<script type="text/javascript">
		flowplayer("tl_player", "${ctx}/static/plugin/flowplayer/flowplayer-3.2.12.swf", { clip: { url: "http://127.0.0.1:8087/lh-site/course/palyFlash", autoPlay: false, autoBuffering: true} });
		if ('${errorMsg}' != '') {
			layer.alert('${errorMsg}', {icon: 6});
		}
	</script>
</body>
</html>