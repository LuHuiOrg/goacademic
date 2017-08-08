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
<title>确认订单</title>
<link rel="stylesheet" href="${ctx}/static/css/bootstrap.min.css">
<link rel="stylesheet" href="${ctx}/static/css/base.css">
</head>
<body>
	<%@ include file="../common/top.jsp" %>
	<div class="jumbotron">
	  <div class="container">
	  	<h1>支付中心</h1>
	  </div>
	</div>
	<a href="${ctx }/shop/payment">提交订单</a>
	<%@ include file="../common/bottom.jsp" %>
</body>
</html>