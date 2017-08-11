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
	  <div class="col-sm-6 col-md-4">
	    <div class="thumbnail">
	      <a href="${ctx }/course/detail"><img src="${ctx}/static/img/course.jpg" alt="课程"></a>
	      <div class="caption">
	        <h3>java课程</h3>
	        <p>这是一个非常好的java课程</p>
	        <p><a href="#" class="btn btn-primary buy" role="button">购买</a> <a href="#" class="btn btn-default" role="button">收藏</a></p>
	      </div>
	    </div>
	  </div>
	  <div class="col-sm-6 col-md-4">
	    <div class="thumbnail">
	      <a href="${ctx }/course/detail"><img src="${ctx}/static/img/course.jpg" alt="课程"></a>
	      <div class="caption">
	        <h3>java课程</h3>
	        <p>这是一个非常好的java课程</p>
	        <p><a href="#" class="btn btn-primary buy" role="button">购买</a> <a href="#" class="btn btn-default" role="button">收藏</a></p>
	      </div>
	    </div>
	  </div>
	  <div class="col-sm-6 col-md-4">
	    <div class="thumbnail">
	      <a href="${ctx }/course/detail"><img src="${ctx}/static/img/course.jpg" alt="课程"></a>
	      <div class="caption">
	        <h3>java课程</h3>
	        <p>这是一个非常好的java课程</p>
	        <p><a href="#" class="btn btn-primary buy" role="button">购买</a> <a href="#" class="btn btn-default" role="button">收藏</a></p>
	      </div>
	    </div>
	  </div>
	</div>
	<nav aria-label="Page navigation">
	  <ul class="pagination">
	    <li>
	      <a href="#" aria-label="Previous">
	        <span aria-hidden="true">&laquo;</span>
	      </a>
	    </li>
	    <li><a href="#">1</a></li>
	    <li><a href="#">2</a></li>
	    <li><a href="#">3</a></li>
	    <li><a href="#">4</a></li>
	    <li><a href="#">5</a></li>
	    <li>
	      <a href="#" aria-label="Next">
	        <span aria-hidden="true">&raquo;</span>
	      </a>
	    </li>
	  </ul>
   	</nav>
	<%@ include file="common/bottom.jsp" %>
	<script type="text/javascript">
		$(function(){
			$(".buy").click(function(){
				layer.alert('已成功加入购物车，请到购物车结算', {icon: 6});
			});
		});
	</script>
</body>
</html>