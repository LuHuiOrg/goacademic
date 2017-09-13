<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="common/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1, maximum-scale=1">
<meta name="renderer" content="webkit">
<title>一个专门做视频教学的网站</title>
<link rel="stylesheet" href="${ctx}/static/css/bootstrap.min.css">
<link rel="stylesheet" href="${ctx}/static/css/base.css">
<link rel="stylesheet" href="${ctx}/static/css/index.css">
</head>
<body>
	<%@ include file="common/top.jsp" %>
	<div class="jumbotron">
	  <div class="container">
	  	<h1>欢迎来到学一手</h1>
		<p>一个专门做视频教学的网站</p>
		<form class="navbar-form navbar-left">
	        <div class="form-group">
	          <input type="text" class="form-control" placeholder="搜索视频">
	        </div>
	        <button type="submit" class="btn btn-default">搜索</button>
	    </form>
	  </div>
	</div>
	<div class="container">
        <div class="course-nav-row">
            <span class="hd label">方向：</span>
            <ul class="nav nav-pills" role="tablist">
			  <li role="presentation" class="active"><a href="#">全部</a></li>
			  <li role="presentation"><a href="#">程序班</a></li>
			  <li role="presentation"><a href="#">专业课</a></li>
			</ul>
        </div>
        <div class="course-nav-row">
            <span class="hd label">分类：</span>
            <ul class="nav nav-pills" role="tablist">
			  <li role="presentation" class="active"><a href="#">全部</a></li>
			  <li role="presentation"><a href="#">R语言</a></li>
			  <li role="presentation"><a href="#">JAVA</a></li>
			  <li role="presentation"><a href="#">C++</a></li>
			  <li role="presentation"><a href="#">电气</a></li>
			  <li role="presentation"><a href="#">经济</a></li>
			</ul>
        </div>
        <div class="course-nav-row">
            <span class="hd label">年级：</span>
            <ul class="nav nav-pills" role="tablist">
			  <li role="presentation" class="active"><a href="#">全部</a></li>
			  <li role="presentation"><a href="#">大一</a></li>
			  <li role="presentation"><a href="#">大二</a></li>
			  <li role="presentation"><a href="#">大三</a></li>
			  <li role="presentation"><a href="#">大四</a></li>
			</ul>
        </div>
	</div>
	<div class="container course-cont">
	  <c:forEach var="course" items="${pageInfo.list }">
	  <div class="col-sm-6 col-md-4">
	    <div class="thumbnail">
	      <a href="${ctx }/course/detail?id=${course.id }"><img src="${course.cover }" alt="课程"></a>
	      <div class="caption">
	        <h3>${course.name }</h3>
	        <p>${course.description }</p>
	        <p><a href="#" onclick="javascript:home.addCart(this);" courseId="${course.id }" class="btn btn-primary buy" role="button">购买</a> <a href="#" class="btn btn-default" role="button">收藏</a></p>
	      </div>
	    </div>
	  </div>
	  </c:forEach>
	</div>
	<%@ include file="common/page.jsp" %>
	<%@ include file="common/bottom.jsp" %>
	<script type="text/javascript" src="${ctx }/static/js/home.js"></script>
</body>
</html>