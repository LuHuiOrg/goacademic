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
	<video class="video" preload="auto" autobuffer src="http://d.itheima.com:81/dc/前端/第一阶段：准备篇/从零到进阶前端与移动开发基础/01 认识网页.mp4" controls="controls"></video>
	<div class="panel-group container" id="accordion" role="tablist" aria-multiselectable="true">
	  <div class="panel panel-default">
	    <div class="panel-heading" role="tab" id="headingOne">
	      <h4 class="panel-title">
	        <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
	          第一章 的撒回复
	        </a>
	      </h4>
	    </div>
	    <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
	        <ul class="list-group">
	          <li class="list-group-item"><a href="/lh-site/course/play"><i class="glyphicon glyphicon-play-circle" aria-hidden="true"></i><span class="help-inline">第一节 的说法哈待会发</span></a></li>
	          <li class="list-group-item"><a href="/lh-site/course/play"><i class="glyphicon glyphicon-play-circle" aria-hidden="true"></i><span class="help-inline">第一节 的说法哈待会发</span></a></li>
	          <li class="list-group-item"><a href="/lh-site/course/play"><i class="glyphicon glyphicon-play-circle" aria-hidden="true"></i><span class="help-inline">第一节 的说法哈待会发</span></a></li>
	        </ul>
	    </div>
	  </div>
	  <div class="panel panel-default">
	    <div class="panel-heading" role="tab" id="headingTwo">
	      <h4 class="panel-title">
	        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
	          第二章 的撒回复
	        </a>
	      </h4>
	    </div>
	    <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
	        <ul class="list-group">
	          <li class="list-group-item"><a href="/lh-site/course/play"><i class="glyphicon glyphicon-play-circle" aria-hidden="true"></i><span class="help-inline">第一节 的说法哈待会发</span></a></li>
	          <li class="list-group-item"><a href="/lh-site/course/play"><i class="glyphicon glyphicon-play-circle" aria-hidden="true"></i><span class="help-inline">第一节 的说法哈待会发</span></a></li>
	          <li class="list-group-item"><a href="/lh-site/course/play"><i class="glyphicon glyphicon-play-circle" aria-hidden="true"></i><span class="help-inline">第一节 的说法哈待会发</span></a></li>
	        </ul>
	    </div>
	  </div>
	  <div class="panel panel-default">
	    <div class="panel-heading" role="tab" id="headingThree">
	      <h4 class="panel-title">
	        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
	          第三章 的撒回复
	        </a>
	      </h4>
	    </div>
	    <div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
	        <ul class="list-group">
	          <li class="list-group-item"><a href="/lh-site/course/play"><i class="glyphicon glyphicon-play-circle" aria-hidden="true"></i><span class="help-inline">第一节 的说法哈待会发</span></a></li>
	          <li class="list-group-item"><a href="/lh-site/course/play"><i class="glyphicon glyphicon-play-circle" aria-hidden="true"></i><span class="help-inline">第一节 的说法哈待会发</span></a></li>
	          <li class="list-group-item"><a href="/lh-site/course/play"><i class="glyphicon glyphicon-play-circle" aria-hidden="true"></i><span class="help-inline">第一节 的说法哈待会发</span></a></li>
	        </ul>
	    </div>
	  </div>
	</div>
	<%@ include file="../common/bottom.jsp" %>
</body>
</html>