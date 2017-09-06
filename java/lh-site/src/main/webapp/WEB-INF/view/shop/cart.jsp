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
<title>购物车页面</title>
<link rel="stylesheet" href="${ctx}/static/css/bootstrap.min.css">
<link rel="stylesheet" href="${ctx}/static/css/base.css">
<link rel="stylesheet" href="${ctx}/static/css/shop/cart.css">
</head>
<body>
	<%@ include file="../common/top.jsp" %>
	<div class="jumbotron">
	  <div class="container">
	  	<h1>购物车</h1>
		<p>确认需要购买的商品</p>
	  </div>
	</div>
	<div class="container cart">			
		<table class="table">
			<thead><tr> <th></th> <th></th> <th>金额</th> <th>操作</th> <th>总计</th> </tr> </thead>
			<tbody>
				<c:forEach var="course" items="${listCourse }">
					<tr>
						<td><img src="${course.cover }" width="75"></td>
						<td><p>${course.name }</p></td>
						<td>${course.price }</td>
						<td><button class="btn" title="delete"><i class="glyphicon glyphicon-trash"></i></button></td>
						<td>${course.price }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="row">
			<div class="col-xs-4">
				<a href="${ctx }/" class="btn btn-default"><i class="glyphicon glyphicon-chevron-left"></i>继续购物</a>
			</div>
			<div class="col-xs-4 text-center">
				<button class="btn"><i class="glyphicon glyphicon-trash"></i>清空购物车</button>
			</div>
			<div class="col-xs-4">
				<a class="btn btn-primary pull-right" href="${ctx }/shop/order">去结算<i class="glyphicon glyphicon-chevron-right"></i></a>
			</div>
		</div>
	</div>
	<%@ include file="../common/bottom.jsp" %>
</body>
</html>