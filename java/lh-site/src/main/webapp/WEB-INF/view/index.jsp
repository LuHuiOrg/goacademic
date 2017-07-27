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
	<%@ include file="common/bottom.jsp" %>
</body>
</html>