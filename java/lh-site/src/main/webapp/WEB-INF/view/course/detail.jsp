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
<link rel="stylesheet" href="${ctx}/static/css/course/detail.css">
</head>
<body>
	<%@ include file="../common/top.jsp" %>
	<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
	    <ol class="carousel-indicators">
	      <li data-target="#carousel-example-generic" data-slide-to="0" class=""></li>
	      <li data-target="#carousel-example-generic" data-slide-to="1" class=""></li>
	      <li data-target="#carousel-example-generic" data-slide-to="2" class="active"></li>
	    </ol>
	    <div class="carousel-inner" role="listbox">
	      <div class="item">
	        <img data-src="holder.js/900x500/auto/#777:#555/text:First slide" alt="First slide [900x500]" src="${ctx }/static/img/course-banner1.jpg" data-holder-rendered="true">
	      </div>
	      <div class="item">
	        <img data-src="holder.js/900x500/auto/#666:#444/text:Second slide" alt="Second slide [900x500]" src="${ctx }/static/img/course-banner2.jpg" data-holder-rendered="true">
	      </div>
	      <div class="item active">
	        <img data-src="holder.js/900x500/auto/#555:#333/text:Third slide" alt="Third slide [900x500]" src="${ctx }/static/img/course-banner3.jpg" data-holder-rendered="true">
	      </div>
	    </div>
	    <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
	      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
	      <span class="sr-only">Previous</span>
	    </a>
	    <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
	      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
	      <span class="sr-only">Next</span>
	    </a>
	</div>
	<ul id="myTab" class="nav nav-tabs container">
	    <li class="active"><a href="#introduce" data-toggle="tab">课程介绍</a></li>
	    <li><a href="#chapter" data-toggle="tab">课程章节</a></li>
      <li><a href="#consult" data-toggle="tab">课程咨询</a></li>
	</ul>
	<div id="myTabContent" class="tab-content container">
	    <div class="tab-pane fade in active" id="introduce">
	      <p>菜鸟教程是一个提供最新的web技术站点，本站免费提供了建站相关的技术文档，帮助广大web技术爱好者快速入门并建立自己的网站。菜鸟先飞早入行——学的不仅是技术，更是梦想。</p>
	    </div>
	    <div class="tab-pane fade" id="chapter">
	      <p>iOS 是一个由苹果公司开发和发布的手机操作系统。最初是于 2007 年首次发布 iPhone、iPod Touch 和 Apple 
	        TV。iOS 派生自 OS X，它们共享 Darwin 基础。OS X 操作系统是用在苹果电脑上，iOS 是苹果的移动版本。</p>
	    </div>
	    <div class="tab-pane fade" id="consult">
	      <p>jMeter 是一款开源的测试软件。它是 100% 纯 Java 应用程序，用于负载和性能测试。</p>
	    </div>
	</div>
	<%@ include file="../common/bottom.jsp" %>
</body>
</html>