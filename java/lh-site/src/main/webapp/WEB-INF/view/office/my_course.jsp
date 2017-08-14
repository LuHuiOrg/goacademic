<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="../common/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1, maximum-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="renderer" content="webkit">
<title>我的课程</title>
<link rel="stylesheet" href="${ctx}/static/css/bootstrap.min.css">
<link rel="stylesheet" href="${ctx}/static/css/base.css">
</head>
<body>
	<%@ include file="../common/top.jsp" %>
	<div class="jumbotron">
	  <div class="container">
	  	<h1>昵称</h1>
	  </div>
	</div>
	<div class="container">
		<ul class="list-group col-sm-3">
          <li class="list-group-item">个人资料</li>
          <li class="list-group-item">我的课程</li>
          <li class="list-group-item">我的收藏</li>
        </ul>
        <div class="col-sm-9">
		  <div class="col-sm-6 col-md-4">
		    <div class="thumbnail">
		      <a href="${ctx }/course/play"><img src="${ctx}/static/img/course.jpg" alt="课程"></a>
		      <div class="caption">
		        <h3>java课程</h3>
		        <p>这是一个非常好的java课程</p>
		      </div>
		    </div>
		  </div>
		  <div class="col-sm-6 col-md-4">
		    <div class="thumbnail">
		      <a href="${ctx }/course/play"><img src="${ctx}/static/img/course.jpg" alt="课程"></a>
		      <div class="caption">
		        <h3>java课程</h3>
		        <p>这是一个非常好的java课程</p>
		      </div>
		    </div>
		  </div>
		  <div class="col-sm-6 col-md-4">
		    <div class="thumbnail">
		      <a href="${ctx }/course/play"><img src="${ctx}/static/img/course.jpg" alt="课程"></a>
		      <div class="caption">
		        <h3>java课程</h3>
		        <p>这是一个非常好的java课程</p>
		      </div>
		    </div>
		  </div>
		</div>
	</div>
	<%@ include file="../common/bottom.jsp" %>
</body>
</html>